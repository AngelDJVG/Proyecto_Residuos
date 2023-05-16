package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.registros.Interface.IConexionBD;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ResiduoDAO {
    
    private final String NOMBRE_COLECCION = "productores";
    private final MongoDatabase BASE_DATOS;
    
    public ResiduoDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    
    public Residuo consultar(ObjectId id) {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        Productor productor = collection.find(eq("listaResiduos._id", id)).first();
        return productor == null ? null : productor.getListaResiduos().stream().filter(residuo -> residuo.getId().equals(id)).findFirst().orElse(null);
    }
}

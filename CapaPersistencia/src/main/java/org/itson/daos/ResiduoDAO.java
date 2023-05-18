/**
 * Clase ResiduoDAO.java creado el 13/05/2023.
 */
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
    /**
     * Método Método constructor por defecto que inicializa el atributo al valor del parámetro enviado
     * @param CONEXION Conexión con la base de datos.
     */
    public ResiduoDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    /**
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo Id del residuo.
     * @return Residuo encontrado, null en caso contrario.
     */
    public Residuo consultar(ObjectId idResiduo) {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        Productor productor = collection.find(eq("listaResiduos._id", idResiduo)).first();
        return productor == null ? null : productor.getListaResiduos().stream().filter(residuo -> residuo.getId().equals(idResiduo)).findFirst().orElse(null);
    }
}

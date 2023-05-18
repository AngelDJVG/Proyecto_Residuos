/**
 * Clase DestinoDAO.java creado el 13/05/2023.
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import org.bson.types.ObjectId;
import org.itson.dominio.Destino;
import org.itson.dominio.Productor;
import org.itson.registros.Interface.IConexionBD;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class DestinoDAO {
    
    private final String NOMBRE_COLECCION = "productores";
    private final MongoDatabase BASE_DATOS;
    /**
     * Método constructor por defecto que inicializa el atributo al valor del parámetro enviado.
     * @param CONEXION Conexion con la base de datos.
     */
    public DestinoDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    /**
     * Método para consultar un destino según la id enviada como parámetro.
     * @param idDestino Id del destino.
     * @return Destino consultado, null si no se encuentra.
     */
    public Destino consultar(ObjectId idDestino) {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        Productor productor = collection.find(eq("listaDestinos._id", idDestino)).first();
        return productor == null ? null : productor.getListaDestinos().stream().filter(residuo -> residuo.getId().equals(idDestino)).findFirst().orElse(null);
    }
}

/**
 * Clase OrdenTrasladoDAO.java 
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.OrdenTraslado;
import org.itson.registros.Interface.IConexionBD;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class OrdenTrasladoDAO extends DAOGeneral<OrdenTraslado>{
    private final MongoDatabase BASE_DATOS;
    private final String NOMBRE_COLECCION = "ordenes_traslados";
    public OrdenTrasladoDAO(IConexionBD conexionBD){
        BASE_DATOS=conexionBD.getBaseDatos();
    }
/**
 * Método para consultar una orden de traslado a partir de su id.
 * @param id Id de la orden de traslado.
 * @return orden de traslado.
 */
@Override
public OrdenTraslado consultar(ObjectId id) {
    MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
    return coleccion.find(eq("_id", id)).first();
}

/**
 * Método que devuelve una lista de ordenes de traslado.
 * @return lista de ordenes de traslado.
 */
@Override
public List<OrdenTraslado> consultarTodos() {
    MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
    return coleccion.find().into(new ArrayList<>());
}
/**
 * Método que agrega una orden de traslado.
 * @param entidad Orden de traslado.
 * @return orden de traslado.
 */
@Override
public OrdenTraslado agregar(OrdenTraslado entidad) {
    MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
    coleccion.insertOne(entidad);
    return entidad;
}
/**
 * Método que actualiza una orden de traslado.
 * @param entidad orden de traslado.
 * @return orden de traslado.
 */
@Override
public OrdenTraslado actualizar(OrdenTraslado entidad) {
    MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
    coleccion.replaceOne(eq("_id", entidad.getId()), entidad);
    return entidad;
}
    
}


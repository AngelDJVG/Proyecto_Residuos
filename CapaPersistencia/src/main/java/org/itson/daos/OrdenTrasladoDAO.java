/**
 * Clase OrdenTrasladoDAO.java
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.OrdenTraslado;
import org.itson.registros.Interface.IConexionBD;

/**
 *
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public class OrdenTrasladoDAO extends DAOGeneral<OrdenTraslado> {

    private final MongoDatabase BASE_DATOS;
    private final String NOMBRE_COLECCION = "ordenes_traslados";

    public OrdenTrasladoDAO(IConexionBD conexionBD) {
        BASE_DATOS = conexionBD.getBaseDatos();
    }

    /**
     * Método para consultar una orden de traslado a partir de su id.
     *
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
     *
     * @return lista de ordenes de traslado.
     */
    @Override
    public List<OrdenTraslado> consultarTodos() {
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        return coleccion.find().into(new ArrayList<>());
    }

    /**
     * Método que agrega una orden de traslado.
     *
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
     *
     * @param entidad orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado actualizar(OrdenTraslado entidad) {
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        coleccion.replaceOne(eq("_id", entidad.getId()), entidad);
        return entidad;
    }

    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor){
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        GregorianCalendar hoy = new GregorianCalendar();
        Calendar hoyInicio = Calendar.getInstance();
        Calendar hoyFin = Calendar.getInstance();
        hoyInicio.set(hoy.get(GregorianCalendar.YEAR), GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH, 0, 0, 0);
        hoyFin.set(hoy.get(GregorianCalendar.YEAR), GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH, 0, 0, 0);
        hoyFin.add(Calendar.DAY_OF_MONTH, 1);

        List<OrdenTraslado> ordenesTraslado = new LinkedList<>();

        coleccion.find(and(
                eq("idProductor",idProductor),
                and(
                        gte("fecha_creacion", hoyInicio), 
                        lt("fecha_creacion", hoyFin
                        )
                )
        )).into(ordenesTraslado);

        return ordenesTraslado;
    }
    
    /**
     * Consulta las ordenes de traslado de un residuo realizadas por un productor.
     * @param idResiduo Es el residuo que se buscará.
     * @return Regresa la lista de ordenes de traslados de un residuo realizadas el día de hoy. 
     */
    public List<OrdenTraslado> consultarOrdenTrasladoResiduo(ObjectId idResiduo){
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        
        GregorianCalendar hoy = new GregorianCalendar();
        Calendar hoyInicio = Calendar.getInstance();
        Calendar hoyFin = Calendar.getInstance();
        hoyInicio.set(hoy.get(GregorianCalendar.YEAR), GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH, 0, 0, 0);
        hoyFin.set(hoy.get(GregorianCalendar.YEAR), GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH, 0, 0, 0);
        hoyFin.add(Calendar.DAY_OF_MONTH, 1);
        
        List<OrdenTraslado> ordenesTraslado = new LinkedList<>();
        
        coleccion.find(and(
                eq("idResiduo",idResiduo),
                and(
                        gte("fecha_creacion", hoyInicio), 
                        lt("fecha_creacion", hoyFin
                        )
                )
        )).into(ordenesTraslado);
        
        return ordenesTraslado;
    }
    
}

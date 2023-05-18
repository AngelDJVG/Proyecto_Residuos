/**
 * Clase OrdenTrasladoDAO.java
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.bson.codecs.jsr310.LocalDateTimeCodec;
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
    /**
     * Método constructor por defecto que inicializa el atributo al valor del parámetro enviado.
     * @param conexionBD Conexión con la base de datos.
     */
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
     * @param ordenTraslado Orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado agregar(OrdenTraslado ordenTraslado) {
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        coleccion.insertOne(ordenTraslado);
        return ordenTraslado;
    }

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param ordenTraslado orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado actualizar(OrdenTraslado ordenTraslado) {
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        coleccion.replaceOne(eq("_id", ordenTraslado.getId()), ordenTraslado);
        return ordenTraslado;
    }
   /**
     * Método que elimina una orden de traslado.
     * @param idTransportista id de orden de traslado a eliminar.
     * @return Valor booleano, true si se eliminó, false en caso contrario.
     */
    public Boolean eliminarOrdenTraslado(ObjectId idTransportista){
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        DeleteResult resultado = coleccion.deleteOne(eq("_id", idTransportista));
        return resultado.getDeletedCount() > 0;
    }
    /**
     * Método que consulta las órdenes de traslado de un productor.
     * @param idProductor Id del productor.
     * @return Lista de órdenes de traslado.
     */
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);
        
        LocalDateTime fechaDeHoy = LocalDateTime.now();
        
        LocalDateTime filtroHoy = LocalDateTime.of(fechaDeHoy.getYear(),fechaDeHoy.getMonth() , fechaDeHoy.getDayOfMonth(), 0, 0, 0);
        LocalDateTime filtroHoyFin = LocalDateTime.of(fechaDeHoy.getYear(),fechaDeHoy.getMonth() , fechaDeHoy.getDayOfMonth(), 23, 59, 59);   
        
        List<OrdenTraslado> ordenesTraslado = new LinkedList<>();

        coleccion.find(and(
                eq("idProductor", idProductor),
                and(
                        gte("fecha_creacion", filtroHoy),
                        lt("fecha_creacion", filtroHoyFin
                        )
                )
        )).into(ordenesTraslado);

        return ordenesTraslado;
    }

    /**
     * Consulta las ordenes de traslado de un residuo realizadas por un
     * productor.
     *
     * @param orden Es la orden que se consultará
     * @return Regresa la lista de ordenes de traslados de un residuo realizadas
     * el día de hoy.
     */
    public List<OrdenTraslado> consultarOrdenTrasladoResiduo(OrdenTraslado orden) {
        MongoCollection<OrdenTraslado> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, OrdenTraslado.class);

         LocalDateTime fechaDeHoy = LocalDateTime.now();
        
        LocalDateTime filtroHoy = LocalDateTime.of(fechaDeHoy.getYear(),fechaDeHoy.getMonth() , fechaDeHoy.getDayOfMonth(), 0, 0, 0);
        LocalDateTime filtroHoyFin = LocalDateTime.of(fechaDeHoy.getYear(),fechaDeHoy.getMonth() , fechaDeHoy.getDayOfMonth(), 23, 59, 59);       
        

        List<OrdenTraslado> ordenesTraslado = new LinkedList<>();

        coleccion.find(and(
                eq("idProductor", orden.getIdProductor()),
                and(
                        eq("idResiduo", orden.getIdResiduo()),
                        and(
                                gte("fecha_creacion", filtroHoy),
                                and(
                                        lt("fecha_creacion", filtroHoyFin)
                                )
                        )
                )
        )).into(ordenesTraslado);

        return ordenesTraslado;
    }

}

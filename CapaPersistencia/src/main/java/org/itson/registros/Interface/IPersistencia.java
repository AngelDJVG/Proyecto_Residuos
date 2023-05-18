/**
 * Clase IPersistencia.java creada el 14/05/2023.
 */
package org.itson.registros.Interface;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.*;

/**
 *
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public interface IPersistencia {
    
    
    /**
     * Método para consultar una orden de traslado a partir de su id.
     *
     * @param id Id de la orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado consultarOrdenTraslado(ObjectId id);

    /**
     * Método que devuelve una lista de ordenes de traslado.
     *
     * @return lista de ordenes de traslado.
     */
    public List<OrdenTraslado> consultarTodosOrdenTraslado();

    /**
     * Método que agrega una orden de traslado.
     *
     * @param ordenTraslado Orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado ordenTraslado);

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param ordenTraslado orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado ordenTraslado);
    /**
     * Método que elimina una orden de traslado.
     * @param idTransportista id de orden de traslado a eliminar.
     * @return Valor booleano, true si se eliminó, false en caso contrario.
     */
    public Boolean eliminarOrdenTraslado(ObjectId idTransportista);
    
    /**
     * Método que consulta un productor.
     * @param idProductor id del productor a consultar.
     * @return Productor encontrado.
     */
    public Productor consultarProductor(ObjectId idProductor);
    /**
     * Método que consulta todos los productores.
     * @return Una lista con todos los productores.
     */
    public List<Productor> consultarTodosProductor();
    /**
     * Método que agrega un productor.
     * @param productor Productor a agregar.
     * @return Productor agregado.
     */
    public Productor agregarProductor(Productor productor);
    /**
     * Método que actualiza un productor.
     * @param productor productor a actualizar.
     * @return productor actualizado.
     */
    public Productor actualizarProductor(Productor productor);
    /**
     * Método que elimina un productor.
     * @param id Id del productor a eliminar.
     * @return productor eliminado.
     */
    
    /**
     * Método que elimina un productor.
     * @param idProductor Id del productor.
     * @return Valor booleano, true si se eliminó, false en caso contrario.
     */
    public Boolean eliminarProductor(ObjectId idProductor);
    
    /**
     * Método que consulta un transportista por id.
     * @param id id del transportista.
     * @return transportista a consultar.
     */
    public Transportista consultarTransportista(ObjectId id);
    /**
     * Método que consulta todos los transportistas.
     * @return Todos los transportistas en una lista.
     */
    public List<Transportista> consultarTodosTransportistas();
    /**
     * Método que agrega un transportista.
     * @param transportista transportista a agregar.
     * @return transportista agregado.
     */
    public Transportista agregarTransportista(Transportista transportista);
    /**
     * Método que actualizar un transportista.
     * @param transportista transportista a actualizar.
     * @return transportista actualizado.
     */
    public Transportista actualizarTransportista(Transportista transportista);
    /**
     * Método que elimina un transportista.
     * @param id id del transportista.
     * @return transportista eliminado.
     */
    public Transportista eliminarTransportista(ObjectId id);
    
    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
    public List<String> consultarListaCorreosTransportistas();
    /**
     * Método que consulta la lista de destinos del productor.
     * @param idProductor Id del productor.
     * @return Lista de destinos del productor.
     */
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor);
     /**
     * Método que regresa una lista de residuos de un productor en específico.
     * @param idProductor Id del productor.
     * @return Lista de residuos del productor.
     */
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor);
    /**
     * Método que consulta el productor predeterminado registrado.
     * @return Productor predeterminado.
     */
     public Productor consultarProductorPredeterminado();
     /**
     * Método que agrega un productor a la base de datos.
     * @return Productor registrado.
     */
     public Productor agregarProductorPredeterminado();
     /**
     * Método para agregar transportistas determinados.
     */
     public void agregarTransportistasPredeterminados();
    /**
     * Método que consulta las órdenes de traslado de un productor.
     * @param idProductor Id del productor.
     * @return Lista de órdenes de traslado.
     */
     public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor);
     /**
     * Consulta las ordenes de traslado de un residuo realizadas por un
     * productor.
     *
     * @param orden Es la orden que se consultará
     * @return Regresa la lista de ordenes de traslados de un residuo realizadas
     * el día de hoy.
     */
     public List<OrdenTraslado> consultarOrdenTrasladoResiduo(OrdenTraslado orden);
     /**
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo Id del residuo.
     * @return Residuo encontrado, null en caso contrario.
     */
     public Residuo consultarResiduo(ObjectId idResiduo);
     /**
     * Método para consultar un destino según la id enviada como parámetro.
     * @param idDestino Id del destino.
     * @return Destino consultado, null si no se encuentra.
     */
     public Destino consultarDestino(ObjectId idDestino);
}

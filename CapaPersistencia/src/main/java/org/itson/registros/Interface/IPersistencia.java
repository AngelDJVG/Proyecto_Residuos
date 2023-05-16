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
     * @param entidad Orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado entidad);

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param entidad orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado entidad);
    /**
     * Método que elimina una orden de traslado.
     * @param id id de orden de traslado a eliminar.
     * @return orden de traslado eliminada.
     */
    public OrdenTraslado eliminarOrdenTraslado(ObjectId id);
    
    /**
     * Método que consulta un productor.
     * @param id id del productor a consultar.
     * @return Productor encontrado.
     */
    public Productor consultarProductor(ObjectId id);
    /**
     * Método que consulta todos los productores.
     * @return Una lista con todos los productores.
     */
    public List<Productor> consultarTodosProductor();
    /**
     * Método que agrega un productor.
     * @param entidad Productor a agregar.
     * @return Productor agregado.
     */
    public Productor agregarProductor(Productor entidad);
    /**
     * Método que actualiza un productor.
     * @param entidad productor a actualizar.
     * @return productor actualizado.
     */
    public Productor actualizarProductor(Productor entidad);
    /**
     * Método que elimina un productor.
     * @param id Id del productor a eliminar.
     * @return productor eliminado.
     */
    public Productor eliminarProductor(ObjectId id);
    
  
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
     * @param entidad transportista a agregar.
     * @return transportista agregado.
     */
    public Transportista agregarTransportista(Transportista entidad);
    /**
     * Método que actualizar un transportista.
     * @param entidad transportista a actualizar.
     * @return transportista actualizado.
     */
    public Transportista actualizarTransportista(Transportista entidad);
    /**
     * Método que elimina un transportista.
     * @param id id del transportista.
     * @return transportista eliminado.
     */
    public Transportista eliminarTransportista(ObjectId id);
    
    
    public List<String> consultarListaCorreosTransportistas();
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor);
    public List<Residuo> consultarListaResiduosProductor(ObjectId id);
     public Productor consultarProductorPredeterminado();
     public Productor agregarProductorPredeterminado();
     public void agregarTransportistasPredeterminados();
     public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor);
     public List<OrdenTraslado> consultarOrdenTrasladoResiduo(ObjectId idResiduo);
     public Residuo consultarResiduo(ObjectId idResiduo);
     public Destino consultarDestino(ObjectId idDestino);
}

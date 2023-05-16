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

    public ConstituyenteQuimico consultarConstituyenteQuimico(ObjectId id);
    /**
     * Método para consultar todos los constituyentes quimicos.
     * @return Todos los constituyentes en una lista.
     */
    public List<Destino> consultarTodosConstituyentesQuimicos();
    /**
     * Método que agrega un constituyente quimico.
     * @param entidad constituyente quimico a agregar.
     * @return constituyente quimico agregado.
     */
    public ConstituyenteQuimico agregarConstituyenteQuimico(ConstituyenteQuimico entidad);
    /**
     * Método que actualiza un constituyente quimico.
     * @param entidad constituyente quimico a actualizar.
     * @return constituyente quimico actualizado.
     */
    public ConstituyenteQuimico actualizarConstituyenteQuimico(ConstituyenteQuimico entidad);
    /**
     * Método que elimina un constituyente quimico. 
     * @param id Id del constituyente quimico a eliminar.
     * @return constituyente quimico eliminado.
     */
    public ConstituyenteQuimico eliminarConstituyenteQuimico(ObjectId id);
    
    /**
     * Método para consultar un destino a partir de su id.
     * @param id Id del destino.
     * @return destino.
     */
    public Destino consultarDestino (ObjectId id);
    /**
     * Método para consultar todos los destinos.
     * @return Todos los destinos en una lista.
     */
    public List<Destino> consultarTodosDestinos();
    /**
     * Método que agrega un destino.
     * @param entidad Destino a agregar.
     * @return Destino agregado.
     */
    public Destino agregarDestino(Destino entidad);
    /**
     * Método que actualiza un destino.
     * @param entidad Destino a actualizar.
     * @return Destino actualizado.
     */
    public Destino actualizarDestino(Destino entidad);
    /**
     * Método que elimina un destino.
     * @param id Id del destino a eliminar.
     * @return Destino eliminado.
     */
    public Destino eliminarDestino(ObjectId id);
    
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
    
    public Productor consultarProductor(ObjectId id);
    public List<Productor> consultarTodosProductor();
    public Productor agregarProductor(Productor entidad);
    public Productor actualizarProductor(Productor entidad);
    public Productor eliminarProductor(ObjectId id);
    
    public Residuo consultarResiduo(ObjectId id);
    public List<Residuo> consultarTodosResiduos();
    public Residuo agregarResiduo(Residuo entidad);
    public Residuo actualizarResiduo(Residuo entidad);
    public Residuo eliminarResiduo(ObjectId id);
    
    public Transportista consultarTransportista(ObjectId id);
    public List<Transportista> consultarTodosTransportistas();
    public Transportista agregarTransportista(Transportista entidad);
    public Transportista actualizarTransportista(Transportista entidad);
    public Transportista eliminarTransportista(ObjectId id);
    
    public Traslado consultarTraslado(ObjectId id);
    public List<Traslado> consultarTodosTraslados();
    public Traslado agregarTraslado(Traslado entidad);
    public Traslado actualizarTraslado(Traslado entidad);
    public Traslado eliminarTraslado(ObjectId id);
}

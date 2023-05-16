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
     * Método para consultar un constituyente quimico.
     * @param id id del constituyente quimico a consultar.
     * @return constituyente quimico encontrado.
     */
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
     * Método que consulta un residuo por id.
     * @param id id del residuo a consultar.
     * @return residuo encontrado.
     */
    public Residuo consultarResiduo(ObjectId id);
    /**
     * Método que consulta todos los residuos.
     * @return todos los residuos en una lista.
     */
    public List<Residuo> consultarTodosResiduos();
    /**
     * Método que agrega un residuo.
     * @param entidad residuo a agregar
     * @return residuo agregado.
     */
    public Residuo agregarResiduo(Residuo entidad);
    /**
     * Método que actualiza un residuo.
     * @param entidad residuo a actualizar.
     * @return residuo actualizado.
     */
    public Residuo actualizarResiduo(Residuo entidad);
    /**
     * Método que elimina un residuo.
     * @param id id del residuo a eliminar.
     * @return residuo eliminado.
     */
    public Residuo eliminarResiduo(ObjectId id);
    
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
    
    /**
     * Método que consulta un traslado por su id.
     * @param id id del traslado.
     * @return traslado encontrado.
     */
    public Traslado consultarTraslado(ObjectId id);
    /**
     * Método que consulta todos los traslados.
     * @return todos los traslados en una lista.
     */
    public List<Traslado> consultarTodosTraslados();
    /**
     * Método que agrega un traslado.
     * @param entidad traslado a agregar.
     * @return traslado agregado.
     */
    public Traslado agregarTraslado(Traslado entidad);
    /**
     * Método que actualiza un traslado.
     * @param entidad traslado a actualizar.
     * @return traslado actualizado.
     */
    public Traslado actualizarTraslado(Traslado entidad);
    /**
     * Método que elimina un traslado.
     * @param id id del traslado a eliminar.
     * @return traslado eliminado.
     */
    public Traslado eliminarTraslado(ObjectId id);
}

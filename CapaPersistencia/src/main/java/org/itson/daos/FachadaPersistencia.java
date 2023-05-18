/**
 * Clase FechadaPersistencia.java creada el 14/05/2023.
 */
package org.itson.daos;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.ConstituyenteQuimico;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.dominio.Transportista;
import org.itson.dominio.Traslado;
import org.itson.registros.Interface.IConexionBD;
import org.itson.registros.Interface.IPersistencia;

/**
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public class FachadaPersistencia implements IPersistencia {

    private IConexionBD conexionBD;
    private OrdenTrasladoDAO ordenTrasladoDAO;
    private ProductorDAO productorDAO;
    private TransportistaDAO transportistaDAO;
    private ResiduoDAO residuoDAO;
    private DestinoDAO destinoDAO;

    /**
     * Método constructor que inicializa los atributos de la clase.
     */
    public FachadaPersistencia() {
        conexionBD = new ConexionBD("residuos");
        ordenTrasladoDAO = new OrdenTrasladoDAO(conexionBD);
        productorDAO = new ProductorDAO(conexionBD);
        transportistaDAO = new TransportistaDAO(conexionBD);
        residuoDAO = new ResiduoDAO(conexionBD);
        destinoDAO = new DestinoDAO(conexionBD);
    }

    /**
     * Método para consultar una orden de traslado a partir de su id.
     *
     * @param id Id de la orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado consultarOrdenTraslado(ObjectId id) {
        return ordenTrasladoDAO.consultar(id);
    }

    /**
     * Método que devuelve una lista de ordenes de traslado.
     *
     * @return lista de ordenes de traslado.
     */
    @Override
    public List consultarTodosOrdenTraslado() {
        return ordenTrasladoDAO.consultarTodos();
    }

    /**
     * Método que agrega una orden de traslado.
     *
     * @param ordenTraslado Orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado ordenTraslado) {
        return ordenTrasladoDAO.agregar(ordenTraslado);
    }

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param ordenTraslado orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado ordenTraslado) {
        return ordenTrasladoDAO.actualizar(ordenTraslado);
    }
    /**
     * Método que elimina una orden de traslado.
     * @param idTransportista id de orden de traslado a eliminar.
     * @return Valor booleano, true si se eliminó, false en caso contrario.
     */
    @Override
    public Boolean eliminarOrdenTraslado(ObjectId idTransportista) {
        return ordenTrasladoDAO.eliminarOrdenTraslado(idTransportista);
    }
    /**
     * Método que consulta a un productor a partir de la id enviada como parámetro.
     * @param idProductor Id del productor. 
     * @return Productor si se encontró, null en caso contrario.
     */
    @Override
    public Productor consultarProductor(ObjectId idProductor) {
        return productorDAO.consultar(idProductor);
    }
    /**
     * Método que consulta todos los productores de la base de datos.
     * @return Lista de productores.
     */
    @Override
    public List<Productor> consultarTodosProductor() {
        return productorDAO.consultarTodos();
    }
     /**
     * Método que agrega un productor a la base de datos.
     * @param productor Productor a agregar.
     * @return Productor agregado.
     */
    @Override
    public Productor agregarProductor(Productor productor) {
        return productorDAO.agregar(productor);
    }
    /**
     * Método que actualiza un productor.
     * @param productor Productor a actualizar.
     * @return Productor actualizado.
     */
    @Override
    public Productor actualizarProductor(Productor productor) {
        return productorDAO.actualizar(productor);
    }
    /**
     * Método que elimina un productor.
     * @param idProductor Id del productor.
     * @return Valor booleano, true si se eliminó, false en caso contrario.
     */
    @Override
    public Boolean eliminarProductor(ObjectId idProductor) {
      return productorDAO.eliminarProductor(idProductor);
    }
    /**
     * Método para consultar un transportista a partir de su Id.
     * @param idTransportista Id del transportista.
     * @return Transportista encontrado, null en caso contrario.
     */
    @Override
    public Transportista consultarTransportista(ObjectId idTransportista) {
        return transportistaDAO.consultar(idTransportista);
    }
    /**
     * Método que consulta la lista de transportistas de la base de datos.
     * @return Lista de transportistas.
     */
    @Override
    public List<Transportista> consultarTodosTransportistas() {
        return transportistaDAO.consultarTodos();
    }
    /**
     * Método que agrega a un transportista a la base de datos.
     * @param transportista Transportista a agregar.
     * @return Transportista agregado.
     */
    @Override
    public Transportista agregarTransportista(Transportista transportista) {
        return transportistaDAO.agregar(transportista);
    }
    /**
     * Método para actualizar un transportista.
     * @param transportista Transportista a actualizar.
     * @return Transportista actualizado.
     */
    @Override
    public Transportista actualizarTransportista(Transportista transportista) {
        return transportistaDAO.actualizar(transportista);
    }
    
    @Override
    public Transportista eliminarTransportista(ObjectId id) {
        //No se ocupa para el caso de uso
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
     @Override
    public List<String> consultarListaCorreosTransportistas(){
        return transportistaDAO.consultarCorreosTransportistas();
    }
    /**
     * Método que consulta la lista de destinos del productor.
     * @param idProductor Id del productor.
     * @return Lista de destinos del productor.
     */
     @Override
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor){
        return productorDAO.consultarListaDestinosProductor(idProductor);
    }
     /**
     * Método que regresa una lista de residuos de un productor en específico.
     * @param idProductor Id del productor.
     * @return Lista de residuos del productor.
     */
     @Override
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor){
        return productorDAO.consultarListaResiduosProductor(idProductor);
    }
    /**
     * Método que consulta el productor predeterminado registrado.
     * @return Productor predeterminado.
     */
    @Override
    public Productor consultarProductorPredeterminado() {
       return productorDAO.consultarProductorPredeterminado();
    }
    /**
     * Método que agrega un productor a la base de datos.
     * @return Productor registrado.
     */
    @Override
    public Productor agregarProductorPredeterminado() {
        return productorDAO.agregarProductorPredeterminado();
    }
    /**
     * Método para agregar transportistas determinados.
     */
    @Override
    public void agregarTransportistasPredeterminados() {
        transportistaDAO.agregarPredeterminados();
    }

    @Override
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        return ordenTrasladoDAO.consultarOrdenesTrasladoProductor(idProductor);
    }
    /**
     * Consulta las ordenes de traslado de un residuo realizadas por un
     * productor.
     *
     * @param orden Es la orden que se consultará
     * @return Regresa la lista de ordenes de traslados de un residuo realizadas
     * el día de hoy.
     */
    @Override
    public List<OrdenTraslado> consultarOrdenTrasladoResiduo(OrdenTraslado orden) {
        return ordenTrasladoDAO.consultarOrdenTrasladoResiduo(orden);
    }
    /**
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo Id del residuo.
     * @return Residuo encontrado, null en caso contrario.
     */
    @Override
    public Residuo consultarResiduo(ObjectId idResiduo) {
        return residuoDAO.consultar(idResiduo);
    }
    /**
     * Método para consultar un destino según la id enviada como parámetro.
     * @param idDestino Id del destino.
     * @return Destino consultado, null si no se encuentra.
     */
    @Override
    public Destino consultarDestino(ObjectId idDestino) {
        return destinoDAO.consultar(idDestino);
    }
    
}


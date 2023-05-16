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


    public FachadaPersistencia() {
        conexionBD = new ConexionBD("residuos");
        ordenTrasladoDAO = new OrdenTrasladoDAO(conexionBD);
        productorDAO = new ProductorDAO(conexionBD);
        transportistaDAO = new TransportistaDAO(conexionBD);
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
     * @param entidad Orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado entidad) {
        return ordenTrasladoDAO.agregar(entidad);
    }

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param entidad orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado entidad) {
        return ordenTrasladoDAO.actualizar(entidad);
    }
    
    @Override
    public OrdenTraslado eliminarOrdenTraslado(ObjectId id) {
        //No se ocupa para el caso de uso
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Productor consultarProductor(ObjectId id) {
        return productorDAO.consultar(id);
    }

    @Override
    public List<Productor> consultarTodosProductor() {
        return productorDAO.consultarTodos();
    }

    @Override
    public Productor agregarProductor(Productor entidad) {
        return productorDAO.agregar(entidad);
    }

    @Override
    public Productor actualizarProductor(Productor entidad) {
        return productorDAO.actualizar(entidad);
    }

    @Override
    public Productor eliminarProductor(ObjectId id) {
        //No se ocupa para el caso de uso
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Transportista consultarTransportista(ObjectId id) {
        return transportistaDAO.consultar(id);
    }

    @Override
    public List<Transportista> consultarTodosTransportistas() {
        return transportistaDAO.consultarTodos();
    }

    @Override
    public Transportista agregarTransportista(Transportista entidad) {
        return transportistaDAO.agregar(entidad);
    }

    @Override
    public Transportista actualizarTransportista(Transportista entidad) {
        return transportistaDAO.actualizar(entidad);
    }

    @Override
    public Transportista eliminarTransportista(ObjectId id) {
        //No se ocupa para el caso de uso
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public List<String> consultarListaCorreosTransportistas(){
        return transportistaDAO.consultarCorreosTransportistas();
    }
     @Override
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor){
        return productorDAO.consultarListaDestinosProductor(idProductor);
    }
     @Override
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor){
        return productorDAO.consultarListaResiduosProductor(idProductor);
    }

    @Override
    public Productor consultarProductorPredeterminado() {
       return productorDAO.consultarProductorPredeterminado();
    }

    @Override
    public Productor agregarProductorPredeterminado() {
        return productorDAO.agregarProductorPredeterminado();
    }

    @Override
    public void agregarTransportistasPredeterminados() {
        transportistaDAO.agregarPredeterminados();
    }

    @Override
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        return ordenTrasladoDAO.consultarOrdenesTrasladoProductor(idProductor);
    }

    @Override
    public List<OrdenTraslado> consultarOrdenTrasladoResiduo(ObjectId idResiduo) {
        return ordenTrasladoDAO.consultarOrdenTrasladoResiduo(idResiduo);
    }
    
    
}


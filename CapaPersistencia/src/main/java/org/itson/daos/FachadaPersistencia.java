/**
 * Clase FechadaPersistencia.java creada el 14/05/2023.
 */
package org.itson.daos;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.OrdenTraslado;
import org.itson.registros.Interface.IConexionBD;
import org.itson.registros.Interface.IPersistencia;

/**
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public class FachadaPersistencia implements IPersistencia {

    private IConexionBD conexionBD;
    private OrdenTrasladoDAO ordenTrasladoDAO;

    public FachadaPersistencia() {
        conexionBD = new ConexionBD("residuos");
        ordenTrasladoDAO = new OrdenTrasladoDAO(conexionBD);
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

}

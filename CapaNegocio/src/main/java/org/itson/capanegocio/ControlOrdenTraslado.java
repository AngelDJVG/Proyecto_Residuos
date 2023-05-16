/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.OrdenTraslado;
import org.itson.registros.Interface.IPersistencia;

/**
 *
 * @author mario
 */
public class ControlOrdenTraslado {
    
    private IPersistencia fachadaPersistencia;
    
    public ControlOrdenTraslado(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        return fachadaPersistencia.consultarOrdenesTrasladoProductor(idProductor);
    }

    public List<OrdenTraslado> consultarOrdenTrasladoResiduo(ObjectId idResiduo) {
        return fachadaPersistencia.consultarOrdenTrasladoResiduo(idResiduo);
    }
    
    /**
     * Método para consultar una orden de traslado a partir de su id.
     *
     * @param id Id de la orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado consultarOrdenTraslado(ObjectId id) {
        return fachadaPersistencia.consultarOrdenTraslado(id);
    }

    /**
     * Método que devuelve una lista de ordenes de traslado.
     *
     * @return lista de ordenes de traslado.
     */
    public List consultarTodosOrdenTraslado() {
        return fachadaPersistencia.consultarTodosOrdenTraslado();
    }

    /**
     * Método que agrega una orden de traslado.
     *
     * @param entidad Orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado entidad) {
        return fachadaPersistencia.agregarOrdenTraslado(entidad);
    }

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param entidad orden de traslado.
     * @return orden de traslado.
     */
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado entidad) {
        return fachadaPersistencia.actualizarOrdenTraslado(entidad);
    }
    
}

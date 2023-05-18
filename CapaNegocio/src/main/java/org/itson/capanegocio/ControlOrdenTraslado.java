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
 * Clase para control de acceso a ordenes de traslado.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ControlOrdenTraslado {
    
    private IPersistencia fachadaPersistencia;
    
    /**
     * Constructor por defecto.
     */
    public ControlOrdenTraslado(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    /**
     * Método que consulta las órdenes de traslado de un productor.
     * @param idProductor Id del productor.
     * @return Lista de órdenes de traslado.
     */
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        return fachadaPersistencia.consultarOrdenesTrasladoProductor(idProductor);
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
        return fachadaPersistencia.consultarOrdenTrasladoResiduo(orden);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaz;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;

/**
 * Esta interfaz se utiliza para implementar la capa de negocios.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public interface INegocios {
    
    /**
     * Método que consulta a un productor a partir de la id enviada como parámetro.
     * @param id Id del productor. 
     * @return Productor si se encontró, null en caso contrario.
     */
     public Productor consultarProductor(ObjectId id);
     
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
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
     public List<String> consultarListaCorreosTransportistas();
     
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
    public List consultarTodosOrdenTraslado();

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
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo El id del residuo a consultar.
     * @return El residuo consultado en caso de encontrarlo, null en caso contrario.
     */
    public Residuo consultarResiduo(ObjectId idResiduo);
    
    /**
     * Método que consulta un destino a partir de su id.
     * @param idDestino El id del destino a consultar.
     * @return El destino consultado en caso de encontrarlo, null en caso contrario.
     */
    public Destino consultarDestino(ObjectId idDestino);
}

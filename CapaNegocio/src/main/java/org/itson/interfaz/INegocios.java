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
 *
 * @author Gabriel Mancinas
 */
public interface INegocios {
    public Productor consultarProductor(ObjectId id);
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor);
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor);
     public Productor consultarProductorPredeterminado();
     public Productor agregarProductorPredeterminado();
     public List<String> consultarListaCorreosTransportistas();
     public void agregarTransportistasPredeterminados();
     public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor);
     public List<OrdenTraslado> consultarOrdenTrasladoResiduo(ObjectId idResiduo);
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
    public Residuo consultarResiduo(ObjectId idResiduo);
    public Destino consultarDestino(ObjectId idDestino);
}

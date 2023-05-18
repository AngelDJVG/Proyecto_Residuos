/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.interfaz.INegocios;

/**
 * Esta clase representa los objetos de negocio.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ObjetoNegocio implements INegocios{
    
    ControlProductor controlProductor;
    ControlTransportista controlTransportista;
    ControlOrdenTraslado controlOrdenesTraslado;
    ControlResiduo controlResiduo;
    ControlDestino controlDestino;
    
    /**
     * Constructor por defecto.
     */
    public ObjetoNegocio(){
        controlProductor = new ControlProductor();
        controlTransportista = new ControlTransportista();
        controlOrdenesTraslado = new ControlOrdenTraslado();
        controlResiduo = new ControlResiduo();
        controlDestino = new ControlDestino();
    }
    
    /**
     * Método que consulta a un productor a partir de la id enviada como parámetro.
     * @param id Id del productor. 
     * @return Productor si se encontró, null en caso contrario.
     */
    @Override
    public Productor consultarProductor(ObjectId id) {
        return controlProductor.consultarProductor(id);
    }
    
    /**
     * Método que consulta la lista de destinos del productor.
     * @param idProductor Id del productor.
     * @return Lista de destinos del productor.
     */
    @Override
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor) {
       return controlProductor.consultarListaDestinosProcutor(idProductor);
    }

    /**
     * Método que regresa una lista de residuos de un productor en específico.
     * @param idProductor Id del productor.
     * @return Lista de residuos del productor.
     */
    @Override
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor) {
        return controlProductor.consultarListaResiduosProductor(idProductor);
    }

    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
    @Override
    public List<String> consultarListaCorreosTransportistas() {
        return controlTransportista.consultarListaCorreosTransportistas();
    }

    /**
     * Método que consulta el productor predeterminado registrado.
     * @return Productor predeterminado.
     */
    @Override
    public Productor consultarProductorPredeterminado() {
        return controlProductor.consultarProductorPredeterminado();
    }

    /**
     * Método que agrega un productor a la base de datos.
     * @return Productor registrado.
     */
    @Override
    public Productor agregarProductorPredeterminado() {
        return controlProductor.agregarProductorPredeterminado();
    }

    /**
     * Método para agregar transportistas determinados.
     */
    @Override
    public void agregarTransportistasPredeterminados() {
        controlTransportista.agregarTransportistasPredeterminados();
    }

    /**
     * Método que consulta las órdenes de traslado de un productor.
     * @param idProductor Id del productor.
     * @return Lista de órdenes de traslado.
     */
    @Override
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        return controlOrdenesTraslado.consultarOrdenesTrasladoProductor(idProductor);
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
        return controlOrdenesTraslado.consultarOrdenTrasladoResiduo(orden);
    }

    /**
     * Método para consultar una orden de traslado a partir de su id.
     *
     * @param id Id de la orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado consultarOrdenTraslado(ObjectId id) {
        return controlOrdenesTraslado.consultarOrdenTraslado(id);
    }

    /**
     * Método que devuelve una lista de ordenes de traslado.
     *
     * @return lista de ordenes de traslado.
     */
    @Override
    public List consultarTodosOrdenTraslado() {
        return controlOrdenesTraslado.consultarTodosOrdenTraslado();
    }

    /**
     * Método que agrega una orden de traslado.
     *
     * @param entidad Orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado entidad) {
        return controlOrdenesTraslado.agregarOrdenTraslado(entidad);
    }

    /**
     * Método que actualiza una orden de traslado.
     *
     * @param entidad orden de traslado.
     * @return orden de traslado.
     */
    @Override
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado entidad) {
        return controlOrdenesTraslado.actualizarOrdenTraslado(entidad);
    }

    /**
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo El id del residuo a consultar.
     * @return El residuo consultado en caso de encontrarlo, null en caso contrario.
     */
    @Override
    public Residuo consultarResiduo(ObjectId idResiduo) {
        return controlResiduo.consultarResiduo(idResiduo);
    }

    /**
     * Método que consulta un destino a partir de su id.
     *
     * @param idDestino El id del destino a consultar.
     * @return El destino consultado en caso de encontrarlo, null en caso
     * contrario.
     */
    @Override
    public Destino consultarDestino(ObjectId idDestino) {
        return controlDestino.consultarDestino(idDestino);
    }
   
}

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
 *
 * @author Gabriel Mancinas
 */
public class ObjetoNegocio implements INegocios{
    ControlProductor controlProductor;
    ControlTransportista controlTransportista;
    ControlOrdenTraslado controlOrdenesTraslado;
    
    public ObjetoNegocio(){
        controlProductor = new ControlProductor();
        controlTransportista = new ControlTransportista();
        controlOrdenesTraslado = new ControlOrdenTraslado();
        
    }
    @Override
    public Productor consultarProductor(ObjectId id) {
        return controlProductor.consultarProductor(id);
    }
    @Override
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor) {
       return controlProductor.consultarListaDestinosProcutor(idProductor);
    }

    @Override
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor) {
        return controlProductor.consultarListaResiduosProductor(idProductor);
    }

    @Override
    public List<String> consultarListaCorreosTransportistas() {
        return controlTransportista.consultarListaCorreosTransportistas();
    }

    @Override
    public Productor consultarProductorPredeterminado() {
        return controlProductor.consultarProductorPredeterminado();
    }

    @Override
    public Productor agregarProductorPredeterminado() {
        return controlProductor.agregarProductorPredeterminado();
    }

    @Override
    public void agregarTransportistasPredeterminados() {
        controlTransportista.agregarTransportistasPredeterminados();
    }

    @Override
    public List<OrdenTraslado> consultarOrdenesTrasladoProductor(ObjectId idProductor) {
        return controlOrdenesTraslado.consultarOrdenesTrasladoProductor(idProductor);
    }

    @Override
    public List<OrdenTraslado> consultarOrdenTrasladoResiduo(ObjectId idResiduo) {
        return controlOrdenesTraslado.consultarOrdenTrasladoResiduo(idResiduo);
    }

    @Override
    public OrdenTraslado consultarOrdenTraslado(ObjectId id) {
        return controlOrdenesTraslado.consultarOrdenTraslado(id);
    }

    @Override
    public List consultarTodosOrdenTraslado() {
        return controlOrdenesTraslado.consultarTodosOrdenTraslado();
    }

    @Override
    public OrdenTraslado agregarOrdenTraslado(OrdenTraslado entidad) {
        return controlOrdenesTraslado.agregarOrdenTraslado(entidad);
    }

    @Override
    public OrdenTraslado actualizarOrdenTraslado(OrdenTraslado entidad) {
        return controlOrdenesTraslado.actualizarOrdenTraslado(entidad);
    }
   
    
    
    
}

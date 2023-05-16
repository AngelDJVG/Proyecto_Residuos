/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.Destino;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.registros.Interface.IPersistencia;

/**
 *
 * @author Gabriel Mancinas
 */
public class ControlProductor{
    private IPersistencia fachadaPersistencia;
    
    public ControlProductor(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    public Productor consultarProductor(ObjectId id) {
        return fachadaPersistencia.consultarProductor(id);
    }
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor){
        return fachadaPersistencia.consultarListaDestinosProcutor(idProductor);
    }
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor){
         return fachadaPersistencia.consultarListaResiduosProductor(idProductor);
    }
    public List<String> consultarListaCorreosTransportistas(){
        return fachadaPersistencia.consultarListaCorreosTransportistas();
    }
     public Productor consultarProductorPredeterminado(){
         return fachadaPersistencia.consultarProductorPredeterminado();
     }
     public Productor agregarProductorPredeterminado(){
         return fachadaPersistencia.agregarProductorPredeterminado();
     }
}

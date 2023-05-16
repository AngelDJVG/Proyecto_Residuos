/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.bson.types.ObjectId;
import org.itson.capanegocio.ObjetoNegocio;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.registros.Interface.IPersistencia;


/**
 *
 * @author Gabriel Mancinas
 */
public class ControlAplicacion {
      ObjetoNegocio objetoNegocio;
      Productor productor;
    
     public ControlAplicacion(){
         objetoNegocio = new ObjetoNegocio();
         if(consultarProductorPredeterminado() != null)
         {
             productor = consultarProductorPredeterminado();
         }else
         {
             productor = objetoNegocio.agregarProductorPredeterminado();
         }
         
        
    }
    public OrdenTraslado registrarOrdenTraslado(OrdenTraslado orden)
    {
        return objetoNegocio.agregarOrdenTraslado(orden);
    }
    public Productor obtenerProductor(ObjectId id){
        return objetoNegocio.consultarProductor(id);
    }

    public List<Residuo> obtenerListaResiduos(ObjectId id){
        return objetoNegocio.consultarListaResiduosProductor(id);
    }
    public List<Destino> obtenerListaDestinos(ObjectId id){
        return objetoNegocio.consultarListaDestinosProcutor(id);
    }
    public List<String> consultarListaCorreosTransportistas(){
        return objetoNegocio.consultarListaCorreosTransportistas();
    }
    public Productor consultarProductorPredeterminado(){
        return objetoNegocio.consultarProductorPredeterminado();
    }
    public void llenarComboBoxListaResiduos(ObjectId id,JComboBox cbx){
        List<Residuo> lista = obtenerListaResiduos(id);
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel<>();
        comboBox.addAll(lista);
        cbx.setModel(comboBox);
        cbx.setSelectedIndex(0);
    }
    public void llenarComboBoxListaDestinos(ObjectId id,JComboBox cbx){
        List<Destino> lista = obtenerListaDestinos(id);
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel<>();
        comboBox.addAll(lista);
        cbx.setModel(comboBox);
        cbx.setSelectedIndex(0);
    }
    public List<OrdenTraslado> consultarOrdenesTraslado(){
        return objetoNegocio.consultarTodosOrdenTraslado();
    }

    public Productor getProductor(){
        return this.productor;
    }
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import java.util.List;
import org.itson.daos.FachadaPersistencia;
import org.itson.registros.Interface.IPersistencia;

/**
 *
 * @author Gabriel Mancinas
 */
public class ControlTransportista {
    private IPersistencia fachadaPersistencia;
    
    public ControlTransportista(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    public List<String> consultarListaCorreosTransportistas(){
        return fachadaPersistencia.consultarListaCorreosTransportistas();
    }
}

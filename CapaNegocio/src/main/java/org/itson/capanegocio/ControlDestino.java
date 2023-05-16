/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import org.bson.types.ObjectId;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.Destino;
import org.itson.registros.Interface.IPersistencia;

/**
 *
 * @author mario
 */
public class ControlDestino {
    
    private IPersistencia fachadaPersistencia;
    
    public ControlDestino(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    public Destino consultarDestino(ObjectId idDestino){
        return fachadaPersistencia.consultarDestino(idDestino);
    }
    
}

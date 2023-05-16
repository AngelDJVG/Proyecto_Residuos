/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import org.bson.types.ObjectId;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.Residuo;
import org.itson.registros.Interface.IPersistencia;

/**
 *
 * @author mario
 */
public class ControlResiduo {
    
    private IPersistencia fachadaPersistencia;
    
    public ControlResiduo(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    public Residuo consultarResiduo(ObjectId idResiduo){
        return fachadaPersistencia.consultarResiduo(idResiduo);
    }
    
}

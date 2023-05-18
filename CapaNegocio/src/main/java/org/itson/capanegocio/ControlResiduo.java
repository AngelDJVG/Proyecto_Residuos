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
 * Clase para control de acceso a residuos.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ControlResiduo {
    
    private IPersistencia fachadaPersistencia;
    
    /**
     * Constructor por defecto.
     */
    public ControlResiduo(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    /**
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo El id del residuo a consultar.
     * @return El residuo consultado en caso de encontrarlo, null en caso contrario.
     */
    public Residuo consultarResiduo(ObjectId idResiduo){
        return fachadaPersistencia.consultarResiduo(idResiduo);
    }
    
}

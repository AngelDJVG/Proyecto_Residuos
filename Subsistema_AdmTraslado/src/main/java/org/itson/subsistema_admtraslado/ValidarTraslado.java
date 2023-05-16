/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.subsistema_admtraslado;

import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.OrdenTraslado;
import org.itson.excepciones.PersistenciaException;
import org.itson.registros.Interface.IPersistencia;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ValidarTraslado {

    private IPersistencia persistencia;
    
    public ValidarTraslado() {
        persistencia = new FachadaPersistencia();
    }
    
    public boolean validarTraslado(OrdenTraslado traslado) throws PersistenciaException{
        if(persistencia.consultarOrdenesTrasladoProductor(traslado.getIdProductor()).size() < 5){
            if(persistencia.consultarOrdenTrasladoResiduo(traslado).isEmpty()){
                return true;
            }else{
                throw new PersistenciaException("Ya se ha solicitado un traslado de este residuo hoy");
            }
        }else{
            throw new PersistenciaException("Ya se han solicitado 5 ordenes de traslado el día de hoy");
        }
    }
    
}

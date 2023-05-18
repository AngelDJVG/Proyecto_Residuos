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
 * Clase para control de acceso a productores.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ControlProductor{
    private IPersistencia fachadaPersistencia;
    
    /**
     * Constructor por defecto.
     */
    public ControlProductor(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    /**
     * Método que consulta a un productor a partir de la id enviada como parámetro.
     * @param id Id del productor. 
     * @return Productor si se encontró, null en caso contrario.
     */
    public Productor consultarProductor(ObjectId id) {
        return fachadaPersistencia.consultarProductor(id);
    }
    
    /**
     * Método que consulta la lista de destinos del productor.
     * @param idProductor Id del productor.
     * @return Lista de destinos del productor.
     */
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor){
        return fachadaPersistencia.consultarListaDestinosProcutor(idProductor);
    }
    
    /**
     * Método que regresa una lista de residuos de un productor en específico.
     * @param idProductor Id del productor.
     * @return Lista de residuos del productor.
     */
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor){
         return fachadaPersistencia.consultarListaResiduosProductor(idProductor);
    }
    
    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
    public List<String> consultarListaCorreosTransportistas(){
        return fachadaPersistencia.consultarListaCorreosTransportistas();
    }
    
    /**
     * Método que consulta el productor predeterminado registrado.
     * @return Productor predeterminado.
     */
     public Productor consultarProductorPredeterminado(){
         return fachadaPersistencia.consultarProductorPredeterminado();
     }
     
     /**
     * Método que agrega un productor a la base de datos.
     * @return Productor registrado.
     */
     public Productor agregarProductorPredeterminado(){
         return fachadaPersistencia.agregarProductorPredeterminado();
     }
     
    
}

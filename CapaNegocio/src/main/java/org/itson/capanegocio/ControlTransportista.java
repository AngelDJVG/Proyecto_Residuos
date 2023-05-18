/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import java.util.List;
import org.itson.daos.FachadaPersistencia;
import org.itson.registros.Interface.IPersistencia;

/**
 * Clase para control de acceso a transportistas.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ControlTransportista {
    private IPersistencia fachadaPersistencia;
    
    /**
     * Constructor por defecto.
     */
    public ControlTransportista(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
    public List<String> consultarListaCorreosTransportistas(){
        return fachadaPersistencia.consultarListaCorreosTransportistas();
    }
    
    /**
     * Método para agregar transportistas determinados.
     */
    public void agregarTransportistasPredeterminados(){
        fachadaPersistencia.agregarTransportistasPredeterminados();
    }
}

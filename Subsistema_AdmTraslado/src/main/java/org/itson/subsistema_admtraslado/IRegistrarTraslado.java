/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.subsistema_admtraslado;

import org.itson.dominio.OrdenTraslado;
import org.itson.excepciones.PersistenciaException;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public interface IRegistrarTraslado {
    
    public boolean registrarTraslado(OrdenTraslado traslado) throws PersistenciaException;
}

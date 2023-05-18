/**
 * Clase ControlDestino.java creada el 17/05/2023.
 */
package org.itson.capanegocio;

import org.bson.types.ObjectId;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.Destino;
import org.itson.registros.Interface.IPersistencia;

/**
 * Clase para control de acceso a destinos.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ControlDestino {
    
    private IPersistencia fachadaPersistencia;
    
    /**
     * Constructor por defecto que crea la instancia de la fachadaPersistencia.
     */
    public ControlDestino(){
        fachadaPersistencia = new FachadaPersistencia();
    }
    
    /**
     * Método que consulta un destino a partir de su id.
     * @param idDestino El id del destino a consultar.
     * @return El destino consultado en caso de encontrarlo, null en caso contrario.
     */
    public Destino consultarDestino(ObjectId idDestino){
        return fachadaPersistencia.consultarDestino(idDestino);
    }
    
}

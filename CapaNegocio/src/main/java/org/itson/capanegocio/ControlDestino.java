/**
 * Clase ControlDestino.java creada el 17/05/2023.
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

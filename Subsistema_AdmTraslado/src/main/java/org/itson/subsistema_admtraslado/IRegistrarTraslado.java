/**
 * Clase IRegistrarTraslado.java creada el 16/05/2023.
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
    /**
     * Método para registrar una Orden de traslado.
     * @param traslado Orden de traslado a registrar.
     * @return Valor booleano, true si se registro, false en caso contrario.
     * @throws PersistenciaException Excepción a lanzar en caso de haber un error.
     */
    public boolean registrarTraslado(OrdenTraslado traslado) throws PersistenciaException;
}

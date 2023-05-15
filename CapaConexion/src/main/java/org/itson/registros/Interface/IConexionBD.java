/**
 * Clase IConexionBD.java creado el 13/05/2023.
 */
package org.itson.registros.Interface;

import com.mongodb.client.MongoDatabase;

/**
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public interface IConexionBD {
    public MongoDatabase getBaseDatos();
}

/**
 * Clase IConexionBD.java creado el 13/05/2023.
 */
package org.itson.registros.Interface;

import com.mongodb.client.MongoDatabase;

/**
 * Interfaz de la conexión a la base de datos.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public interface IConexionBD {
    /**
     * Método que regresa la base de datos de la conexión.
     * @return Base de datos de la conexión.
     */
    public MongoDatabase getBaseDatos();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public abstract class DAOGeneral<T> {
    
    /**
     * Metodo para obtener la coleccion
     * @return regresa una coleccion.
     */
    protected abstract MongoCollection<T> getColeccion();

    /**
     * Metodo para agregar
     * @param entidad entidad a registrar segun su tipo.
     */
    public abstract void agregar(T entidad);
    
    /**
     * Metodo para actualizar
     * @param entidad entidad a actualizar segun su tipo.
     */
    public abstract void actualizar(T entidad);
    
    /**
     * Metodo para consultar
     * @param id id por el cual consultar.
     * @return objeto consultado
     */
    public abstract T consultar(ObjectId id);
    /**
     * Metodo para consultar
     * @param parametros id por el cual consultar.
     * @return objeto consultado
     */
    public abstract T consultar(T parametros);

    /**
     * Metodo para consultar todos.
     * @return lista de objetos consultados.
     */
    public abstract List<T> consultarTodos();

}
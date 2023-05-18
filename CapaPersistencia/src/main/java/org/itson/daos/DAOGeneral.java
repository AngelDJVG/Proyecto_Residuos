/**
 * Clase DAOGeneraljava creado el 13/05/2023.
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
 * @param <T> Genérico.
 */
public abstract class DAOGeneral<T> {
    
    
    /**
     * Metodo para agregar
     * @param entidad entidad a registrar segun su tipo.
     * @return entidad registrada.
     */
    public abstract T agregar(T entidad);
    
    /**
     * Metodo para actualizar
     * @param entidad entidad a actualizar segun su tipo.
     * @return entidad registrada.
     */
    public abstract T actualizar(T entidad);
    
    /**
     * Metodo para consultar
     * @param id id por el cual consultar.
     * @return objeto consultado
     */
    public abstract T consultar(ObjectId id);

    /**
     * Metodo para consultar todos.
     * @return lista de objetos consultados.
     */
    public abstract List<T> consultarTodos();

}


package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de productor.
 * @author Luis Ayón, Mario Díaz, Gabriel Mancinas, Ángel Valenzuela
 */
public class Productor {
    
    private ObjectId id;
    private String nombre;
    
    /**
     * Método constructor por defecto.
     */
    public Productor() {
    }
    /**
     * Método constructor que inicializa el nombre del productor.
     * @param nombre Nombre del productor.
     */
    public Productor(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método constructor que inicializa todos los atributos del productor.
     * @param id ID del productor.
     * @param nombre Nombre del productor.
     */
    public Productor(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }    
    
    /**
     * Método get que regresa el ID del productor.
     * @return el ID del productor.
     */
    public ObjectId getId() {
        return id;
    }
    
    /**
     * Método set que asigna el ID al productor.
     * @param id ID a asginar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     * Método get que regresa el nombre del productor.
     * @return Nombre del productor
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método que asigna el nombre al productor.
     * @param nombre Nombre del productor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método hashcode.
     * @return hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    /**
     * Método equals.
     * @param obj Objeto a comparar.
     * @return Verdadero si coincide, falso en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productor other = (Productor) obj;
        return Objects.equals(this.id, other.id);
    }
    
    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "Productor{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}

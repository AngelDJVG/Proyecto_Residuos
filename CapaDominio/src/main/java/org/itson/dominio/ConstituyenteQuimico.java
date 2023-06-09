/**
 * Clase ConstituyenteQuimico.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de constituyente quimico.
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ConstituyenteQuimico {
    
    private ObjectId id;
    private String nombre;

    /**
     * Método constructor por defecto.
     */
    public ConstituyenteQuimico() {
    }

    /**
     * Método constructor que inicializa el nombre.
     * @param nombre Nombre del constituyente quimico.
     */
    public ConstituyenteQuimico(String nombre) {
        this.nombre = nombre;
        this.id = new ObjectId();
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID del constituyente quimico.
     * @param nombre Nombre del constituyente quimico.
     */
    public ConstituyenteQuimico(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Método get que obtiene el ID del consituyente quimico.
     * @return Id del constituyente. 
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método set que asigna el ID del constituyente quimico.
     * @param id ID del constituyente quimico.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método get que obtiene el nombre del constituyente quimico.
     * @return regresa nombre del constituyente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set que asigna un nombre al constituyente quimico.
     * @param nombre nombre a actualizar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método hashcode.
     * @return Hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ConstituyenteQuimico other = (ConstituyenteQuimico) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "ConstituyenteQuimico{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}

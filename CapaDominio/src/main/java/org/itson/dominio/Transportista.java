/**
 * Clase Transportista.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de transportista.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class Transportista {
    private ObjectId id;
    private String nombre;
    private String email;
    private List<Traslado> listaTraslados;
    
    /**
     * Método constructor por defecto.
     */
    public Transportista() {
    }
    
    /**
     * Método constructor que inicializa el nombre y el email.
     * @param nombre Nombre del transportista.
     * @param email Email del transportista.
     */
    public Transportista(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.id = new ObjectId();
    }
    
    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID del transportista.
     * @param nombre Nombre del transportista.
     * @param email Email del transportista.
     */
    public Transportista(ObjectId id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param nombre Nombre del transportista.
     * @param email Email del transportista.
     * @param listaTraslados Traslados realizados por el transportista.
     */
    public Transportista(String nombre, String email, List<Traslado> listaTraslados) {
        this.nombre = nombre;
        this.email = email;
        this.listaTraslados = listaTraslados;
        this.id = new ObjectId();
    }

    /**
     * Método get que obtiene el ID del transportista.
     * @return ID del transportista.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método set que asigna el ID del transportista.
     * @param id ID del transportista.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método get que obtiene el nombre del transportista.
     * @return Nombre del transportista. 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set que asigna el nombre del transportista
     * @param nombre Nombre del transportista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get que obtiene el email del transportista.
     * @return Email del transportista.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método set que asigna el email del transportista.
     * @param email Email del transportista.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método get que obtiene la lista de traslados realizados.
     * @return Lista de traslados realizados.
     */
    public List<Traslado> getListaTraslados() {
        return listaTraslados;
    }

    /**
     * Método set que asigna la lista de traslados realizados.
     * @param listaTraslados Lista de traslados realizados.
     */
    public void setListaTraslados(List<Traslado> listaTraslados) {
        this.listaTraslados = listaTraslados;
    }

    /**
     * Método hashcode.
     * @return Hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Transportista other = (Transportista) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "Transportista{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", listaTraslados=" + listaTraslados + '}';
    }

}

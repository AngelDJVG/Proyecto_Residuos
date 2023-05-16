/**
 * Clase Productor.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de productor.
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class Productor {
    
    private ObjectId id;
    private String nombre;
    private List<Residuo> listaResiduos;
    private List<Destino> listaDestinos;
    
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
        this.id = new ObjectId();
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
     * Método constructor que inicializa todos los atributos del productor.
     * @param nombre Nombre del productor.
     * @param listaResiduos Residuos registrados por el productor.
     * @param listaDestinos Destinos registrados por el productor.
     */
    public Productor(String nombre, List<Residuo> listaResiduos, List<Destino> listaDestinos) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.listaResiduos = listaResiduos;
        this.listaDestinos = listaDestinos;
    }

    /**
     * Método constructor que inicializa todos los atributos del productor.
     * @param nombre Nombre del productor.
     * @param listaResiduos Residuos registrados por el productor.
     */
    public Productor(String nombre, List<Residuo> listaResiduos) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.listaResiduos = listaResiduos;
    }

    /**
     * Método constructor que inicializa todos los atributos del productor.
     * @param listaDestinos Destinos registrados por el productor.
     * @param nombre Nombre del productor.
     */
    public Productor(List<Destino> listaDestinos, String nombre) {
        this.id = new ObjectId();
        this.nombre = nombre;
        this.listaDestinos = listaDestinos;
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
     * Método get que regresa la lista de residuos.
     * @return Lista de residuos.
     */
    public List<Residuo> getListaResiduos() {
        return listaResiduos;
    }

    /**
     * Método que asigna la lista de residuos.
     * @param listaResiduos Lista de residuos.
     */
    public void setListaResiduos(List<Residuo> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }

    /**
     * Método get que regresa la lista de destinos.
     * @return Lista de destinos.
     */
    public List<Destino> getListaDestinos() {
        return listaDestinos;
    }

    /**
     * Método que asigna la lista de destinos.
     * @param listaDestinos Lista de destinos.
     */
    public void setListaDestinos(List<Destino> listaDestinos) {
        this.listaDestinos = listaDestinos;
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
        return "Productor{" + "id=" + id + ", nombre=" + nombre + ", listaResiduos=" + listaResiduos + ", listaDestinos=" + listaDestinos + '}';
    }
    
}

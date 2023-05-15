/**
 * Clase Residuo.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de residuo.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class Residuo {
    
    private ObjectId id;
    private String nombre;
    private ResiduoUnidadMedida unidadMedida;
    private String lote;
    private List<ConstituyenteQuimico> constituyentesQuimicos;
    
    /**
     * Método constructor por defecto.
     */
    public Residuo() {
    }

    /**
     * Método constructor que inicializa el nombre, lote y la lista de constituyentes quimicos.
     * @param nombre Nombre del residuo.
     * @param lote Lote del residuo.
     * @param constituyentesQuimicos Constituyentes quimicos del residuo.
     */
    public Residuo(String nombre, String lote, List<ConstituyenteQuimico> constituyentesQuimicos) {
        this.nombre = nombre;
        this.lote = lote;
        this.constituyentesQuimicos = constituyentesQuimicos;
    }
    
    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID del residuo.
     * @param nombre Nombre del residuo.
     * @param lote Lote del residuo.
     * @param constituyentesQuimicos Constituyentes quimicos del residuo.
     */
    public Residuo(ObjectId id, String nombre, String lote, List<ConstituyenteQuimico> constituyentesQuimicos) {
        this.id = id;
        this.nombre = nombre;
        this.lote = lote;
        this.constituyentesQuimicos = constituyentesQuimicos;
    }
    
    /**
     * Método get que obtiene el ID del residuo.
     * @return El ID del residuo.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método set que asigna el ID del residuo.
     * @param id ID del residuo.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     * Método get que obtiene el nombre del residuo.
     * @return nombre del residuo.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método set que asigna un nombre al residuo.
     * @param nombre nombre del residuo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método get que obtiene el lote de un residuo.
     * @return lote del residuo.
     */
    public String getLote() {
        return lote;
    }

    /**
     * Método set que asigna un lote al residuo.
     * @param lote lote del residuo.
     */
    public void setLote(String lote) {
        this.lote = lote;
    }
    
    /**
     * Método get que obtiene la lista de constituyentes quimicos.
     * @return Lista de constituyentes quimicos.
     */
    public List<ConstituyenteQuimico> getConstituyentesQuimicos() {
        return constituyentesQuimicos;
    }

    /**
     * Método set que asigna la lista de constituyentes quimicos.
     * @param constituyentesQuimicos Lista de constituyentes quimicos.
     */
    public void setConstituyentesQuimicos(List<ConstituyenteQuimico> constituyentesQuimicos) {
        this.constituyentesQuimicos = constituyentesQuimicos;
    }
    /**
     * Método get que regresa la unidad de medida del residuo.
     * @return unidad de medida.
     */
    public ResiduoUnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
    /**
     * Método set que asigna la unidad de medida del residuo.
     * @param unidadMedida unidad de medida.
     */
    public void setUnidadMedida(ResiduoUnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    /**
     * Método hashcode.
     * @return hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Residuo other = (Residuo) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "Residuo{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", lote=" + lote + ", constituyentesQuimicos=" + constituyentesQuimicos + '}';
    }

}

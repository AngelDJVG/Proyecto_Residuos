
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class Destino {
    private ObjectId id;
    private String nombre;
    private String pais;
    private String estado;
    private String ciudad;
    private String colonia;
    private String calle;
    private String numero_casa;
    private float distancia;

    public Destino() {
    }

    public Destino(String nombre, String pais, String estado, String ciudad, String colonia, String calle, String numero_casa, float distancia) {
        this.nombre = nombre;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.numero_casa = numero_casa;
        this.distancia = distancia;
    }

    public Destino(ObjectId id, String nombre, String pais, String estado, String ciudad, String colonia, String calle, String numero_casa, float distancia) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.calle = calle;
        this.numero_casa = numero_casa;
        this.distancia = distancia;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
    
    /**
     * Método hashcode.
     * @return Hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Destino other = (Destino) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "Destino{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", estado=" + estado + ", ciudad=" + ciudad + ", colonia=" + colonia + ", calle=" + calle + ", numero_casa=" + numero_casa + ", distancia=" + distancia + '}';
    }
    
    
}

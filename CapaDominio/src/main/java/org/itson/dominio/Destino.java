/**
 * Clase Destino.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de destino.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
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
    /**
     * Método constructor por defecto.
     */
    public Destino() {
    }
    /**
     * Método constructor de destino que inicializa sus atributos al valor de los parámetros.
     * @param nombre Nombre del destino.
     * @param pais País del destino.
     * @param estado Estado del destino.
     * @param ciudad Ciudad del destino.
     * @param colonia Colonia del destino. 
     * @param calle Calle del destino.
     * @param numero_casa Número de casa del destino.
     * @param distancia Distancia del destino.
     */
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
    /**
     * Método constructor de destino que inicializa sus atributos al valor de los parámetros.
     * @param id ObjectID del objeto.
     * @param nombre Nombre del destino.
     * @param pais País del destino.
     * @param estado Estado del destino.
     * @param ciudad Ciudad del destino.
     * @param colonia Colonia del destino. 
     * @param calle Calle del destino.
     * @param numero_casa Número de casa del destino.
     * @param distancia Distancia del destino.
     */
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
    /**
     * Método get que regresa la ID del destino.
     * @return id del destino.
     */
    public ObjectId getId() {
        return id;
    }
    /**
     * Método set que asigna la ID del destino. 
     * @param id id del destino.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    /**
     * Método get que regresa el nombre del destino.
     * @return nombre del destino.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método set que asigna el nombre del destino.
     * @param nombre nombre del destino.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método get que regresa el país del destino.
     * @return país del destino.
     */
    public String getPais() {
        return pais;
    }
    /**
     * Método set que asigna el país del destino.
     * @param pais 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Método get que regresa el estado del destino.
     * @return estado del destino.
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Método set que asigna el estado del destino.
     * @param estado estado del destino.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Método get que regresa la ciudad del destino.
     * @return ciudad del destino.
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Método set que asigna la ciudad del destino.
     * @param ciudad ciudad del destino.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Método get que regresa la colonia del destino.
     * @return colonia del destino.
     */
    public String getColonia() {
        return colonia;
    }
    /**
     * Método set que asigna la colonia del destino.
     * @param colonia colonia del destino.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    /**
     * Método get que obtiene la calle del destino.
     * @return calle del destino.
     */
    public String getCalle() {
        return calle;
    }
    /**
     * Método set que asigna la calle del destino.
     * @param calle calle del destino.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * Método get que obtiene el número de casa del destino.
     * @return número de casa del destino.
     */
    public String getNumero_casa() {
        return numero_casa;
    }
    /**
     * Método set que asigna el número de casa del destino.
     * @param numero_casa múmero de casa del destino.
     */
    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }
    /**
     * Método get que obtiene la distancia del destino en kilómetros.
     * @return distancia del destino.
     */
    public float getDistancia() {
        return distancia;
    }
    /**
     * Método que asigna la distancia del destino.
     * @param distancia distancia del destino.
     */
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

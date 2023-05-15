/**
 * Clase Traslado.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.Calendar;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class Traslado {
    private ObjectId id;
    private float costo;
    private int cantidad;
    private Calendar fecha_destino;
    private ObjectId idOrdenTraslado;
    
    /**
     * Método constructor por defecto.
     */
    public Traslado() {
    }
    /**
     * Método constructor que inicializa los atributos al valor de los parámetros enviados.
     * @param id ObjectId del traslado.
     * @param costo costo del traslado.
     * @param cantidad cantidad del traslado.
     * @param fecha_destino destino del traslado.
     */
    public Traslado(ObjectId id, float costo, int cantidad, Calendar fecha_destino) {
        this.id = id;
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha_destino = fecha_destino;
    }
    /**
     * Método constructor que inicializa los atributos al valor de los parámetros enviados.
     * @param costo costo del traslado.
     * @param cantidad cantidad del traslado.
     * @param fecha_destino destino del traslado.
     */
    public Traslado(float costo, int cantidad, Calendar fecha_destino) {
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha_destino = fecha_destino;
    }
    /**
     * Método constructor que inicializa los atributos al valor de los parámetros enviados.
     * @param costo costo del traslado.
     * @param cantidad cantidad del traslado.
     * @param fecha_destino destino del traslado.
     * @param idOrdenTraslado id de su orden de traslado.
     */
    public Traslado(float costo, int cantidad, Calendar fecha_destino, ObjectId idOrdenTraslado) {
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha_destino = fecha_destino;
        this.idOrdenTraslado = idOrdenTraslado;
    }
    /**
     * Método get que devuelve la id del traslado.
     * @return id del traslado.
     */
    public ObjectId getId() {
        return id;
    }
    /**
     * Método set que asigna la id del traslado.
     * @param id id del traslado.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    /**
     * Método get que devuelve el costo del traslado.
     * @return costo del traslado.
     */
    public float getCosto() {
        return costo;
    }
    /**
     * Método set que asigna el costo del traslado.
     * @param costo costo del traslado.
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }
    /**
     * Método get que devuelve la cantidad del traslado.
     * @return cantidad del traslado.
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Método set que asigna la cantidad del traslado.
     * @param cantidad cantidad del traslado.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Método que obtiene la fecha de destino del traslado.
     * @return fecha de destino.
     */
    public Calendar getFecha_destino() {
        return fecha_destino;
    }
    /**
     * Método que asigna la fecha de destino del traslado.
     * @param fecha_destino fecha de destino del traslado.
     */
    public void setFecha_destino(Calendar fecha_destino) {
        this.fecha_destino = fecha_destino;
    }

    /**
     * Método que obtiene el id de su orden de traslado.
     * @return id de su orden de traslado.
     */
    public ObjectId getIdOrdenTraslado() {
        return idOrdenTraslado;
    }

    /**
     * Método que asigna el id de su orden de traslado.
     * @param idOrdenTraslado id de su orden de traslado.
     */
    public void setIdOrdenTraslado(ObjectId idOrdenTraslado) {
        this.idOrdenTraslado = idOrdenTraslado;
    }

    /**
     * Método hashcode.
     * @return Hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Traslado other = (Traslado) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "Traslado{" + "id=" + id + ", costo=" + costo + ", cantidad=" + cantidad + ", fecha_destino=" + fecha_destino + ", idOrdenTraslado=" + idOrdenTraslado + '}';
    }
    
}

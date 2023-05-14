
package org.itson.dominio;

import java.util.Calendar;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class Traslado {
    private ObjectId id;
    private float costo;
    private int cantidad;
    private Calendar fecha_destino;

    public Traslado() {
    }

    public Traslado(ObjectId id, float costo, int cantidad, Calendar fecha_destino) {
        this.id = id;
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha_destino = fecha_destino;
    }

    public Traslado(float costo, int cantidad, Calendar fecha_destino) {
        this.costo = costo;
        this.cantidad = cantidad;
        this.fecha_destino = fecha_destino;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Calendar getFecha_destino() {
        return fecha_destino;
    }

    public void setFecha_destino(Calendar fecha_destino) {
        this.fecha_destino = fecha_destino;
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
        return "Traslado{" + "id=" + id + ", costo=" + costo + ", cantidad=" + cantidad + ", fecha_destino=" + fecha_destino + '}';
    }
    
    
}

/**
 * Clase OrdenTraslado.java creado el 13/05/2023.
 */
package org.itson.dominio;

import java.util.Calendar;
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
public class OrdenTraslado {
    
    private ObjectId id;
    private String tratamiento;
    private Residuo residuo;
    private Destino destino;
    private Calendar fecha_creacion;
    private Calendar fecha_limite;
    private int cantidad;

    /**
     * Método constructor por defecto.
     */
    public OrdenTraslado() {
        
    }

    /**
     * Método constructor que inicializa el tratamiento, residuo, destino, fecha de creación, fecha limite y la cantidad.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param residuo Residuo de la orden de traslado.
     * @param destino Destino de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     */
    public OrdenTraslado(String tratamiento, Residuo residuo, Destino destino, Calendar fecha_creacion, Calendar fecha_limite, int cantidad) {
        this.tratamiento = tratamiento;
        this.residuo = residuo;
        this.destino = destino;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID de la orden de traslado.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param residuo Residuo de la orden de traslado.
     * @param destino Destino de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     */
    public OrdenTraslado(ObjectId id, String tratamiento, Residuo residuo, Destino destino, Calendar fecha_creacion, Calendar fecha_limite, int cantidad) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.residuo = residuo;
        this.destino = destino;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
    }

    /**
     * Método get que obtiene el ID de una orden de traslado.
     * @return ID de una orden de traslado.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método set que asigna el ID de una orden de traslado.
     * @param id ID de una orden de traslado.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método get que obtiene el tratamiento de una orden de traslado.
     * @return Tratamiento de una orden de traslado.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Método set que asigna el tratamiento de una orden de traslado.
     * @param tratamiento Tratamiento de una orden de traslado.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Método get que obtiene el residuo de una orden de traslado.
     * @return Residuo de una orden de traslado.
     */
    public Residuo getResiduo() {
        return residuo;
    }

    /**
     * Método set que asigna un residuo de una orden de traslado.
     * @param residuo Residuo de una orden de traslado.
     */
    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    /**
     * Método get que obtiene un destino de una orden de traslado.
     * @return Destino de una orden de traslado.
     */
    public Destino getDestino() {
        return destino;
    }

    /**
     * Método set que asigna el destino de una orden de traslado.
     * @param destino Destino de una orden de traslado.
     */
    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    /**
     * Método get que obtiene la fecha de creación de una orden de traslado.
     * @return Fecha de creación de una orden de traslado.
     */
    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * Método set que asigna una fecha de creación de una orden de traslado.
     * @param fecha_creacion Fecha de creación de una orden de traslado.
     */
    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * Método get que obtiene una fecha limite de una orden de traslado.
     * @return Fecha de creación de una orden de traslado.
     */
    public Calendar getFecha_limite() {
        return fecha_limite;
    }

    /**
     * Método set que asigna una fecha limite de una orden de traslado.
     * @param fecha_limite Fecha limite de una orden de traslado.
     */
    public void setFecha_limite(Calendar fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    /**
     * Método get que obtiene una cantidad de traslados.
     * @return cantidad de traslados.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Método set que asigna una cantidad de traslados.
     * @param cantidad cantidad de traslados.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método hashcode.
     * @return Hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final OrdenTraslado other = (OrdenTraslado) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "OrdenTraslado{" + "id=" + id + ", tratamiento=" + tratamiento + ", residuo=" + residuo + ", destino=" + destino + ", fecha_creacion=" + fecha_creacion + ", fecha_limite=" + fecha_limite + ", cantidad=" + cantidad + '}';
    }

    
}

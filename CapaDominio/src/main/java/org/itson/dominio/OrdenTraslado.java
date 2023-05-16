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
    private Calendar fecha_creacion;
    private Calendar fecha_limite;
    private int cantidad;
    private ObjectId idResiduo;
    private ObjectId idDestino;
    private ObjectId idProductor;
    private int precio;

    /**
     * Método constructor por defecto.
     */
    public OrdenTraslado() {
        
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID de la orden de traslado.
     */
    public OrdenTraslado(ObjectId id) {
        this.id = id;
    }

    /**
     * Método constructor que inicializa el tratamiento, residuo, destino, fecha de creación, fecha limite y la cantidad.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     */
    public OrdenTraslado(String tratamiento, Calendar fecha_creacion, Calendar fecha_limite, int cantidad) {
        this.tratamiento = tratamiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
        this.id = new ObjectId();
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID de la orden de traslado.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     */
    public OrdenTraslado(ObjectId id, String tratamiento,Calendar fecha_creacion, Calendar fecha_limite, int cantidad) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     * @param idResiduo Id del residuo a trasladar.
     * @param idDestino Id del destino a trasladar.
     * @param idProductor Id del productor que solicitó la orden.
     */
    public OrdenTraslado(String tratamiento,Calendar fecha_creacion, Calendar fecha_limite, int cantidad, ObjectId idResiduo, ObjectId idDestino, ObjectId idProductor) {
        this.tratamiento = tratamiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
        this.idResiduo = idResiduo;
        this.idDestino = idDestino;
        this.idProductor = idProductor;
        this.id = new ObjectId();
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     * @param idResiduo Id del residuo a trasladar.
     * @param idDestino Id del destino a trasladar.
     * @param idProductor Id del productor que solicitó la orden.
     * @param precio Precio de la orden.
     */
    public OrdenTraslado(String tratamiento, Calendar fecha_creacion, Calendar fecha_limite, int cantidad, ObjectId idResiduo, ObjectId idDestino, ObjectId idProductor, int precio) {
        this.tratamiento = tratamiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
        this.idResiduo = idResiduo;
        this.idDestino = idDestino;
        this.idProductor = idProductor;
        this.precio = precio;
        this.id = new ObjectId();
    }

    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID de la orden de traslado.
     * @param tratamiento Tratamiento de la orden de traslado.
     * @param fecha_creacion Fecha de creacion de la orden de traslado.
     * @param fecha_limite Fecha limite de la orden de traslado.
     * @param cantidad Cantidad de la orden de traslado.
     * @param idResiduo Id del residuo a trasladar.
     * @param idDestino Id del destino a trasladar.
     * @param idProductor Id del productor que solicitó la orden.
     * @param precio Precio de la orden.
     */
    public OrdenTraslado(ObjectId id, String tratamiento, Calendar fecha_creacion, Calendar fecha_limite, int cantidad, ObjectId idResiduo, ObjectId idDestino, ObjectId idProductor, int precio) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
        this.cantidad = cantidad;
        this.idResiduo = idResiduo;
        this.idDestino = idDestino;
        this.idProductor = idProductor;
        this.precio = precio;
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
     * Método get que obtiene el id del residuo a trasladar.
     * @return id del residuo a trasladar.
     */
    public ObjectId getIdResiduo() {
        return idResiduo;
    }

    /**
     * Método set que asigna el id del residuo a trasladar.
     * @param idResiduo id del residuo a trasladar.
     */
    public void setIdResiduo(ObjectId idResiduo) {
        this.idResiduo = idResiduo;
    }

    /**
     * Método get que obtiene el id del destino a trasladar.
     * @return id del destino a trasladar.
     */
    public ObjectId getIdDestino() {
        return idDestino;
    }

    /**
     * Método set que asigna el id del destino a trasladar.
     * @param idDestino id del destino a trasladar.
     */
    public void setIdDestino(ObjectId idDestino) {
        this.idDestino = idDestino;
    }

    /**
     * Método get que obtiene el id del productor que solicitó la orden.
     * @return id del productor que solicitó la orden.
     */
    public ObjectId getIdProductor() {
        return idProductor;
    }

    /**
     * Método set que asigna el id del productor que solicitó la orden.
     * @param idProductor id del productor que solicitó la orden.
     */
    public void setIdProductor(ObjectId idProductor) {
        this.idProductor = idProductor;
    }

    /**
     * Método get que obtiene el precio de la orden.
     * @return precio de la orden.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método set que asigna el precio de la orden.
     * @param precio precio de la orden.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
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
        return "OrdenTraslado{" + "id=" + id + ", fecha_creacion=" + fecha_creacion + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    
}

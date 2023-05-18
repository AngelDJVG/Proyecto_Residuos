/**
 * Clase PersistenciaException creada el 16/05/2023.
 */
package org.itson.excepciones;

/**
 *
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que llama al constructor padre y envía un mensaje de la
     * excepción.
     *
     * @param message mensaje de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que llama al constructor padre y envía un mensaje y una causa
     * de la excepción.
     *
     * @param message mensaje de la excepción.
     * @param cause causa de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que llama al constructor padre y envía una causa de la
     * excepción.
     *
     * @param cause causa de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que llama al constructor padre y permite personalizar la
     * excepción.
     *
     * @param message mensaje de la excepción.
     * @param cause causa de la excepción.
     * @param enableSuppression indica si se deben suprimir excepciones.
     * @param writableStackTrace indica si se debe generar una traza de pila
     * escrita.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

/**
 * Clase FachadaAdmTraslado.java creada el 15/05/2023.
 */
package org.itson.subsistema_admtraslado;

import mensajeria.FachadaCorreo;
import mensajeria.IMensajeria;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.OrdenTraslado;
import org.itson.excepciones.PersistenciaException;
import org.itson.registros.Interface.IPersistencia;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class FachadaAdmTraslado implements IRegistrarTraslado{

    private IPersistencia persistencia;
    private IMensajeria mensajeria;
    private ValidarTraslado validador;
    /**
     * Método consturctor que inicializa los atributos al valor de sus parámetros.
     * @param credencialCorreo Credencial del correo.
     * @param credencialPassword Credencial del password.
     */
    public FachadaAdmTraslado(String credencialCorreo, String credencialPassword) {
        persistencia = new FachadaPersistencia();
        mensajeria = new FachadaCorreo(credencialCorreo, credencialPassword);
        validador = new ValidarTraslado();
    }
    /**
     * Método para registrar una Orden de traslado.
     * @param traslado Orden de traslado a registrar.
     * @return Valor booleano, true si se registro, false en caso contrario.
     * @throws PersistenciaException Excepción a lanzar en caso de haber un error.
     */
    @Override
    public boolean registrarTraslado(OrdenTraslado traslado) throws PersistenciaException{
        boolean validado;
        try{
        validado = validador.validarTraslado(traslado);
        }catch(PersistenciaException ex){
            throw new PersistenciaException(ex.getMessage());
        }
        if(validado){
            OrdenTraslado trasladoRegistrado = persistencia.agregarOrdenTraslado(traslado);
            if(trasladoRegistrado.getId() != null){
                String asunto = "Orden de Traslado notificada";
                String contenido = "Este correo es para notificarle sobre la orden de traslado a la ciudad "+ persistencia.consultarDestino(traslado.getIdDestino()).getCiudad()
                        + " del residuo "+ persistencia.consultarResiduo(traslado.getIdResiduo()).getNombre() + " con un precio inicial de $"+traslado.getPrecio();
                if(mensajeria.enviarNotificacion(asunto, contenido)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}

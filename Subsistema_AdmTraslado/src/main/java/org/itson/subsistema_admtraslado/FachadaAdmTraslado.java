/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    
    public FachadaAdmTraslado(String credencialCorreo, String credencialPassword) {
        persistencia = new FachadaPersistencia();
        mensajeria = new FachadaCorreo(credencialCorreo, credencialPassword);
        validador = new ValidarTraslado();
    }

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

package mensajeria;

/**
 * Interfaz de mecanismo de notificación por correo utilizando Gmail.
 * @author Equipo 3 - Diseño de Software.
 */
public interface IMensajeria {
    
    /**
     * Este método envia la notificación de correo a los destinatarios.
     * @param asunto Representa el asunto del correo.
     * @param contenido Representa el contenido del correo.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    public boolean enviarNotificacion(String asunto, String contenido);

}

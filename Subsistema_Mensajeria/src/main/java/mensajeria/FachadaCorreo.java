package mensajeria;

import java.util.List;
import org.itson.daos.FachadaPersistencia;


/**
 * Fachada del mecanismo de mensajería por correo.
 * @author Equipo 3 - Diseño de Software.
 */
public class FachadaCorreo implements IMensajeria{

    
    /**
     * Representa la fachada dao.
     */
    private FachadaPersistencia fachadaDAO;
    /**
     * Representa el mecanismo de notificación por correo.
     */
    private EmailNotifier fachadaMensajeria;
    
    /**
     * Este método constructor se utiliza para establecer las credenciales.
     * @param emailFrom Representa el correo origen.
     * @param passwordFrom Representa el password origen.
     */
    public FachadaCorreo(String emailFrom, String passwordFrom) {
        fachadaMensajeria = new EmailNotifier(emailFrom, passwordFrom);
        fachadaDAO = new FachadaPersistencia();
    }
    
    /**
     * Este método envia la notificación de correo a los destinatarios.
     * @param asunto Representa el asunto del correo.
     * @param contenido Representa el contenido del correo.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    @Override
    public boolean enviarNotificacion(String asunto, String contenido) {
        List<String> destinatarios = fachadaDAO.consultarListaCorreosTransportistas();
        return fachadaMensajeria.enviarNotificacion(destinatarios, asunto, contenido);
    }
}

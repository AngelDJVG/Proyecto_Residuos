package mensajeria;

import java.util.ArrayList;
import java.util.List;

/**
 * Fachada del mecanismo de mensajería por correo.
 * @author Equipo 3 - Diseño de Software.
 */
public class FachadaCorreo implements IMensajeria{

    /*
    Representa la fachada dao.
    */
    //private FachadaDAO fachadaDAO;
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
        //fachadaDAO = new FachadaDAO();
    }
    
    /**
     * Este método envia la notificación de correo a los destinatarios.
     * @param asunto Representa el asunto del correo.
     * @param contenido Representa el contenido del correo.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    @Override
    public boolean enviarNotificacion(String asunto, String contenido) {
        //List<String> destinatarios = fachadaDAO.consultarCorreosTransportistas();
        List<String> destinatarios = new ArrayList<>(); //PRUEBA
        destinatarios.add("mario.diaz233259@potros.itson.edu.mx"); //PRUEBA
        return fachadaMensajeria.enviarNotificacion(destinatarios, asunto, contenido);
    }
    
}

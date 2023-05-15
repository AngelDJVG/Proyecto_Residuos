package mensajeria;

import java.util.List;
import java.util.Properties;
import javax.mail.internet.*;
import javax.mail.*;

/**
 * Mecanismo de notificación por correo utilizando Gmail.
 * @author Equipo 3 - Diseño de Software.
 */
public class EmailNotifier {

    /**
     * Representa el correo desde el cual se mandarán los correos.
     */
    private String emailOrigen;
    /**
     * Representa la contraseña del correo correspondiente.
     */
    private String passwordOrigen;
    /**
     * Representa los destinatarios del correo.
     */
    private List<String> destinatarios;
    /**
     * Representa el asunto del correo.
     */
    private String asunto;
    /**
     * Representa el contenido del correo.
     */
    private String contenido;
    /**
     * Representa las propiedades de la conexión con el servicio de correo.
     */
    private Properties mProperties;
    /**
     * Representa la sesión del servicio de correo.
     */
    private Session mSession;
    /**
     * Representa el correo a enviar.
     */
    private MimeMessage mCorreo;

    /**
     * Este método constructor se encarga de establecer las credenciales 
     * de correo y de instanciar el objeto de propiedades de la conexión.
     * @param emailFrom Representa el correo desde el cual se mandarán los correos.
     * @param passwordFrom Representa la contraseña del correo correspondiente.
     */
    public EmailNotifier(String emailFrom, String passwordFrom) {
        this.emailOrigen = emailFrom;
        this.passwordOrigen = passwordFrom;
        this.mProperties = new Properties();
    }

    /**
     * Este método envia la notificación de correo a los destinatarios.
     * @param destinatarios Representan los destinatarios del correo.
     * @param asunto Representa el asunto del correo.
     * @param contenido Representa el contenido del correo.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    public boolean enviarNotificacion(List<String> destinatarios, String asunto, String contenido) {
        if(!destinatarios.isEmpty()){
            return configurarCorreo(destinatarios, asunto, contenido)&&crearCorreo()&&enviarCorreo();
        }else{
            return false;
        }
    }

    /**
     * Este método se encarga de establecer los destinatarios, asunto y contenido, al igual que 
     * configuración de la conexión al servicio de correo.
     * @param destinatarios Representan los destinatarios del correo.
     * @param asunto Representa el asunto del correo.
     * @param contenido Representa el contenido del correo.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    private boolean configurarCorreo(List<String> destinatarios, String asunto, String contenido){
        this.destinatarios = destinatarios;
        this.asunto = asunto;
        this.contenido = contenido;

        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailOrigen);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);
        
        return true;
    }
    
    /**
     * Este método se encarga de crear el mensaje del correo e indicar a que destinatarios
     * se enviará el correo.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    private boolean crearCorreo() {
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailOrigen));
            for (String destinatario : destinatarios) {
                mCorreo.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            }
            mCorreo.setSubject(asunto);
            mCorreo.setText(contenido, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            return false;
        } catch (MessagingException ex) {
            return false;
        }
        return true;
    }

    /**
     * Este método se encarga de enviar el correo a los destinatarios.
     * @return Regresa true en caso de éxito, false en caso contrario.
     */
    private boolean enviarCorreo() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailOrigen, passwordOrigen);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            return false;
        } catch (MessagingException ex) {
            return false;
        }
        return true;
    }
}
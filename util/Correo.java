package util;

import java.util.Properties;
import javax.mail.Session;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.Transport;

public class Correo {

  private static final String nombreUsuario = "viajesitcr@gmail.com";
  private static final String contrasenia = "Progra1POO";
  private Properties propiedades;
  private Session sesion;

  public Correo() {
    setPropiedades();
    setSesion();
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }
  
  private void setPropiedades() {
    propiedades = new Properties();
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    propiedades.put("mail.smtp.host", "smtp.gmail.com");
    propiedades.put("mail.smtp.port", "587");
    propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
  }
  
  private void setSesion() {
    sesion = Session.getInstance(propiedades, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(nombreUsuario, contrasenia);
      }
	});
  }
  
  public void enviar(String destinatario, String contenido, String asunto) throws AddressException, 
      MessagingException {
    Message mensaje = new MimeMessage(sesion);
    mensaje.setFrom(new InternetAddress("viajesITCR@gmail.com"));
    mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
    mensaje.setSubject(asunto);
    mensaje.setText(contenido);
    Transport.send(mensaje);
  }
  
  public void enviarConAdjunto(String destinatario, String contenido, String asunto, 
      String nombreArchivo) throws MessagingException {
    BodyPart texto = new MimeBodyPart();
    BodyPart adjunto = new MimeBodyPart();
    texto.setText(contenido);
    adjunto.setDataHandler(new DataHandler(new FileDataSource(nombreArchivo)));
    adjunto.setFileName(nombreArchivo);
    MimeMultipart multiParte = new MimeMultipart();
    multiParte.addBodyPart(texto);
    multiParte.addBodyPart(adjunto);
    Message mensaje = new MimeMessage(sesion);
    mensaje.setFrom(new InternetAddress("viajesITCR@gmail.com"));
    mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
    mensaje.setSubject(asunto);
    mensaje.setContent(multiParte);
    Transport.send(mensaje);
    
  }

}

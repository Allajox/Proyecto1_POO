/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.entregables;

/**
 *
 * @author usuario
 */

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class enviarCorreo {

    private String usuario;
    private String clave;
    private String destino;
    private String titulo;
    private String mensaje;

    public enviarCorreo(String usuario, String clave, String destino, String titulo, String mensaje) {
        this.usuario = usuario;
        this.clave = clave;
        this.destino = destino;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public String enviar() {
        Properties configuracion = new Properties();
        configuracion.put("mail.smtp.auth", "true");
        configuracion.put("mail.smtp.starttls.enable", "true");
        configuracion.put("mail.smtp.host", "smtp.gmail.com");
        configuracion.put("mail.smtp.port", "587");

        Session sesionCorreo = Session.getInstance(configuracion, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });

        try {
            Message correo = new MimeMessage(sesionCorreo);
            correo.setFrom(new InternetAddress(usuario));
            correo.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            correo.setSubject(titulo);
            correo.setText(mensaje);

            Transport.send(correo);
            return "Correo enviado correctamente";
        } catch (MessagingException error) {
            return "Error en el envío: " + error.getMessage();
        }
   }
}
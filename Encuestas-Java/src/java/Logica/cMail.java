/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.util.Properties;
import javax.mail.*;


/**
 *
 * @author Ger
 */
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class cMail {
    
    String _cuerpoMsj = "";
    String _para = "";
    String _titulo = "";
    String _usr = "noreplaysadregistro@gmail.com";
    String _psw = "34syS0ft";
    
    public cMail(String Para, String Titulo, String Mensaje)
    {
        this._cuerpoMsj = Mensaje;
        this._para = Para;
        this._titulo = Titulo;
    }
    
     public boolean SendMail() {
         boolean salida = false;
         String error = "";
         Properties props = new Properties();
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.port", "587");
         
         

         Session session = Session.getInstance(props,
                 new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(_usr, _psw);
                     }
                 });

         try {

             Message message = new MimeMessage(session);
             message.setFrom(new InternetAddress(_usr));
             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(_para));
             message.setContent(_cuerpoMsj,"text/html"); //Para que sea HTML 
             message.setSubject(_titulo);
             //message.setText(_cuerpoMsj); Texto plano

             Transport.send(message);
             salida = true;
            

         } catch (MessagingException e) {
             //throw new RuntimeException(e);
            error = e.toString();
         }
        
         return salida;
    }
    
}



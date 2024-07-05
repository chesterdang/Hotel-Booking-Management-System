/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import service.supplier.IConfirmEmail;

/**
 *
 * @author danhv
 */
public class ConfirmEmail implements  IConfirmEmail{

    @Override
    public Boolean sendMail(String email, String header, String text) {
        final String from = "dddhotel666@gmail.com";
        final String appPass ="gnue hbdc jbnd gmct";
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            
           Authenticator auth = new Authenticator() {
               @Override
               protected PasswordAuthentication getPasswordAuthentication(){
                   return new PasswordAuthentication(from,appPass);
               }
           };
           
           Session session = Session.getInstance(props, auth);
           
           MimeMessage msg = new MimeMessage(session);
           
           try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
           msg.setFrom(from);
           msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email, false));
//           msg.setSubject(header + System.currentTimeMillis());
           msg.setSubject(header);
           msg.setSentDate(new Date());
           msg.setText(text,"UTF-8");
   //         msg.setContent(text, "text/html");
           
               Transport.send(msg);
           
        } catch (Exception e) {
               System.out.println(e);
               return false;
        }
           
           return true;
    }
}

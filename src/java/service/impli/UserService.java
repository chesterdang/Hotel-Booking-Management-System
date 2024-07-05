/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import dao.IAdminDAO;
import dao.ICustomerDAO;
import dao.IHotelDAO;
import dao.ISupplierDAO;
import dao.impli.AdminDAO;
import dao.impli.CustomerDAO;
import dao.impli.HotelDAO;
import dao.impli.SupplierDAO;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Person;
import service.IUserService;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;

/**
 *
 * @author Hi
 */
public class UserService implements IUserService{
    private final ICustomerDAO CustomerDAO = new CustomerDAO();
    private final IAdminDAO AdminDAO = new AdminDAO();
    private final ISupplierDAO SupplierDAO = new SupplierDAO();
    private IHotelDAO hotelDao = new HotelDAO();
    
    @Override
    public Boolean checkFormatEmail(String email) {
       String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";  
         Pattern pattern = Pattern.compile(regex);  
         Matcher matcher = pattern.matcher(email);  
        return matcher.matches();
    }

    @Override
    public Boolean checkFormatPassword(String pass) {
        return pass.length()>=3;
    }

    @Override
    public Person findAccountByEmailAndPass(String email, String pass) {
        
        if (CustomerDAO.findAccount(email, pass)!=null) {
            return CustomerDAO.findAccount(email, pass);
        }
        if (AdminDAO.findAccount(email, pass)!= null) {
            return AdminDAO.findAccount(email, pass);
        }
        if (SupplierDAO.findAccount(email, pass)!= null) {
            return SupplierDAO.findAccount(email, pass);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
       UserService us = new UserService();

     us.sendMail("draculedolar0763@gmail.com", "Khuong dep trai", "<!DOCTYPE html><html><body><button  type=\"submit\">Reset Password</button></body></html>");
      
    }

    @Override
    public Boolean checkExistEmail(String email) {
        if (CustomerDAO.checkExist(email)) {
            return CustomerDAO.checkExist(email);
        }
        if (AdminDAO.checkExist(email)) {
            return AdminDAO.checkExist(email);
        }
        if (SupplierDAO.checkExist(email)) {
            return SupplierDAO.checkExist(email);
        }
        
        return false;
        
    }

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
//           msg.setText(text,"UTF-8");
            msg.setContent(text, "text/html; charset=UTF-8");
           
               Transport.send(msg);
           
        } catch (Exception e) {
               System.out.println(e);
               return false;
        }
           
           return true;
     
    }
    
    @Override
    public String createCaptcha(){
        Random random = new Random();     
        int randomNumber = random.nextInt(9000) + 1000;
        return String.valueOf(randomNumber);
    }
    
    @Override
    public Boolean isEquals(String String1,String string2){
        return String1.equals(string2);
    }

    @Override
    public Person findAccountByEmail(String email) {
           if (CustomerDAO.findBy(email)!=null) {
            return CustomerDAO.findBy(email);
        }
        if (AdminDAO.findBy(email)!= null) {
            return AdminDAO.findBy(email);
        }
        if (SupplierDAO.findBy(email)!= null) {
            return SupplierDAO.findBy(email);
        }
        
        return null;
    }

    @Override
    public Boolean addCaptcha(String code, Timestamp validCapchaTime, String email) {
         if (CustomerDAO.addCaptcha(code, validCapchaTime, email)) {
            return CustomerDAO.addCaptcha(code, validCapchaTime, email);
        }
        if (AdminDAO.addCaptcha(code, validCapchaTime, email)) {
            return AdminDAO.addCaptcha(code, validCapchaTime, email);
        }
        if (SupplierDAO.addCaptcha(code, validCapchaTime, email)) {
            return SupplierDAO.addCaptcha(code, validCapchaTime, email);
        }
        
        return false;
        
    }

    @Override
    public Boolean isEqualsCaptcha(String code,String email) {
         return findAccountByEmail(email).getCapcha().equals(code);
    }

    @Override
    public Boolean isValidCode(Timestamp time,String email) {
       long x = (time.getTime() - findAccountByEmail(email).getValidCapchaTime().getTime())/1000;
        return (x<=60)?true:false;
    }

    @Override
    public Boolean editPasswordByEmail(String pass, String email) {
         if (CustomerDAO.editPassword(pass, email)) {
            return CustomerDAO.editPassword(pass, email);
        }
        if (AdminDAO.editPassword(pass, email)) {
            return AdminDAO.editPassword(pass, email);
        }
        if (SupplierDAO.editPassword(pass, email)) {
            return SupplierDAO.editPassword(pass, email);
        }
        
        return false;
        
    }
    
    //Hung
    
    @Override
    public Boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
    
    @Override
    public Boolean registUser(String fullname, String pass,java.sql.Date dob, String role,String email,String phone, String address, Long hotelId) {
        if (role.equals("Cust")) {
            return CustomerDAO.insert(fullname,pass,dob,role,email,phone,address)!=null?true:false;
        }
        if (role.equals("Sup")) {
            return SupplierDAO.insert(fullname,pass,dob,role,email,phone,address,hotelId)!=null?true:false;
            
        }
      return false;
    }

    @Override
    public Long registHotel(String name, String address, String postcode, int numRoom, String phone, Double starRating) {
        return hotelDao.insertHotel(name, address, postcode, numRoom, phone, starRating);
    }

  
    
  

    
}

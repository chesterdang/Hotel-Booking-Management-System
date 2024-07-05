/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.sql.Date;
import java.sql.Timestamp;
import model.Person;

/**
 *
 * @author Hi
 */
public interface IUserService {
    Boolean editPasswordByEmail(String pass,String email);
    Boolean isEqualsCaptcha(String code,String email);
    Boolean isValidCode(Timestamp time, String email);
    String createCaptcha();
    Boolean isEquals(String String1,String string2);
    Boolean addCaptcha(String code, Timestamp validCapchaTime, String email);
    Person findAccountByEmail(String email);
    Person findAccountByEmailAndPass(String email, String pass);
    Boolean checkFormatEmail(String email);
    Boolean checkFormatPassword(String pass);
    Boolean checkExistEmail(String email);
    Boolean sendMail(String email, String header, String text);
    //Hung

    Boolean confirmPassword(String password, String confirmPassword); 
    Boolean registUser(String fullname, String pass,java.sql.Date dob, String role,String email,String phone, String address, Long hotelId);
    Long registHotel(String name, String address, String postcode, int numRoom, String phone, Double starRating);
}

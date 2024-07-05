/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.Timestamp;
import model.AdminModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IAdminDAO {
    AdminModel findBy(long id);
    Boolean editPassword(String password,String email);
    Boolean addCaptcha(String code, Timestamp validCapchaTime, String email);
     AdminModel findAccount(String email,String pass);
     AdminModel findBy(String email);
    Boolean checkExist(String email);
    
    //HungFunc
    Boolean check(String username);
    
    boolean changePassword(AdminModel adminModel);
    
    AdminModel selecByUserName(String email);
    
    boolean updateInfoAdmin(String fullname , Date dob , String phone ,String address  ,long id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Admin;

import java.sql.Date;
import java.util.List;
import model.AdminModel;

/**
 *
 * @author quandba
 */
public interface IAdminService {
    boolean changePassword(AdminModel adminModel); 
    
    AdminModel selecByUserName(String email);
    
    AdminModel findBy(long id);
    
    boolean updateInfoAdmin(String fullname , Date dob , String phone ,String address  , long id);
    
   
      
    
}

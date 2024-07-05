/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *a 
 * @author Nguyen Quang Hau
 */
public class CustomerModel extends Person{

    public CustomerModel() {
    }

    public CustomerModel(long id) {
        super(id);
    }
    
    public CustomerModel(long id, String fullname, String password, Date dob, RoleModel roleModel, String email, String phone, short status, String address, long modifiedBy, Timestamp modifiedDate, Timestamp createdDate, String avatar) {
        super(id, fullname, password, dob, roleModel, email, phone, status, address, modifiedBy, modifiedDate, createdDate, avatar);
    }
    
     public CustomerModel(long id, String fullname,String dob, String email, String phone,String address, String avatar) {
        super(id, fullname, dob, email, phone, address, avatar);
    }
    
    public CustomerModel(long id, String fullname,Date dob, String email, String phone,String address, String avatar) {
        super(id, fullname, dob, email, phone, address, avatar);
    }
    
    public CustomerModel(long id, String password) {
        super(id, password);
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
     
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Nguyen Quang Hau
 */
public class AdminModel extends Person{

    public AdminModel() {
    }

    public AdminModel(long id, String fullname, String password, Date dob, RoleModel roleModel, String email, String phone, short status, String address, long modifiedBy, Timestamp modifiedDate, Timestamp createdDate, String avatar) {
        super(id, fullname, password, dob, roleModel, email, phone, status, address, modifiedBy, modifiedDate, createdDate, avatar);
    }
    

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    } 
}

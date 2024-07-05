/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nguyen Quang Hau
 */
public abstract class Person {

    private long id;
    private String fullname;
    private String password;
    private Date dob;
    private RoleModel roleModel;
    private String email;
    private String phone;
    private short status;
    private String address;
    private long modifiedBy;
    private Timestamp modifiedDate;
    private Timestamp createdDate;
    private String avatar;
    private String capcha;
    private Timestamp validCapchaTime;

    public Person() {
    }

    public Person(long id) {
        this.id = id;
    }

    public Person(long id, String fullname, String password, Date dob, RoleModel roleModel, String email, String phone, short status, String address, long modifiedBy, Timestamp modifiedDate, Timestamp createdDate, String avatar) {
        this.id = id;
        this.fullname = fullname;
        this.password = password;
        this.dob = dob;
        this.roleModel = roleModel;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.address = address;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
        this.avatar = avatar;
    }

    public Person(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Person(long id, String fullname, String dob, String email, String phone, String address, String avatar) {
        this.id = id;
        this.fullname = fullname;
        this.setDob(dob);
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
    }

    public Person(long id, String fullname, java.sql.Date dob, String email, String phone, String address, String avatar) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
    }

    public Person(String fullname, String password, Date dob, RoleModel roleModel, String email, String phone, String address) {

        this.fullname = fullname;
        this.password = password;
        this.dob = dob;
        this.roleModel = roleModel;
        this.email = email;
        this.phone = phone;

        this.address = address;

    }

    public String getCapcha() {
        return capcha;
    }

    public void setCapcha(String capcha) {
        this.capcha = capcha;
    }

    public Timestamp getValidCapchaTime() {
        return validCapchaTime;
    }

    public void setValidCapchaTime(Timestamp validCapchaTime) {
        this.validCapchaTime = validCapchaTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDOB() {
        return dob;
    }
//
//    public void setDob(Date dob) {
//        this.dob = dob;
//    }
    public String getDob() {
        return dob.toString();
    }

    public String getDateOB() {
        if (dob == null) {
            return "";
        }
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        return sd.format(dob);
    }

    public void setDob(String d) {
        this.dob = java.sql.Date.valueOf(d);
    }

    public void setDob(java.sql.Date d) {
        this.dob = d;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fullname=" + fullname + ", dob=" + dob + ", roleModel=" + roleModel + ", email=" + email + ", phone=" + phone + ", status=" + status + ", address=" + address + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", createdDate=" + createdDate + '}';
    }

}

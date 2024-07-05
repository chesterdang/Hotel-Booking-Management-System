/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author Nguyen Quang Hau
 */
public class ReportModel {
    private long id;
    private CustomerModel customerModel;
    private RoomModel roomModel;
    private Timestamp createdDate;
    private String content;

    public ReportModel() {
    }

    public ReportModel(long id, CustomerModel customerModel, RoomModel roomModel, Timestamp createdDate, String content) {
        this.id = id;
        this.customerModel = customerModel;
        this.roomModel = roomModel;
        this.createdDate = createdDate;
        this.content = content;
    }
    
    public ReportModel( CustomerModel customerModel, RoomModel roomModel, Timestamp createdDate, String content) {
        this.customerModel = customerModel;
        this.roomModel = roomModel;
        this.createdDate = createdDate;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReportModel{" + "id=" + id + ", customerModel=" + customerModel + ", roomModel=" + roomModel + ", createdDate=" + createdDate + ", content=" + content + '}';
    }
}

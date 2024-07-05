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
public class CancelBookingModel {
    private long id;
    private CustomerModel customerModel;
    private BookingModel bookingModel;
    private String content;
    private Timestamp createdDate;
    private short status;

    public CancelBookingModel() {
    }

    public CancelBookingModel(long id, CustomerModel customerModel, BookingModel bookingModel, String content, Timestamp createdDate, short status) {
        this.id = id;
        this.customerModel = customerModel;
        this.bookingModel = bookingModel;
        this.content = content;
        this.createdDate = createdDate;
        this.status = status;
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

    public BookingModel getBookingModel() {
        return bookingModel;
    }

    public void setBookingModel(BookingModel bookingModel) {
        this.bookingModel = bookingModel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "CancelBookingModel{" + "id=" + id + ", customerModel=" + customerModel + ", bookingModel=" + bookingModel + ", content=" + content + ", createdDate=" + createdDate + ", status=" + status + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigDecimal;
import java.sql.*;
/**
 *
 * @author Nguyen Quang Hau
 */
public class InvoiceModel {
    private long id;
    private BookingModel bookingModel;
    private CustomerModel customerModel;
    private java.math.BigDecimal roomCharge;
    private String roomService;
    private Timestamp paymentDate;
    private String paymentMode;
    private String creditCardNo;

    public InvoiceModel() {
    }

    public InvoiceModel(long id, BookingModel bookingModel, CustomerModel customerModel, BigDecimal roomCharge, String roomService, Timestamp paymentDate, String paymentMode, String creditCardNo) {
        this.id = id;
        this.bookingModel = bookingModel;
        this.customerModel = customerModel;
        this.roomCharge = roomCharge;
        this.roomService = roomService;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.creditCardNo = creditCardNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BookingModel getBookingModel() {
        return bookingModel;
    }

    public void setBookingModel(BookingModel bookingModel) {
        this.bookingModel = bookingModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public BigDecimal getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(BigDecimal roomCharge) {
        this.roomCharge = roomCharge;
    }

    

    public String getRoomService() {
        return roomService;
    }

    public void setRoomService(String roomService) {
        this.roomService = roomService;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", bookingModel=" + bookingModel + ", customerModel=" + customerModel + ", money=" + roomCharge + ", roomService=" + roomService + ", paymentDate=" + paymentDate + ", paymentMode=" + paymentMode + ", creditCardNo=" + creditCardNo + '}';
    }
}

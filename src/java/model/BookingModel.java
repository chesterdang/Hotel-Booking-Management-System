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
public class BookingModel {
    private long id;
    private HotelModel hotelModel;
    private CustomerModel customerModel;
    private RoomModel roomModel;
    private Timestamp bookingTime;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private int numAdults;
    private int numChilds;
    private String specialReq;
    private short status;

    public BookingModel() {
    }

    public BookingModel(long id, HotelModel hotelModel, CustomerModel customerModel, RoomModel roomModel, Timestamp bookingTime, Timestamp arrivalTime, Timestamp departureTime, int numAdults, int numChilds, String specialReq, short status) {
        this.id = id;
        this.hotelModel = hotelModel;
        this.customerModel = customerModel;
        this.roomModel = roomModel;
        this.bookingTime = bookingTime;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.numAdults = numAdults;
        this.numChilds = numChilds;
        this.specialReq = specialReq;
        this.status = status;
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HotelModel getHotelModel() {
        return hotelModel;
    }

    public void setHotelModel(HotelModel hotelModel) {
        this.hotelModel = hotelModel;
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

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public int getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(int numAdults) {
        this.numAdults = numAdults;
    }

    public int getNumChilds() {
        return numChilds;
    }

    public void setNumChilds(int numChilds) {
        this.numChilds = numChilds;
    }

    public String getSpecialReq() {
        return specialReq;
    }

    public void setSpecialReq(String specialReq) {
        this.specialReq = specialReq;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingModel{" + "id=" + id + ", hotelModel=" + hotelModel + ", customerModel=" + customerModel + ", roomModel=" + roomModel + ", bookingTime=" + bookingTime + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", numAdults=" + numAdults + ", numChilds=" + numChilds + ", specialReq=" + specialReq + ", status=" + status + '}';
    }
}

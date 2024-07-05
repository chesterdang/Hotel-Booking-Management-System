/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author danhv
 */
public class Contract {
    private int count;
    private long customerId;
    private long hotelId;
    private Timestamp bookingTime;

    public Contract(int count, long customerId, long hotelId, Timestamp bookingTime) {
        this.count = count;
        this.customerId = customerId;
        this.hotelId = hotelId;
        this.bookingTime = bookingTime;
    }

    public Contract() {
        
    }

    public int getCount() {
        return count;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Contract{" + "count=" + count + ", customerId=" + customerId + ", hotelId=" + hotelId + ", bookingTime=" + bookingTime + '}';
    }
    
    
    
}

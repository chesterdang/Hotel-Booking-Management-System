/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoomModel {
    private long roomNo;
    private HotelModel hotelModel;
    private RoomTypeModel roomTypeModel;
    private int occupancy;
    private String priceIncludes;
    private short status;
    private String avatar;
    private java.math.BigDecimal money;
    
    public RoomModel() {
    }

    public RoomModel(long roomNo) {
        this.roomNo = roomNo;
    }
    
    
    public RoomModel(long roomNo, HotelModel hotelModel, RoomTypeModel roomTypeModel, int occupancy, String priceIncludes, short status, String avatar, BigDecimal money) {
        this.roomNo = roomNo;
        this.hotelModel = hotelModel;
        this.roomTypeModel = roomTypeModel;
        this.occupancy = occupancy;
        this.priceIncludes = priceIncludes;
        this.status = status;
        this.avatar = avatar;
        this.money = money;
    }
    
    public RoomModel( HotelModel hotelModel, RoomTypeModel roomTypeModel, int occupancy, String priceIncludes, short status, String avatar, BigDecimal money) {
        this.roomNo = roomNo;
        this.hotelModel = hotelModel;
        this.roomTypeModel = roomTypeModel;
        this.occupancy = occupancy;
        this.priceIncludes = priceIncludes;
        this.status = status;
        this.avatar = avatar;
        this.money = money;
    }
    
    public RoomModel(long roomNo, long hotelId, RoomTypeModel roomTypeModel, int occupancy, String priceIncludes, short status, String avatar) {
        this.roomNo = roomNo;
        this.hotelModel.setId(hotelId);
        this.roomTypeModel = roomTypeModel;
        this.occupancy = occupancy;
        this.priceIncludes = priceIncludes;
        this.status = status;
        this.avatar = avatar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.roomNo ^ (this.roomNo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoomModel other = (RoomModel) obj;
        return this.roomNo == other.roomNo;
    }

    

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    
    public String getFormatedPrice(){
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(this.money);
    }
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public HotelModel getHotelModel() {
        return hotelModel;
    }

    public void setHotelModel(HotelModel hotelModel) {
        this.hotelModel = hotelModel;
    }

    

    
    public long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(long roomNo) {
        this.roomNo = roomNo;
    }
    
    public RoomTypeModel getRoomTypeModel() {
        return roomTypeModel;
    }

    public void setRoomTypeModel(RoomTypeModel roomTypeModel) {
        this.roomTypeModel = roomTypeModel;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public String getPriceIncludes() {
        return priceIncludes;
    }

    public void setPriceIncludes(String priceIncludes) {
        this.priceIncludes = priceIncludes;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomModel{" + "roomNo=" + roomNo + ", hotelModel=" + hotelModel + ", roomTypeModel=" + roomTypeModel + ", occupancy=" + occupancy + ", priceIncludes=" + priceIncludes + ", status=" + status + ", avatar=" + avatar + ", money=" + money + '}';
    }
}

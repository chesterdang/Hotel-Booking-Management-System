/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Nguyen Quang Hau
 */
public class HotelModel {
    private long id;
    private String name;
    private String address;
    private String postcode;
    private int numRooms;
    private String phone;
    private double starRating;
    private List<RoomModel> rooms;
    private String avatar;
            
    public HotelModel() {
    }

    public HotelModel(long id, String name, String address, String postcode, int numRooms, String phone, double starRating, List<RoomModel> rooms, String avatar) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.numRooms = numRooms;
        this.phone = phone;
        this.starRating = starRating;
        this.rooms = rooms;
        this.avatar = avatar;
    }
    
    

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
    
    
    

    public List<RoomModel> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomModel> rooms) {
        this.rooms = rooms;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

    @Override
    public String toString() {
        return "HotelModel{" + "id=" + id + ", name=" + name + ", address=" + address + ", postcode=" + postcode + ", numRooms=" + numRooms + ", phone=" + phone + ", starRating=" + starRating + ", rooms=" + rooms + ", avatar=" + avatar + '}';
    }

    

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ManageFavRoomModel {
    private long id;
    private RoomModel roomModel;
    private CustomerModel customerModel;

    public ManageFavRoomModel() {
    }

    public ManageFavRoomModel(long id, RoomModel roomModel, CustomerModel customerModel) {
        this.id = id;
        this.roomModel = roomModel;
        this.customerModel = customerModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    public String toString() {
        return "ManageFavRoomModel{" + "id=" + id + ", roomModel=" + roomModel + ", customerModel=" + customerModel + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.HotelModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IHotelDAO {
    HotelModel findBy(long hotelId);
    HotelModel getHotel(long hotelId);
    HotelModel getHotelBy(long supplierId);
     Long insertHotel( String name, String address, String postcode, int numRoom, String phone, Double starRating );
}

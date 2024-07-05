/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import model.HotelModel;

/**
 *
 * @author MaiGiang
 */
public interface IHotelService {
    HotelModel getHotelBy(long supplierId);
}

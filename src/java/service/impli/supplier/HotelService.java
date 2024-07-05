/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.IHotelDAO;
import dao.impli.HotelDAO;
import model.HotelModel;
import service.supplier.IHotelService;

/**
 *
 * @author MaiGiang
 */
public class HotelService implements IHotelService{
    private IHotelDAO hotelDAO = new HotelDAO();
    
    @Override
    public HotelModel getHotelBy(long supplierId) {
        return hotelDAO.getHotelBy(supplierId);
    }
    
}

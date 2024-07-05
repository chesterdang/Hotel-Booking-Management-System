/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.IBookingDAO;
import dao.IHotelDAO;
import dao.impli.BookingDAO;
import dao.impli.HotelDAO;
import java.math.BigDecimal;
import model.HotelModel;
import service.supplier.IReport;

/**
 *
 * @author danhv
 */
public class Report implements IReport {

    @Override
    public int totalBooking(long id) {
        IBookingDAO bd = new BookingDAO();
        return bd.count(id);
    }

    @Override
    public int availableRoom(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int roomCollection(long id) {
        IBookingDAO bd = new BookingDAO();
        long hotelId = bd.findBy(id).getHotelModel().getId();
        IHotelDAO hd = new HotelDAO();
        HotelModel hotel = hd.findBy(hotelId);
        return hotel.getNumRooms();
    }

    @Override
    public BigDecimal income(long id) {
        return  null;
    }
    
}

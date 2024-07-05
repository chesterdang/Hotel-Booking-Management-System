/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.ICustomerDAO;
import dao.IHotelDAO;
import dao.IRoomDAO;
import dao.impli.CustomerDAO;
import dao.impli.HotelDAO;
import dao.impli.RoomDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.BookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class BookingMapping implements IRowMapping<BookingModel>{
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IRoomDAO roomDAO = new RoomDAO();
    private final IHotelDAO hotelDAO = new HotelDAO();
    
    @Override
    public BookingModel mapRow(ResultSet rs) {
        BookingModel bookingModel = new BookingModel();
        
        try {
            bookingModel.setId(rs.getLong("id"));
            bookingModel.setHotelModel(hotelDAO.findBy(rs.getLong("hotelID")));
            bookingModel.setCustomerModel(customerDAO.findBy(rs.getLong("customerID")));
            bookingModel.setRoomModel(roomDAO.findBy(rs.getLong("roomNo")));
            bookingModel.setBookingTime(rs.getTimestamp("bookingTime"));
            bookingModel.setArrivalTime(rs.getTimestamp("arrivalTime"));
            bookingModel.setDepartureTime(rs.getTimestamp("departureTime"));
            bookingModel.setNumAdults(rs.getInt("numAdults"));
            bookingModel.setNumChilds(rs.getInt("numChilds"));
            bookingModel.setSpecialReq(rs.getString("specialReq"));
            bookingModel.setStatus(rs.getShort("status"));
        } catch (SQLException ex) {
            Logger.getLogger(BookingMapping.class.getName()).log(Level.SEVERE, null, ex);
            bookingModel = null;
        }
        
        return bookingModel;
    }
    
}

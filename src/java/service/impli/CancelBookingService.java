/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import dao.ICancelBookingDAO;
import dao.impli.CancelBookingDAO;
import java.sql.Timestamp;
import java.util.List;
import model.BookingModel;
import model.CancelBookingModel;
import model.CustomerModel;
import service.ICancelBookingService;

/**
 *
 * @author Nguyen Quang Hau
 */
public class CancelBookingService implements ICancelBookingService{
    private ICancelBookingDAO cancelBookingDAO = new CancelBookingDAO();
    
    @Override
    public Integer countCancelBooking(long customerId) {
        return cancelBookingDAO.countCancelBooking(customerId);
    }

    @Override
    public List<CancelBookingModel> findCancelBooking(long customerId, int offset, int fetch) {
        return cancelBookingDAO.findCancelBooking(customerId, offset, fetch);
    }

    @Override
    public void insert(long cusId, long bookingId, String content) {
        cancelBookingDAO.insert(cusId, bookingId, content, new Timestamp(System.currentTimeMillis()),(short) 2);
    }
    
}

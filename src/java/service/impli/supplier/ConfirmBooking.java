/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.IBookingDAO;
import dao.impli.BookingDAO;
import java.util.ArrayList;
import java.util.List;
import model.BookingModel;
import service.supplier.IConfirmBooking;

/**
 *
 * @author danhv
 */
public class ConfirmBooking implements IConfirmBooking{

    @Override
    public boolean verifyBooking(int action, long id) {
        IBookingDAO booking = new BookingDAO();
        return booking.updateStatus(action, id);
    }

    @Override
    public List<BookingModel> displayBooking(long customerId) {
        IBookingDAO booking = new BookingDAO();
        return booking.findAllPending(customerId);
    }
    
    
    @Override
    public List<BookingModel> displayAcceptedBooking(long customerId) {
        IBookingDAO booking = new BookingDAO();
        return booking.findAllAccepted(customerId);
    }
    public static void main(String[] args) {
        IConfirmBooking cb = new ConfirmBooking();
        System.out.println(cb.displayBooking(2));
    }

    @Override
    public List<BookingModel> displayDeclinedBooking(long customerId) {
        IBookingDAO booking = new BookingDAO();
        return booking.findAllDeclined(customerId);
    }

    @Override
    public List<BookingModel> displayDoneBooking(long customerId) {
        IBookingDAO booking = new BookingDAO();
        return booking.findAllDoned(customerId);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import dao.IBookingDAO;
import dao.impli.BookingDAO;
import java.util.List;
import model.BookingModel;
import service.IBookingService;
import java.sql.Timestamp;
/**
 *
 * @author Nguyen Quang Hau
 */
public class BookingService implements IBookingService {

    private IBookingDAO bookingDAO = new BookingDAO();

    @Override
    public List<BookingModel> findHistoryBooking(long customerId, int offset, int fetch) {
        return bookingDAO.findBooking(customerId, offset, fetch, (short) 3, (short) 7);
    }

    @Override
    public Integer countBooking(long customerId, short status1, short status2) {
        return bookingDAO.countBooking(customerId, status1, status2);
    }

    @Override
    public List<BookingModel> findPendingBooking(long customerId, int offset, int fetch) {
        return bookingDAO.findBooking(customerId, offset, fetch, (short) 0, (short) 4);
    }
    
    @Override
    public List<BookingModel> findAlreadyBooking(long customerId, int offset, int fetch) {
        return bookingDAO.findBooking(customerId, offset, fetch, (short) 1, (short) 5);
    }

    @Override
    public void insert(List<BookingModel> bookingList, int start, int end) {
        Timestamp bookingTime = new Timestamp(System.currentTimeMillis());
        try {
            for (int i = start; i <= end; i++) {
                BookingModel book = bookingList.get(i);
                book.setBookingTime(bookingTime);
                bookingDAO.insert(book);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void updateStatus(int status, long id) {
        bookingDAO.updateStatus(status, id);
    }

   
}

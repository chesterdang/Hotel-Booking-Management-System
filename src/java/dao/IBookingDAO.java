/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import model.BookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IBookingDAO {
    BookingModel findBy(long id);
    boolean findBy(long cusId, long roomNo);
    List<BookingModel> findBooking(long customerId, int offset, int fetch, short status1, short status2);
    Integer countBooking(long customerId, short status1, short status2);
    void insert(BookingModel bookingModel);
    boolean updateStatus(int action, long id);
    List<BookingModel> findAllPending(long id);
    List<BookingModel> findAllAccepted(long id);
    List<BookingModel> findAllDeclined(long id); 
    List<BookingModel> findAllDoned(long id); 
    int count(long id);
    BookingModel findByBookingTime(Timestamp bookingTime, long hotelId);
    int availableRoom(long id);
}

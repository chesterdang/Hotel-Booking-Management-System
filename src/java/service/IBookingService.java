/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.BookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IBookingService {
    Integer countBooking(long customerId, short status1, short status2);
    List<BookingModel> findHistoryBooking(long customerId, int offset, int fetch);
    List<BookingModel> findPendingBooking(long customerId, int offset, int fetch);
    List<BookingModel> findAlreadyBooking(long customerId, int offset, int fetch);
    void insert(List<BookingModel> bookingList, int start, int end);
    void updateStatus(int status,long id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import model.CancelBookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface ICancelBookingDAO{
    CancelBookingModel findBy (long id);
    Integer countCancelBooking(long customerId);
    List<CancelBookingModel> findCancelBooking(long customerId, int offset, int fetch);
    void insert(long cusId, long bookingId, String content, Timestamp createdDate, short status);
}

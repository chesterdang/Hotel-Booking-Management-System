/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import java.util.ArrayList;
import java.util.List;
import model.BookingModel;

/**
 *
 * @author danhv
 */
public interface IConfirmBooking {
    boolean verifyBooking (int action, long id);
    List<BookingModel> displayBooking (long customerId);
    List<BookingModel> displayAcceptedBooking (long customerId);
    List<BookingModel> displayDeclinedBooking (long customerId);
    List<BookingModel> displayDoneBooking (long customerId);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import dao.IContractDAO;
import dao.impli.ContractDAO;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import model.BookingModel;
import model.Contract;
import model.CustomerModel;
import model.HotelModel;

/**
 *
 * @author danhv
 */
public interface IConfirmContract {
    List<Contract> displayAllPending(long supplierID);
    List<Contract> displayAllAccepted(long supplierID);
    List<Contract> displayAllDeclined(long supplierID);
    List<Contract> displayAllDone(long supplierID);
    Map<String,Integer> countContractRoomType(long supplierID, long hotelID, long customerID, Timestamp bookingTime);
    Boolean verifyContract(short action, long hotelID, long customerID, Timestamp bookingTime);
    CustomerModel findCustomerById(long id);
    HotelModel findHotelById(long id);
    BookingModel findBooking(Timestamp bookingTime, long Id);
}

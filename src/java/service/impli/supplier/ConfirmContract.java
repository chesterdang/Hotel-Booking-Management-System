/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.IBookingDAO;
import dao.IContractDAO;
import dao.ICustomerDAO;
import dao.IHotelDAO;
import dao.impli.BookingDAO;
import dao.impli.ContractDAO;
import dao.impli.CustomerDAO;
import dao.impli.HotelDAO;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import model.BookingModel;
import model.Contract;
import model.CustomerModel;
import model.HotelModel;
import service.supplier.IConfirmContract;

/**
 *
 * @author danhv
 */
public class ConfirmContract implements IConfirmContract{

    @Override
    public List<Contract> displayAllPending(long supplierID) {
        IContractDAO cd = new ContractDAO();
        return cd.findAllPending(supplierID);
    }

    @Override
    public Map<String, Integer> countContractRoomType(long supplierID, long hotelID, long customerID, Timestamp bookingTime) {
        IContractDAO cd = new ContractDAO();
        return cd.countContractRoomType(supplierID, hotelID, customerID, bookingTime);
    }

    @Override
    public Boolean verifyContract(short action, long hotelID, long customerID, Timestamp bookingTime) {
        IContractDAO cd = new ContractDAO();
        return cd.updateStatus(action, hotelID, customerID, bookingTime);
    }

    @Override
    public List<Contract> displayAllAccepted(long supplierID) {
        IContractDAO cd = new ContractDAO();
        return cd.findAllAccepted(supplierID);
    }

    @Override
    public List<Contract> displayAllDeclined(long supplierID) {
        IContractDAO cd = new ContractDAO();
        return cd.findAllDeclined(supplierID);
    }

    @Override
    public List<Contract> displayAllDone(long supplierID) {
        IContractDAO cd = new ContractDAO();
        return cd.findAllDone(supplierID);
    }

    @Override
    public CustomerModel findCustomerById(long id) {
        ICustomerDAO cd = new CustomerDAO();
        return cd.findBy(id);
    }

    @Override
    public HotelModel findHotelById(long id) {
        IHotelDAO hd = new HotelDAO();
        return hd.findBy(id);
    }

    @Override
    public BookingModel findBooking(Timestamp bookingTime, long Id) {
        IBookingDAO bd = new BookingDAO();
        return bd.findByBookingTime(bookingTime, Id);
    }
   
}

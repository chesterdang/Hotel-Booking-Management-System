/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.IBookingDAO;
import dao.ICustomerDAO;
import dao.impli.BookingDAO;
import dao.impli.CustomerDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.InvoiceModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class InvoiceMapping implements IRowMapping<InvoiceModel>{
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IBookingDAO  bookingDAO = new BookingDAO();
    
    @Override
    public InvoiceModel mapRow(ResultSet rs) {
        InvoiceModel invoiceModel = new InvoiceModel();
        
        try {
            invoiceModel.setId(rs.getLong("id"));
            invoiceModel.setBookingModel(bookingDAO.findBy(rs.getLong("bookingID")));
            invoiceModel.setCustomerModel(customerDAO.findBy(rs.getLong("customerID")));
            invoiceModel.setRoomCharge(rs.getBigDecimal("roomCharge"));
            invoiceModel.setRoomService(rs.getString("roomService"));
            invoiceModel.setPaymentDate(rs.getTimestamp("paymentDate"));
            invoiceModel.setPaymentMode(rs.getString("paymentMode"));
            invoiceModel.setCreditCardNo(rs.getString("creditCardNo"));
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceMapping.class.getName()).log(Level.SEVERE, null, ex);
            invoiceModel = null;
        }
        
        return invoiceModel;
    }
    
}

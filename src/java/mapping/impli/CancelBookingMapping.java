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
import model.CancelBookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class CancelBookingMapping implements IRowMapping<CancelBookingModel> {

    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IBookingDAO bookingDAO = new BookingDAO();

    @Override
    public CancelBookingModel mapRow(ResultSet rs) {
        CancelBookingModel cancelBookingModel = new CancelBookingModel();

        try {
            cancelBookingModel.setId(rs.getLong("id"));
            cancelBookingModel.setCustomerModel(customerDAO.findBy(rs.getLong("customerID")));
            cancelBookingModel.setBookingModel(bookingDAO.findBy(rs.getLong("bookingid")));
            cancelBookingModel.setContent(rs.getString("content"));
            cancelBookingModel.setCreatedDate(rs.getTimestamp("createdDate"));
            cancelBookingModel.setStatus(rs.getShort("status"));
        } catch (SQLException ex) {
            Logger.getLogger(CancelBookingMapping.class.getName()).log(Level.SEVERE, null, ex);
            cancelBookingModel = null;
        }

        return cancelBookingModel;
    }

}

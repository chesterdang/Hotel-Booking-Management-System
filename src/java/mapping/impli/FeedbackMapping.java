/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.ICustomerDAO;
import dao.IRoomDAO;
import dao.impli.CustomerDAO;
import dao.impli.RoomDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.FeedbackModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class FeedbackMapping implements IRowMapping<FeedbackModel> {

    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IRoomDAO roomDAO = new RoomDAO();

    @Override
    public FeedbackModel mapRow(ResultSet rs) {
       FeedbackModel feedbackModel = new FeedbackModel();
       
       try {
            feedbackModel.setId(rs.getLong("id"));
            feedbackModel.setCustomerModel(customerDAO.findBy(rs.getLong("customerID")));
            feedbackModel.setRoomModel(roomDAO.findBy(rs.getLong("roomNo")));
            feedbackModel.setCreatedDate(rs.getTimestamp("createdDate"));
            feedbackModel.setContent(rs.getString("content"));
            feedbackModel.setStatus(rs.getShort("status"));
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackMapping.class.getName()).log(Level.SEVERE, null, ex);
            feedbackModel = null;
        }
       
       return feedbackModel;
    }

}

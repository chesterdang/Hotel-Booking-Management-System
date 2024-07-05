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
import model.ReportModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ReportMapping implements IRowMapping<ReportModel>{
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IRoomDAO roomDAO = new RoomDAO();
    
    @Override
    public ReportModel mapRow(ResultSet rs) {
        ReportModel reportModel = new ReportModel();
        
        try {
            reportModel.setId(rs.getLong("id"));
            reportModel.setCustomerModel(customerDAO.findBy(rs.getLong("customerId")));
            reportModel.setRoomModel(roomDAO.findBy(rs.getLong("roomNo")));
            reportModel.setCreatedDate(rs.getTimestamp("createdDate"));
            reportModel.setContent(rs.getString("content"));
        } catch (SQLException ex) {
            Logger.getLogger(ReportMapping.class.getName()).log(Level.SEVERE, null, ex);
            reportModel = null;
        }
        
        return reportModel;
    }
    
}

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
import model.ManageFavRoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ManageFavRoomMapping implements IRowMapping<ManageFavRoomModel> {

    private final IRoomDAO roomDAO = new RoomDAO();
    private final ICustomerDAO customerDAO = new CustomerDAO();
    
    @Override
    public ManageFavRoomModel mapRow(ResultSet rs) {
        ManageFavRoomModel manageRoomModel = new ManageFavRoomModel();

        try {
            manageRoomModel.setId(rs.getLong("id"));
            manageRoomModel.setRoomModel(roomDAO.findBy(rs.getLong("roomNo")));
            manageRoomModel.setCustomerModel(customerDAO.findBy(rs.getLong("customerId")));
        } catch (SQLException ex) {
            Logger.getLogger(ManageFavRoomMapping.class.getName()).log(Level.SEVERE, null, ex);
            manageRoomModel = null;
        }

        return manageRoomModel;
    }

}

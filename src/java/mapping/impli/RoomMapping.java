/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.IHotelDAO;
import dao.IRoomTypeDAO;
import dao.impli.HotelDAO;
import dao.impli.RoomTypeDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.RoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoomMapping implements IRowMapping<RoomModel>{
    private final IHotelDAO hotelDAO = new HotelDAO();
    private final IRoomTypeDAO roomTypeDAO = new RoomTypeDAO();
    
    @Override
    public RoomModel mapRow(ResultSet rs) {
        RoomModel roomModel = new RoomModel();
        
        try {
            roomModel.setRoomNo(rs.getLong("roomNo"));
            roomModel.setHotelModel(hotelDAO.getHotel(rs.getLong("hotelID")));
            roomModel.setRoomTypeModel(roomTypeDAO.findBy(rs.getLong("roomTypeId")));
            roomModel.setOccupancy(rs.getInt("occupancy"));
            roomModel.setPriceIncludes(rs.getString("priceIncludes"));
            roomModel.setStatus(rs.getShort("status"));
            roomModel.setAvatar(rs.getString("avatar"));
            roomModel.setMoney(rs.getBigDecimal("price"));
        } catch (SQLException ex) {
            Logger.getLogger(RoomMapping.class.getName()).log(Level.SEVERE, null, ex);
            roomModel = null;
        }
        

        
        return roomModel;
    }
    
}

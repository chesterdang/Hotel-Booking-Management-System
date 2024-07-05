/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.RoomTypeModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoomTypeMapping implements IRowMapping<RoomTypeModel>{

    @Override
    public RoomTypeModel mapRow(ResultSet rs) {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        
        try {
            roomTypeModel.setId(rs.getLong("roomTypeId"));
            roomTypeModel.setRoomType(rs.getString("roomType"));
            roomTypeModel.setRoomDesc(rs.getString("roomDesc"));
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeMapping.class.getName()).log(Level.SEVERE, null, ex);
            roomTypeModel = null;
        }
        
        return roomTypeModel;
    }
  
}

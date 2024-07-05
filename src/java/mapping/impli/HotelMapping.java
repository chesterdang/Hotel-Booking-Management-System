/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.IRoomDAO;
import dao.impli.RoomDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.HotelModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class HotelMapping implements IRowMapping<HotelModel>{
    private IRoomDAO roomDAO = new RoomDAO();
    @Override
    public HotelModel mapRow(ResultSet rs) {
        HotelModel hotelModel = new HotelModel();
        
        try {
            hotelModel.setId(rs.getLong("id"));
            hotelModel.setName(rs.getString("name"));
            hotelModel.setAddress(rs.getString("address"));
            hotelModel.setPostcode(rs.getString("postcode"));
            hotelModel.setNumRooms(rs.getInt("numRooms"));
            hotelModel.setPhone(rs.getString("phone"));
            hotelModel.setStarRating(rs.getDouble("starRating"));  
            hotelModel.setAvatar(rs.getString("avatar"));
        } catch (SQLException ex) {
            Logger.getLogger(HotelMapping.class.getName()).log(Level.SEVERE, null, ex);
            hotelModel = null;
        }
        
        return hotelModel;
    }
    
}

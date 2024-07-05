/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IContractDAO;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mapping.impli.ContractMapping;
import model.Contract;
import util.JDBCUtill;

/**
 *
 * @author danhv
 */
public class ContractDAO extends AbstractModel implements IContractDAO {

    @Override
    public List<Contract> findAllPending(long supplierID) {
        String sql = "SELECT COUNT(*) AS count, customerID, bookingTime, dbo.Booking.hotelId\n" +
"FROM dbo.Booking,dbo.Supplier \n" +
"WHERE dbo.Booking.status=4 AND dbo.Booking.hotelID = dbo.Supplier.hotelId AND dbo.Supplier.id = ?\n" +
"GROUP BY dbo.Booking.hotelID, dbo.Booking.customerID, dbo.Booking.bookingTime";
        List<Contract> list = query(sql, new ContractMapping(), supplierID);
        return list;
    }
    
    
    @Override
    public Map<String, Integer> countContractRoomType(long supplierID, long hotelID, long customerID, Timestamp bookingTime) {
        String sql = "SELECT  roomType.roomType, COUNT(dbo.Booking.roomNo) as count\n" +
"FROM dbo.Booking, dbo.Room, dbo.RoomType, dbo.Supplier \n" +
"WHERE dbo.Booking.hotelID = ? AND dbo.Booking.customerID = ? AND bookingTime = ?\n" +
"	AND dbo.Room.roomNo = dbo.Booking.roomNo AND dbo.Room.roomTypeId = roomType.roomTypeId\n" +
"       AND dbo.Booking.hotelID = dbo.Supplier.hotelId AND dbo.Supplier.id = ? \n" +
"GROUP BY  dbo.RoomType.roomType";
        Map<String, Integer> map = new HashMap<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtill.getConnection();

            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, String.valueOf(hotelID));
                statement.setString(2,String.valueOf(customerID));
                statement.setString(3, bookingTime.toString());
                statement.setString(4, String.valueOf(supplierID));
                rs = statement.executeQuery();
                while (rs.next()) {
                    map.put(rs.getString("roomType"), rs.getInt("count"));
                }
                return map;
            } else {
                map = null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return map;
    }

    @Override
    public Boolean updateStatus(short action, long hotelID, long customerID, Timestamp bookingTime) {
        String sql ="UPDATE dbo.Booking \n" +
"SET status = ? \n" +
"WHERE hotelID = ?  AND customerID = ? AND bookingTime = ?";
        return update(sql, action, hotelID, customerID, bookingTime);
    }

    @Override
    public List<Contract> findAllAccepted(long supplierID) {
        String sql = "SELECT COUNT(*) AS count, customerID, bookingTime, dbo.Booking.hotelId\n" +
"FROM dbo.Booking,dbo.Supplier \n" +
"WHERE dbo.Booking.status=5 AND dbo.Booking.hotelID = dbo.Supplier.hotelId AND dbo.Supplier.id = ?\n" +
"GROUP BY dbo.Booking.hotelID, dbo.Booking.customerID, dbo.Booking.bookingTime";
        List<Contract> list = query(sql, new ContractMapping(), supplierID);
        return list;
    }

    @Override
    public List<Contract> findAllDeclined(long supplierID) {
        String sql = "SELECT COUNT(*) AS count, customerID, bookingTime, dbo.Booking.hotelId\n" +
"FROM dbo.Booking,dbo.Supplier \n" +
"WHERE dbo.Booking.status=6 AND dbo.Booking.hotelID = dbo.Supplier.hotelId AND dbo.Supplier.id = ?\n" +
"GROUP BY dbo.Booking.hotelID, dbo.Booking.customerID, dbo.Booking.bookingTime";
        List<Contract> list = query(sql, new ContractMapping(), supplierID);
        return list;
    }

    @Override
    public List<Contract> findAllDone(long supplierID) {
        String sql = "SELECT COUNT(*) AS count, customerID, bookingTime, dbo.Booking.hotelId\n" +
"FROM dbo.Booking,dbo.Supplier \n" +
"WHERE dbo.Booking.status=7 AND dbo.Booking.hotelID = dbo.Supplier.hotelId AND dbo.Supplier.id = ?\n" +
"GROUP BY dbo.Booking.hotelID, dbo.Booking.customerID, dbo.Booking.bookingTime";
        List<Contract> list = query(sql, new ContractMapping(), supplierID);
        return list;
    }
 
    
}

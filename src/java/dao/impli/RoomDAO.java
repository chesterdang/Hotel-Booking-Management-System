/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IRoomDAO;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import mapping.impli.RoomMapping;
import model.RoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoomDAO extends AbstractModel implements IRoomDAO {

    @Override
    public RoomModel findBy(long roomNo) {
        String sql = "SELECT * FROM Room WHERE roomNo = ?";
        List<RoomModel> list = query(sql, new RoomMapping(), roomNo);
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<RoomModel> getRoomsListFromHotel(long hotelId) {
        String sql = "SELECT * FROM Room WHERE hotelID = ?";
        return query(sql, new RoomMapping(), hotelId);
    }

    @Override
    public List<RoomModel> findWithLimit(int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Room ");
        sql.append("where status = 1 ");
        sql.append("order by roomNo asc ");
        sql.append("offset ? rows ");
        sql.append("fetch next ? rows only");
        return query(sql.toString(), new RoomMapping(), offset, fetch);
    }

    @Override
    public List<RoomModel> findWith(int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Room ");
        sql.append("where ");
        sql.append("(status = 1 and roomNo not in (Select distinct roomNo from Booking)) ");
        sql.append("or (status = 1 and roomNo not in (Select distinct roomNo from Booking where status = 1 or status = 5)) ");
        sql.append("order by roomTypeId ");
        sql.append("offset ? rows ");
        sql.append("fetch next ? rows only");
        return query(sql.toString(), new RoomMapping(), offset, fetch);
    }

    @Override
    public Integer countTotal() {
        String sql = "SELECT COUNT(*) from ROOM";
        return countRows(sql);
    }
    
    @Override
    public Integer countTotalWith() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) from ROOM ");
        sb.append("where ((status = 1 and roomNo not in (Select distinct roomNo from Booking)) ");
        sb.append("or (status = 1 and roomNo not in (Select distinct roomNo from Booking where status = 1 or status = 5))) ");
        return countRows(sb.toString());
    }

    @Override
    public Integer countBooking(long custID, long roomNo) {
        String sql = "SELECT count(*) FROM booking WHERE customerID  = ? AND roomNo = ? and (status = 3 or status = 7)";
        return countRows(sql, custID, roomNo);
    }

    @Override
    public List<RoomModel> findWithLimit(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("select Room.*  from Room ");
        sql.append("inner join Hotel as H on H.id = Room.hotelID ");
        sql.append("where status = 1 and (price between ? and ?) and address like ? ");
        sql.append("order by price asc ");
        sql.append("offset ? rows ");
        sql.append("fetch next ? rows only");
        address = "%" + address + "%";
        return query(sql.toString(), new RoomMapping(), minPrice, maxPrice, address, offset, fetch);
    }

    @Override
    public List<RoomModel> findWith(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch) {
        StringBuilder sb = new StringBuilder();
        sb.append("select Room.*  from Room ");
        sb.append("inner join Hotel as H on H.id = Room.hotelID ");
        sb.append("where ((status = 1 and roomNo not in (Select distinct roomNo from Booking)) ");
        sb.append("or (status = 1 and roomNo not in (Select distinct roomNo from Booking where status = 1 or status = 5))) ");
        sb.append("and (price between ? and ?) and address like ? ");
        sb.append("order by price asc ");
        sb.append("offset ? rows ");
        sb.append("fetch next ? rows only");
        address = "%" + address + "%";
        return query(sb.toString(), new RoomMapping(), minPrice, maxPrice, address, offset, fetch);
    }

    @Override
    public Integer countRoom(String address, BigDecimal minPrice, BigDecimal maxPrice) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)  from Room ");
        sql.append("inner join Hotel as H on H.id = Room.hotelID ");
        sql.append("where status = 1 and (price between ? and ?) and address like ?");
        address = "%" + address + "%";
        return countRows(sql.toString(), minPrice, maxPrice, address);
    }
    
    
     @Override
    public Integer countRoomWith(String address, BigDecimal minPrice, BigDecimal maxPrice) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*)  from Room ");
        sql.append("inner join Hotel as H on H.id = Room.hotelID ");
        sql.append("where ((status = 1 and roomNo not in (Select distinct roomNo from Booking)) ");
        sql.append("or (status = 1 and roomNo not in (Select distinct roomNo from Booking where status = 1 or status = 5))) ");
        sql.append("and (price between ? and ?) and address like ? ");
        address = "%" + address + "%";
        return countRows(sql.toString(), minPrice, maxPrice, address);
    }

    public static void main(String[] args) {
        RoomDAO r = new RoomDAO();
        String address = "a";
        BigDecimal min = new BigDecimal("0");
        BigDecimal max = new BigDecimal("1000000");
        List<RoomModel> list = r.findWith(address,min,max,0,10);
        for (RoomModel roomModel : list) {
            System.out.println(roomModel.getRoomNo());
        }
        System.out.println("Count"+r.countRoomWith(address, min, max));
        System.out.println("Count："+r.countTotalWith());
    }

    @Override
    public List<RoomModel> findByHotel(long hotelId) {
        String sql = "SELECT * FROM Room WHERE hotelID = ?";
        return query(sql, new RoomMapping(), hotelId);
    }

    @Override
    public List<RoomModel> getAllRoomBySupplierID(int supplierId) {
        String sql = "SELECT r.*\n"
                + "FROM Room r\n"
                + "JOIN Hotel h ON r.hotelID = h.id\n"
                + "JOIN Supplier s ON h.id = s.hotelId\n"
                + "WHERE r.status =1 and s.id = ?";
        List<RoomModel> list = query(sql, new RoomMapping(), supplierId);
        return list;
    }

    @Override
    public Long insert(RoomModel roomModel) {
        String sql = "INSERT INTO ROOM (hotelId, roomTypeId, occupancy, priceIncludes,status, avatar,price)\n"
                + "VALUES (?, ?, ? ,? ,? , ?, ?)";

        return insert(sql, roomModel.getHotelModel().getId(), roomModel.getRoomTypeModel().getId(), roomModel.getOccupancy(),
                roomModel.getPriceIncludes(), roomModel.getStatus(), roomModel.getAvatar(), roomModel.getMoney());
    }

    @Override
    public boolean delete(long id) {
        String sql = "update Room set\n"
                + "status = 0\n"
                + "where roomNo = ?";

        return update(sql.toString(), id);
    }

    @Override
    public boolean update(long roomTypeId, int occupancy, String priceIncludes, String avatar, long roomNo, BigDecimal money) {
        String sql = "UPDATE Room Set \n"
                + "roomTypeId = ?,\n"
                + "occupancy = ?,\n"
                + "priceIncludes = ?,\n"
                + "avatar = ?,\n"
                + "price = ?\n"
                + "where roomNo = ?;";
        return update(sql, roomTypeId, occupancy, priceIncludes, avatar, money, roomNo);
    }

   

   

}

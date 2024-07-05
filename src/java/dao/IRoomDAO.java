/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import model.RoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IRoomDAO {
    RoomModel findBy(long roomNo);
    List<RoomModel> getRoomsListFromHotel(long hotelId);
    List<RoomModel> findWithLimit(int offset, int fetch);
    List<RoomModel> findWith(int offset, int fetch);
    Integer countTotal();
    Integer countTotalWith();
    Integer countBooking(long custID, long roomNo);
    List<RoomModel> findWithLimit(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch);
    List<RoomModel> findWith(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch);
    Integer countRoom(String address, BigDecimal minPrice, BigDecimal maxPrice);
    Integer countRoomWith(String address, BigDecimal minPrice, BigDecimal maxPrice);
      List<RoomModel> findByHotel(long hotelId);
    List<RoomModel> getAllRoomBySupplierID(int supplierId);

    boolean update(long roomTypeId, int occupancy, String priceIncludes, String avatar, long roomNo, BigDecimal money);

    Long insert(RoomModel roomModel);

    boolean delete(long id);
}

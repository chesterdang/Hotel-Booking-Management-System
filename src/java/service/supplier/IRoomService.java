/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import java.math.BigDecimal;
import java.util.List;
import model.RoomModel;

/**
 *
 * @author MaiGiang
 */
public interface IRoomService {

    List<RoomModel> getAllRoomBySupplierID(int supplierId);

    boolean update(long roomTypeId, int occupancy, String priceIncludes, String avatar, long roomNo, BigDecimal money);

    Long insert(RoomModel roomModel);

    boolean delete(long id);
    
    RoomModel getRoomBy(int roomNo);
}

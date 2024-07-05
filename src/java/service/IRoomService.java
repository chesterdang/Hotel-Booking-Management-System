/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import model.RoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IRoomService {

    List<RoomModel> findWithLimit(int offset, int fetch);

     List<RoomModel> findWith(int offset, int fetch);
    
    Integer countTotal();

    Integer countTotalWith();

    RoomModel findBY(long roomNo);

    Integer countBooking(long custID, long roomNo);

    List<RoomModel> findAll(List<Long> roomNos, int start, int end);

    List<RoomModel> findWithLimit(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch);

    Integer countRoom(String address, BigDecimal minPrice, BigDecimal maxPrice);

    Integer countRoomWith(String address, BigDecimal minPrice, BigDecimal maxPrice);

    List<RoomModel> findWith(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch);
}

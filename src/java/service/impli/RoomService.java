/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import dao.IRoomDAO;
import dao.impli.RoomDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.RoomModel;
import service.IRoomService;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoomService implements IRoomService {

    private IRoomDAO roomDAO = new RoomDAO();

    @Override
    public List<RoomModel> findWithLimit(int offset, int fetch) {
        return roomDAO.findWithLimit(offset, fetch);
    }

    @Override
    public Integer countTotal() {
        return roomDAO.countTotal();
    }

    @Override
    public RoomModel findBY(long roomNo) {
        return roomDAO.findBy(roomNo);
    }

    @Override
    public Integer countBooking(long custID, long roomNo) {
        return roomDAO.countBooking(custID, roomNo);
    }

    @Override
    public List<RoomModel> findAll(List<Long> roomNos, int start, int end) {
        List<RoomModel> list = new ArrayList<>();
        if (roomNos != null && start <=(roomNos.size()-1)) {
            end = (roomNos.size() - 1 > end) ? end : roomNos.size()-1;
            for (int i = start; i <= end; i++) {
                list.add(findBY(roomNos.get(i)));
            }
        }

        return list;
    }

    @Override
    public List<RoomModel> findWithLimit(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch) {
        return roomDAO.findWithLimit(address, minPrice, maxPrice, offset, fetch);
    }

    @Override
    public Integer countRoom(String address, BigDecimal minPrice, BigDecimal maxPrice) {
        return roomDAO.countRoom(address, minPrice, maxPrice);
    }

    @Override
    public Integer countRoomWith(String address, BigDecimal minPrice, BigDecimal maxPrice) {
        return roomDAO.countRoomWith(address, minPrice, maxPrice);
    }

    @Override
    public List<RoomModel> findWith(String address, BigDecimal minPrice, BigDecimal maxPrice, int offset, int fetch) {
        return roomDAO.findWith(address, minPrice, maxPrice, offset, fetch);
    }

    @Override
    public List<RoomModel> findWith(int offset, int fetch) {
        return roomDAO.findWith(offset, fetch);
    }

    @Override
    public Integer countTotalWith() {
       return roomDAO.countTotalWith();
    }

}

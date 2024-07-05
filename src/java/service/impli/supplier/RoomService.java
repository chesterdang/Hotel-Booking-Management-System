/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import java.util.List;
import model.RoomModel;
import service.supplier.IRoomService;
import dao.IRoomDAO;
import dao.impli.RoomDAO;
import java.math.BigDecimal;
import model.RoomTypeModel;

/**
 *
 * @author MaiGiang
 */
public class RoomService implements IRoomService {

    private IRoomDAO roomDAO = new RoomDAO();

    @Override
    public List<RoomModel> getAllRoomBySupplierID(int supplierId) {
        return roomDAO.getAllRoomBySupplierID(supplierId);
    }

    

    @Override
    public Long insert(RoomModel roomModel) {
        return roomDAO.insert(roomModel);
    }

    @Override
    public boolean delete(long id) {
        return roomDAO.delete(id);
    }

    @Override
    public RoomModel getRoomBy(int roomNo) {
        return roomDAO.findBy(roomNo);
    }



    @Override
    public boolean update(long roomTypeId, int occupancy, String priceIncludes, String avatar, long roomNo, BigDecimal money) {
        return roomDAO.update(roomTypeId, occupancy, priceIncludes, avatar, roomNo, money);
    }
    
    
    
        public static void main(String[] args) {
            
          IRoomService roomService = new RoomService();
//          roomService.update(2, 1, "BR", "DOXAML", 1);
            roomService.delete(1);
//        RoomService roomService = new RoomService();
//        BigDecimal bd = new BigDecimal(3333);
//        RoomTypeModel roomTypeModel = new RoomTypeModel(1, "one", bd, "333sdfsdfs3");
//        RoomModel roomModel = new RoomModel(0, 3, roomTypeModel, 4, "Breakfasdfsdfsst esssss", (short) 1, "/path/to/ava2wertar.jpg");
//        roomService.insert(roomModel);

//        RoomModel roomModel = new RoomModel();
//        roomModel = roomService.getRoomBy(1);
//            System.out.println(roomModel);
//        RoomTypeModel roomTypeModel = new RoomTypeModel();
//        roomTypeModel.setMoney(BigDecimal.valueOf(99000000));
//        roomTypeModel.setRoomDesc("sd");
//        roomTypeModel.setRoomType("OĐOUV");
//        
//        
//        RoomModel roomModel = new RoomModel();
//        roomModel.setRoomNo(1);
//        roomModel.setHotelId(2);
//        roomModel.setPriceIncludes("an sang");
//        roomModel.setRoomTypeModel(roomTypeModel);
//        roomModel.setAvatar("assssssssss");
//        roomModel.setStatus((short) 1);
//        roomModel.setOccupancy(1);
//        
//        RoomService roomService = new RoomService();
//        roomService.update(roomModel);
//        
    }
}

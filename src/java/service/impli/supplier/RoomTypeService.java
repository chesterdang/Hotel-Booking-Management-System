/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.IRoomTypeDAO;
import dao.impli.RoomTypeDAO;
import model.RoomTypeModel;
import service.supplier.IRoomTypeService;

/**
 *
 * @author MaiGiang
 */
public class RoomTypeService implements IRoomTypeService{
    private IRoomTypeDAO roomTypeDAO = new RoomTypeDAO();

    @Override
    public RoomTypeModel getRoomTypeBy(long roomTypeId) {
        return roomTypeDAO.findBy(roomTypeId);
    }
    
    
    
}

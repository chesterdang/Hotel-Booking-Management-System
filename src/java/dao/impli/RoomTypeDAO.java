/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IRoomTypeDAO;
import java.util.List;
import mapping.impli.RoleMapping;
import mapping.impli.RoomTypeMapping;
import model.RoomTypeModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoomTypeDAO extends AbstractModel implements IRoomTypeDAO{

    @Override
    public RoomTypeModel findBy(long id) {
        String sql = "SELECT * FROM RoomType WHERE roomTypeId = ?";
        List<RoomTypeModel> list =  query(sql, new RoomTypeMapping(), id);
        return  (list.isEmpty())?null:list.get(0);
    }
    
}

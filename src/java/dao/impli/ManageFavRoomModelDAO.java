/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IManageFavRoomDAO;
import java.util.List;
import mapping.impli.ManageFavRoomMapping;
import model.ManageFavRoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ManageFavRoomModelDAO extends AbstractModel implements IManageFavRoomDAO {

    @Override
    public ManageFavRoomModel findBy(long id) {
         String sql = "SELECT * FROM manageFavRoom WHERE id = ?";
         List<ManageFavRoomModel> list =  query(sql, new ManageFavRoomMapping(), id);
        return  (list.isEmpty())?null:list.get(0);
    }
}

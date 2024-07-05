/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IRoleDAO;
import java.util.List;
import mapping.impli.RoleMapping;
import model.RoleModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoleDAO extends AbstractModel implements IRoleDAO{

    @Override
    public RoleModel findBy(String code) {
        String sql = "SELECT * FROM Role WHERE code = ?";
        List<RoleModel> list =  query(sql, new RoleMapping(), code);
        return  (list.isEmpty())?null:list.get(0);
    }
    
}

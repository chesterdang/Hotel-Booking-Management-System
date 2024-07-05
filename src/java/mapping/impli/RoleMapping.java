/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.RoleModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class RoleMapping implements IRowMapping<RoleModel>{

    @Override
    public RoleModel mapRow(ResultSet rs) {
        RoleModel roleModel = new RoleModel();
        
        try {
            roleModel.setCode(rs.getString("code"));
            roleModel.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(RoleMapping.class.getName()).log(Level.SEVERE, null, ex);
            roleModel = null;
        }
        
        return roleModel;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.IRoleDAO;
import dao.impli.RoleDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.AdminModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class AdminMapping implements IRowMapping<AdminModel>{
    private final IRoleDAO roleDAO = new RoleDAO();
    
    @Override
    public AdminModel mapRow(ResultSet rs) {
        AdminModel adminModel = new AdminModel();
        
         try {
            adminModel.setId(rs.getLong("id"));
            adminModel.setFullname(rs.getString("fullname"));
            adminModel.setPassword(rs.getString("password"));
            adminModel.setDob(rs.getDate("dob"));
            adminModel.setEmail(rs.getString("email"));
            adminModel.setPhone(rs.getString("phone"));
            adminModel.setStatus(rs.getShort("status"));
            adminModel.setAddress(rs.getString("address"));
            adminModel.setRoleModel(roleDAO.findBy(rs.getString("role")));
            adminModel.setModifiedBy(rs.getLong("modifiedBy"));
            adminModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            adminModel.setCreatedDate(rs.getTimestamp("createdDate"));
            adminModel.setAvatar(rs.getString("avatar"));
            adminModel.setCapcha(rs.getString("capcha"));
            adminModel.setValidCapchaTime(rs.getTimestamp("validCapchaTime"));

        } catch (SQLException ex) {
            Logger.getLogger(AdminMapping.class.getName()).log(Level.SEVERE, null, ex);
            adminModel = null;
        }

        return adminModel;
        
    }
    
}

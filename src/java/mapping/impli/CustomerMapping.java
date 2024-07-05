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
import model.CustomerModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class CustomerMapping implements IRowMapping<CustomerModel> {

    private final IRoleDAO roleDAO = new RoleDAO();

    @Override
    public CustomerModel mapRow(ResultSet rs) {
        CustomerModel customerModel = new CustomerModel();

        try {
            customerModel.setId(rs.getLong("id"));
            customerModel.setFullname(rs.getString("fullname"));
            customerModel.setPassword(rs.getString("password"));
            customerModel.setDob(rs.getDate("dob"));
            customerModel.setEmail(rs.getString("email"));
            customerModel.setPhone(rs.getString("phone"));
            customerModel.setStatus(rs.getShort("status"));
            customerModel.setAddress(rs.getString("address"));
            customerModel.setRoleModel(roleDAO.findBy(rs.getString("role")));
            customerModel.setModifiedBy(rs.getLong("modifiedBy"));
            customerModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            customerModel.setCreatedDate(rs.getTimestamp("createdDate"));
            customerModel.setAvatar(rs.getString("avatar"));
              customerModel.setCapcha(rs.getString("capcha"));
            customerModel.setValidCapchaTime(rs.getTimestamp("validCapchaTime"));
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapping.class.getName()).log(Level.SEVERE, null, ex);
            customerModel = null;
        }

        return customerModel;
    }

}

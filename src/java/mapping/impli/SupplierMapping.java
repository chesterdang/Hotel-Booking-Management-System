/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import dao.IHotelDAO;
import dao.IRoleDAO;
import dao.impli.HotelDAO;
import dao.impli.RoleDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.SupplierModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class SupplierMapping implements IRowMapping<SupplierModel> {

    private final IRoleDAO roleDAO = new RoleDAO();
    private final IHotelDAO hotelDAO = new HotelDAO();
    
    @Override
    public SupplierModel mapRow(ResultSet rs) {
        SupplierModel supplierModel = new SupplierModel();

        try {
            supplierModel.setId(rs.getLong("id"));
            supplierModel.setFullname(rs.getString("fullname"));
            supplierModel.setPassword(rs.getString("password"));
            supplierModel.setDob(rs.getDate("dob"));
            supplierModel.setEmail(rs.getString("email"));
            supplierModel.setPhone(rs.getString("phone"));
            supplierModel.setStatus(rs.getShort("status"));
            supplierModel.setAddress(rs.getString("address"));
            supplierModel.setHotelModel(hotelDAO.findBy(rs.getLong("hotelId")));
            supplierModel.setRoleModel(roleDAO.findBy(rs.getString("role")));
            supplierModel.setModifiedBy(rs.getLong("modifiedBy"));
            supplierModel.setModifiedDate(rs.getTimestamp("modifiedDate"));
            supplierModel.setCreatedDate(rs.getTimestamp("createdDate"));
            supplierModel.setAvatar(rs.getString("avatar"));
            supplierModel.setCapcha(rs.getString("capcha"));
            supplierModel.setValidCapchaTime(rs.getTimestamp("validCapchaTime"));
        } catch (SQLException ex) {
            Logger.getLogger(SupplierMapping.class.getName()).log(Level.SEVERE, null, ex);
            supplierModel=  null;
        }

        return supplierModel;
    }

}

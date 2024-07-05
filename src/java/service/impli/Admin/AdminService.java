/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.Admin;

import dao.IAdminDAO;
import dao.impli.AdminDAO;
import java.sql.Date;
import java.util.List;
import model.AdminModel;
import service.Admin.IAdminService;

/**
 *
 * @author quandba
 */
public class AdminService implements IAdminService{
    private IAdminDAO adminDAO = new AdminDAO();

    @Override
    public boolean changePassword(AdminModel adminModel) {
        return adminDAO.changePassword(adminModel);
    }

    @Override
    public AdminModel selecByUserName(String email) {
        return adminDAO.selecByUserName(email);
    }

    @Override
    public boolean updateInfoAdmin(String fullname, Date dob, String phone, String address, long id) {
        return adminDAO.updateInfoAdmin(fullname, dob, phone, address, id);
    }

    @Override
    public AdminModel findBy(long id) {
        return adminDAO.findBy(id);
    }

    

    

   
   
    
}

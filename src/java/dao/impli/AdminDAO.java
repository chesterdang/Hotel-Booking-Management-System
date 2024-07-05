/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IAdminDAO;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import mapping.impli.AdminMapping;
import mapping.impli.CustomerMapping;
import model.AdminModel;
import model.CustomerModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class AdminDAO extends AbstractModel  implements IAdminDAO {

    @Override
    public AdminModel findBy(long id) {
        String sql = "SELECT * FROM Admin WHERE id = ?";
        List<AdminModel> list = query(sql, new AdminMapping(), id);
        return (list.isEmpty()) ? null : list.get(0);
    }
    
       @Override
    public AdminModel findAccount(String email, String pass) {
         String sql = "SELECT * FROM Admin WHERE email = ? AND password = ?";
        List<AdminModel> list = query(sql, new AdminMapping(), email,pass);
        return (list).isEmpty()?null:list.get(0);
    }

    @Override
    public Boolean checkExist(String email) {
        String sql= "SELECT * FROM Admin WHERE email = ?";
        List<AdminModel> list = query(sql, new AdminMapping(), email);
        return !list.isEmpty();
    }

    @Override
    public AdminModel findBy(String email) {
        String sql = "SELECT * FROM Admin WHERE email = ?";
        List<AdminModel> list = query(sql, new AdminMapping(), email);
        return (list).isEmpty()?null:list.get(0);
    }

    @Override
    public Boolean addCaptcha(String code, Timestamp validCapchaTime, String email) {
         String sql="UPDATE Admin SET capcha = ?, validCapchaTime = ? WHERE email = ?;";
         return update(sql, code,validCapchaTime, email);     
    }

    @Override
    public Boolean editPassword(String password, String email) {
        String sql="UPDATE Admin set password = ? where email =?;";
        return update(sql, password,email);
    }
    
    @Override
    public Boolean check(String email) {
        String sql = "SELECT * FROM Customer WHERE email = ?";
        List<CustomerModel> list = query(sql, new CustomerMapping(), email);
        return !list.isEmpty();
    }
    
    @Override
    public boolean changePassword(AdminModel adminModel) {
        String sql = "UPDATE admin SET  password = ? WHERE id = ? ";
        return update(sql, adminModel.getPassword(), adminModel.getId());
    }

   

    @Override
    public AdminModel selecByUserName(String email) {
        String sql = "SELECT * FROM Admin  WHERE email = ?";
        List<AdminModel> list  =  query(sql, new AdminMapping(), email);
        return (list.isEmpty()) ? null : list.get(0);
    }
    @Override
    public boolean updateInfoAdmin(String fullname , Date dob , String phone ,String address  , long id) {
        String sql = "UPDATE Admin  SET  fullname=? , dob=?  , phone=? , address=?  WHERE id= ?";
             
        return update(sql,fullname ,  dob ,  phone , address , id);
    }

}

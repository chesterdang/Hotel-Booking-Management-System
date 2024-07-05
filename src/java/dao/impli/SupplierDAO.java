/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.ISupplierDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mapping.impli.CustomerMapping;
import mapping.impli.SupplierMapping;
import model.CustomerModel;
import model.SupplierModel;
import util.JDBCUtill;

/**
 *
 * @author Nguyen Quang Hau
 */
public class SupplierDAO extends AbstractModel implements ISupplierDAO {

    @Override
    public SupplierModel findBy(long id) {
        String sql = "SELECT * FROM Supplier WHERE id = ?";
        List<SupplierModel> list = query(sql, new SupplierMapping(), id);
        return (list.isEmpty()) ? null : list.get(0);
    }
    
      @Override
    public SupplierModel findAccount(String email, String pass) {
         String sql = "SELECT * FROM Supplier WHERE email = ? AND password = ?";
        List<SupplierModel> list = query(sql, new SupplierMapping(), email,pass);
        return (list).isEmpty()?null:list.get(0);
    }

    @Override
    public Boolean checkExist(String email) {
        String sql= "SELECT * FROM Supplier WHERE email = ?";
        List<SupplierModel> list = query(sql, new SupplierMapping(), email);
        return !list.isEmpty();
    }

    @Override
    public SupplierModel findBy(String email) {
         String sql = "SELECT * FROM Supplier WHERE email = ?";
        List<SupplierModel> list = query(sql, new SupplierMapping(), email);
        return (list).isEmpty()?null:list.get(0);
    }
    
      @Override
    public Boolean addCaptcha(String code, Timestamp validCapchaTime, String email) {
         String sql="UPDATE Supplier SET capcha = ?, validCapchaTime = ? WHERE email = ?;";
         return update(sql,code, validCapchaTime, email);     
    }
    
      @Override
    public Boolean editPassword(String password, String email) {
        String sql="UPDATE Supplier set password = ? where email =?;";
        return update(sql, password,email);
    }
    
    
     @Override
    public Boolean check(String email) {
        String sql = "SELECT * FROM Supplier WHERE email = ?";
        List<SupplierModel> list = query(sql, new SupplierMapping(), email);
        if (list==null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Long insert(String fullname, String pass,Date dob, String role,String email, String phone, String address, Long hotelId) {
       String sqlString="INSERT INTO Supplier (fullname,password,dob,role, email,phone, status, address, createdDate,hotelId)"
               +"VALUES (?,? ,?,?,?,?,1,?,GETDATE(),?)";
     return insert(sqlString,fullname,pass,dob,role,email,phone,address,hotelId);
    }
    
    
    @Override
    public int getTotalBooking(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateSupplier(String fullname, String dob, String email, String phone, String address, String filename, long id) {
        String sql = "UPDATE Supplier SET\n"
                + "fullName = ?,\n"
                + "dob = ?,\n"
                + "email = ?,\n"
                + "phone = ?,\n"
                + "address = ?,\n"
                + "avatar = ?\n"
                + "where Supplier.id = ?";
        return update(sql, fullname, dob, email, phone, address, filename, id);
    }

    @Override
    public boolean updatePassword(String password, long id) {
        String sql = "UPDATE Supplier SET password = ? WHERE id = ?";
        return update(sql, password, id);
    }
    
    
    @Override
    public List<SupplierModel> finaAll() {
        String sql = "SELECT * FROM Supplier";
        return query(sql, new SupplierMapping());
    }

    @Override
    public Long insert(SupplierModel sup) {
        String sql = "INSERT INTO [BookingHotel].[dbo].[Supplier] ([id]\n"
                + "      ,[fullName]\n"
                + "      ,[password]\n"
                + "      ,[dob]\n"
                + "      ,[role]\n"
                + "      ,[email]\n"
                + "      ,[phone]\n"
                + "      ,[status]\n"
                + "      ,[address]\n"
                + "      ,[hotelId]\n"
                + "      ,[modifiedBy]\n"
                + "      ,[modifiedDate]\n"
                + "      ,[createdDate]\n"
                + "      ,[avatar])\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return insert(sql, sup.getId(), sup.getFullname(), sup.getPassword(), sup.getDob(), sup.getRoleModel().getCode(),
                sup.getEmail(), sup.getPhone(), sup.getStatus(), sup.getAddress(), sup.getHotelModel().getId(), sup.getModifiedBy(),
                sup.getModifiedDate(), sup.getCreatedDate(), sup.getAvatar());
    }

    @Override
    public List<SupplierModel> sortList(String str, String ASCcOrDESC) {
        String sql = "SELECT * FROM Supplier ORDER BY " + str + " " + ASCcOrDESC + ";";//tangdan
        return query(sql, new SupplierMapping());
    }

    @Override
    public List<SupplierModel> searchBy(String sth, String column) {
        String sql = "select * from Supplier where " + column + " like ?;";
        return query(sql, new SupplierMapping(), "%" + sth + "%");
    }

    @Override
    public HashMap<Integer, Integer> numberSupplierRegisteredbymonth() {
        String sql = "SELECT \n"
                + "    MONTH(createdDate) AS registration_month,\n"
                + "    COUNT(id) AS registration_count\n"
                + "FROM \n"
                + "    Supplier\n"
                + "GROUP BY \n"
                + "    MONTH(createdDate)\n"
                + "ORDER BY \n"
                + "    MONTH(createdDate); ";
        return numberHashMap(sql);
    }

    @Override
    public boolean delete(Long id) {
        String sql = "UPDATE Supplier set status = 0 WHERE id =?";
        return update(sql, id);
    }

   @Override
    public List<SupplierModel> pagingListSupplier(String column, String ASCorDESC, int index, int quantityPerPage, String where) {
        String sql = "select * from Supplier "+where+ "\n"
                + "order by " + column + " " + ASCorDESC +" \n"
                + " offset ? Rows fetch next " + quantityPerPage + " rows only;";
        return query(sql, new SupplierMapping(), (index - 1) * quantityPerPage);

    }

    @Override
    public int getTotalSupplier(String where) {
        String sql = "SELECT COUNT(*)  FROM Supplier "+where;
        return countRows(sql);
    }

    @Override
    public boolean unlock(Long id) {
        String sql = "Update Supplier set status = 1 where id =?";
        return update(sql, id);
    }
    
    public int getTotalNumberRegister(int month) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT  COUNT(*)  from [Supplier] WHERE  MONTH(createdDate) = ?";
        try {
            connection = JDBCUtill.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Integer> getDistinctRegistrationMonths() {
        List<Integer> distinctMonths = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "SELECT DISTINCT MONTH(createdDate) AS registrationMonth "
                + "FROM [BookingHotel].[dbo].[Supplier]";

        try {
            connection = JDBCUtill.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int month = rs.getInt("registrationMonth");
                distinctMonths.add(month);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return distinctMonths;

    }


    

}

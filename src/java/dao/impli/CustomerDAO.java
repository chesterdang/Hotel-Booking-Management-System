/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.ICustomerDAO;
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
import model.CustomerModel;
import util.JDBCUtill;

/**
 *
 * @author Nguyen Quang Hau
 */
public class CustomerDAO extends AbstractModel implements ICustomerDAO{

    @Override
    public CustomerModel findBy(long id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
         List<CustomerModel> list =  query(sql, new CustomerMapping(), id);
        return  (list.isEmpty())?null:list.get(0);
    }
    
   @Override
    public boolean updateProfile(String fullname, String dob, String email, String phone, String address, String filename, long id) {
        String sql = "UPDATE Customer SET\n"
                + "fullName = ?,\n"
                + "dob = ?,\n"
                + "email = ?,\n"
                + "phone = ?,\n"
                + "address = ?,\n"
                + "avatar = ?\n"
                + "where id = ?";
        return update(sql, fullname, dob, email, phone, address, filename, id);
    }
    
    @Override
    public boolean updatePassword(String password, long id) {
        String sql = "UPDATE Customer SET password = ? WHERE id = ?";
        return update(sql, password, id);
    }
    
     @Override
    public CustomerModel findAccount(String email,String pass) {
         String sql = "SELECT * FROM Customer WHERE email = ? AND password = ?";
        List<CustomerModel> list = query(sql, new CustomerMapping(), email,pass);
        return (list).isEmpty()?null:list.get(0);
    }

    @Override
    public Boolean checkExist(String email) {
        String sql= "SELECT * FROM Customer WHERE email = ?";
        List<CustomerModel> list = query(sql, new CustomerMapping(), email);
        return !list.isEmpty();
    }

    @Override
    public CustomerModel findBy(String email) {
        String sql = "SELECT * FROM Customer WHERE email = ?";
        List<CustomerModel> list = query(sql, new CustomerMapping(), email);
        return (list).isEmpty()?null:list.get(0);
    }
    
      @Override
    public Boolean addCaptcha(String code, Timestamp validCapchaTime, String email) {
         String sql="UPDATE Customer SET capcha = ?, validCapchaTime = ? WHERE email = ?;";
         return update(sql, code,validCapchaTime, email);     
    }
    
      @Override
    public Boolean editPassword(String password, String email) {
        String sql="UPDATE Customer set password = ? where email =?;";
        return update(sql, password,email);
    }
    
    @Override
    public Boolean check(String email) {
        String sql = "SELECT * FROM Customer WHERE email = ?";
        List<CustomerModel> list = query(sql, new CustomerMapping(), email);
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Long insert(String fullname, String pass, Date dob, String role, String email, String phone, String address) {
        String sqlString = "INSERT INTO Customer (fullname,password,dob,role, email,phone, status,address, createdDate)"
                + "VALUES (?,? ,?, ?,?,?,1,?,GETDATE())";
        return insert(sqlString, fullname, pass, dob, role, email, phone, address);
    }
    
      @Override
    public List<CustomerModel> getAllCustomerBySupplierId(int supplierId) {
        String sql = "SELECT Customer.*\n"
                + "FROM dbo.Supplier\n"
                + "INNER JOIN dbo.Booking ON dbo.Supplier.hotelId = dbo.Booking.hotelID\n"
                + "INNER JOIN dbo.Customer ON dbo.Booking.customerID = dbo.Customer.id\n"
                + "WHERE dbo.Supplier.id = ?;";
        List<CustomerModel> list = query(sql, new CustomerMapping(), supplierId);
        return list;

    }
    
    @Override
    public int countTotalCustomer(int supplierId) {
        String sql = "SELECT  COUNT(distinct Customer.id)\n"
                + "  \n"
                + "FROM \n"
                + "    dbo.Supplier\n"
                + "JOIN \n"
                + "    dbo.Booking ON dbo.Supplier.hotelId = dbo.Booking.hotelID\n"
                + "JOIN \n"
                + "    dbo.Customer ON dbo.Booking.customerID = dbo.Customer.id\n"
                + "WHERE \n"
                + "    dbo.Supplier.id = ?\n"
                + "		";
//       
        return countRows(sql, supplierId);
    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<CustomerModel> list = customerDAO.getAllCustomerBySupplierId(3);

        for (CustomerModel customerModel : list) {
            System.out.println(customerModel);

        }

    }

    @Override
    public List<CustomerModel> pagingAccount(int supplierId, int index) {
        String sql = "SELECT \n"
                + "    dbo.Customer.id, \n"
                + "    dbo.Customer.fullname, \n"
                + "    dbo.Customer.password, \n"
                + "    dbo.Customer.dob, \n"
                + "    dbo.Customer.role, \n"
                + "    dbo.Customer.email, \n"
                + "    dbo.Customer.phone, \n"
                + "    dbo.Customer.status, \n"
                + "    dbo.Customer.address, \n"
                + "    dbo.Customer.modifiedBy,\n"
                + "    dbo.Customer.modifiedDate,\n"
                + "    dbo.Customer.createdDate,\n"
                + "    CONVERT(varchar(max), dbo.Customer.avatar) as avatar,\n"
                + "    dbo.Customer.capcha,\n"
                + "    dbo.Customer.validCapchaTime\n"
                + "FROM \n"
                + "    dbo.Supplier\n"
                + "JOIN \n"
                + "    dbo.Booking ON dbo.Supplier.hotelId = dbo.Booking.hotelID\n"
                + "JOIN \n"
                + "    dbo.Customer ON dbo.Booking.customerID = dbo.Customer.id\n"
                + "WHERE \n"
                + "    dbo.Supplier.id = ?\n"
                + "GROUP BY \n"
                + "    dbo.Customer.id, \n"
                + "    dbo.Customer.fullname, \n"
                + "    dbo.Customer.password, \n"
                + "    dbo.Customer.dob, \n"
                + "    dbo.Customer.role, \n"
                + "    dbo.Customer.email, \n"
                + "    dbo.Customer.phone, \n"
                + "    dbo.Customer.status, \n"
                + "    dbo.Customer.address, \n"
                + "    dbo.Customer.modifiedBy,\n"
                + "    dbo.Customer.modifiedDate,\n"
                + "    dbo.Customer.createdDate,\n"
                + "    CONVERT(varchar(max), dbo.Customer.avatar),  -- Convert avatar to varchar(max)\n"
                + "    dbo.Customer.capcha,\n"
                + "    dbo.Customer.validCapchaTime\n"
                + "ORDER BY \n"
                + "    dbo.Customer.id\n"
                + "OFFSET \n"
                + "    ? ROWS FETCH NEXT 3 ROWS ONLY;";
        List<CustomerModel> list = query(sql, new CustomerMapping(), supplierId, (index - 1) * 3);
        return list;
    }

     @Override
    public List<CustomerModel> finaAll() {
        String sql = "SELECT * FROM Customer";
        return query(sql, new CustomerMapping());
    }

//    public static void main(String[] args) {
//        ICustomerService iCustomerService = new CustomerService();
//        HashMap<Integer, Integer> map = iCustomerService.numberSupplierRegisteredbymonth();
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + value);
//        }
//    }

    @Override
    public boolean delete(Long id) {
        String sql ="Update Customer set status = 0 where id =?";
       return update(sql, id);
    }

    @Override
    public Long insert(CustomerModel sup) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CustomerModel> sortList(String str, String ASCcOrDESC) {
        String sql = "SELECT * FROM Customer ORDER BY " + str + " " + ASCcOrDESC + ";";//tangdan
        return query(sql, new CustomerMapping());
    }

    @Override
    public List<CustomerModel> searchBy(String sth, String column) {
        String sql = "select * from Customer where " + column + " like ?;";
        return query(sql, new CustomerMapping(), "%" + sth + "%");
    }

    @Override
    public HashMap<Integer , Integer> numberSupplierRegisteredbymonth() {
        String sql = "SELECT "
                + " MONTH(createdDate) AS registration_month,\n"
                + "    COUNT(id) AS registration_count\n"
                + "FROM \n"
                + "    Customer\n"
                + "GROUP BY \n"
                + "    MONTH(createdDate)\n"
                + "ORDER BY \n"
                + "MONTH(createdDate); ";
       return numberHashMap(sql);
    }

   @Override
    public List<CustomerModel> pagingListCustomer(String column, String ASCorDESC, int index, int quantityPerPage, String where) {
        String sql = "select * from Customer "+where+ "\n"
                + "order by " + column + " " + ASCorDESC +" \n"
                + " offset ? Rows fetch next " + quantityPerPage + " rows only;";
        return query(sql, new CustomerMapping(), (index - 1) * quantityPerPage);

    }

    @Override
    public int getTotalCustomer(String where) {
        String sql = "SELECT COUNT(*)  FROM CUSTOMER "+where;
        return countRows(sql);
    }


    @Override
    public boolean unlock(Long id) {
        String sql = "Update Customer set status = 1 where id =?";
        return update(sql, id);
    }
    
    
    public int getTotalNumberRegister(int month) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT  COUNT(*)  from [Customer] WHERE  MONTH(createdDate) = ?";
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
                + "FROM [BookingHotel].[dbo].[Customer]";

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

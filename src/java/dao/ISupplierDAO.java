/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import model.SupplierModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface ISupplierDAO {
    SupplierModel findBy(long id);
    
    Boolean editPassword(String password,String email);
     Boolean addCaptcha(String code, Timestamp validCapchaTime, String email);
    SupplierModel findAccount(String email,String pass);
    Boolean checkExist(String email);
    SupplierModel findBy(String email);
    
    Boolean check(String username);
    
     Long insert(String fullname, String pass,Date dob, String role,String email, String phone, String address,Long hotelId);
    
      int getTotalBooking(long id);
    boolean updateSupplier(String fullname, String dob, String email,String phone,String address,String filename, long id);
    boolean updatePassword(String password, long id);
    
    List<SupplierModel> finaAll();
    boolean delete(Long id);
    
    Long insert(SupplierModel sup);
    
    List<SupplierModel> sortList(String str,String ASCcOrDESC);
    
    
    List<SupplierModel> searchBy(String sth,String column);
    
    HashMap<Integer, Integer> numberSupplierRegisteredbymonth();

    boolean unlock(Long id);

    List<SupplierModel> pagingListSupplier(String column,String ASCorDESC,int index, int quantityPerPage , String where);
    int getTotalSupplier(String where);
    
    int  getTotalNumberRegister(int year);
    
     List<Integer> getDistinctRegistrationMonths();
}

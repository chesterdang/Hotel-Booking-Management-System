/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import model.CustomerModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface ICustomerDAO {

    CustomerModel findBy(long id);

    boolean updateProfile(String fullname, String dob, String email, String phone, String address, String filename, long id);

    boolean updatePassword(String password, long id);

    Boolean editPassword(String password, String email);

    Boolean addCaptcha(String code, Timestamp validCapchaTime, String email);

    CustomerModel findAccount(String email, String pass);

    Boolean checkExist(String email);

    CustomerModel findBy(String email);

    //Hung
    Boolean check(String email);

    Long insert(String fullname, String pass, Date dob, String role, String email, String phone, String address);

    List<CustomerModel> getAllCustomerBySupplierId(int supplierId);

    int countTotalCustomer(int supplierId);

    List<CustomerModel> pagingAccount(int supplierId, int index);

    List<CustomerModel> finaAll();

    boolean delete(Long id);

    Long insert(CustomerModel sup);

    List<CustomerModel> sortList(String str, String ASCcOrDESC);

    List<CustomerModel> searchBy(String sth, String column);

    HashMap<Integer, Integer> numberSupplierRegisteredbymonth();

    List<CustomerModel> pagingListCustomer(String column, String ASCorDESC, int index, int quantityPerPage, String where);

    int getTotalCustomer(String where);

    boolean unlock(Long id);

    int getTotalNumberRegister(int year);

    List<Integer> getDistinctRegistrationMonths();
}

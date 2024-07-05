/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Admin;

import java.util.HashMap;
import java.util.List;
import model.CustomerModel;

/**
 *
 * @author quandba
 */
public interface ICustomerService {
    List<CustomerModel> finaAll  ();
    
    CustomerModel  findBy(long id);
    
    List<CustomerModel> sortList(String tr,String ASCorDESC);
    
    List<CustomerModel> searchBy(String str, String column);
    
    HashMap<Integer , Integer> numberSupplierRegisteredbymonth ();
    
    int getTotalCustomer(String where);

    List<CustomerModel> pagingListCustomer(String column, String ASCorDESC, int index, int quantityPerPage,String where);



    boolean delete(long id);
    boolean unlock(long id);
    
    int  getTotalNumberRegister(int month);
    
    
   List<Integer> getDistinctRegistrationMonths();
    
  
}

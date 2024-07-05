/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Admin;

import java.util.HashMap;
import java.util.List;
import model.Person;
import model.SupplierModel;

/**
 *
 * @author quandba
 */
public interface ISupplierService {

    List<SupplierModel> finaAll();

    SupplierModel findBy(long id);

    List<SupplierModel> sortList(String str, String ASCorDESC);

    List<SupplierModel> searchBy(String str, String column);

    HashMap<Integer, Integer> numberSupplierRegisteredbymonth();

    boolean delete(long id);

    int getTotalSupplier(String where);

    List<SupplierModel> pagingListSupplier(String column, String ASCorDESC, int index, int quantityPerPage,String where);

    boolean unlock(long id);
    
    
     int  getTotalNumberRegister(int month);
    
    
   List<Integer> getDistinctRegistrationMonths();
    
    
}

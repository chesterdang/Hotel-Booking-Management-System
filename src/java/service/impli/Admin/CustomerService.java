/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.Admin;

import dao.ICustomerDAO;
import dao.impli.CustomerDAO;
import java.util.HashMap;
import java.util.List;
import model.CustomerModel;
import service.Admin.ICustomerService;

/**
 *
 * @author quandba
 */
public class CustomerService implements ICustomerService{
  
    private ICustomerDAO customerDAO = new CustomerDAO() ;
    @Override
    public List<CustomerModel> finaAll() {
       return  customerDAO.finaAll();
    }

    @Override
    public CustomerModel findBy(long id) {
       return customerDAO.findBy(id);
    }

    @Override
    public List<CustomerModel> sortList(String tr, String ASCorDESC) {
        return customerDAO.sortList(tr, ASCorDESC);
    }

    @Override
    public List<CustomerModel> searchBy(String str, String column) {
      return customerDAO.searchBy(str, column);
    }

    
    
    @Override
    public int getTotalCustomer(String where) {
        return customerDAO.getTotalCustomer(where);
    }

       @Override
    public List<CustomerModel> pagingListCustomer(String column,String ASCorDESC,int index, int quantityPerPage,String where) {
        return customerDAO.pagingListCustomer(column, ASCorDESC, index, quantityPerPage, where);

    }

    @Override
    public boolean delete(long id) {
        return customerDAO.delete(id);
    }

      @Override
    public boolean unlock(long id) {
        return customerDAO.unlock(id);
    }

    @Override
    public HashMap<Integer, Integer> numberSupplierRegisteredbymonth() {
        return (HashMap<Integer, Integer>) customerDAO.numberSupplierRegisteredbymonth();
    }

    @Override
    public int getTotalNumberRegister(int month) {
        return  customerDAO.getTotalNumberRegister(month);
    }

    @Override
    public List<Integer> getDistinctRegistrationMonths() {
        return  customerDAO.getDistinctRegistrationMonths();
    }

    

    

    

    
    
    
    
    
    
    
}

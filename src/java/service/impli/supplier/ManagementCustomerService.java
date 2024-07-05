/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.ICustomerDAO;
import dao.impli.CustomerDAO;
import java.util.List;
import model.CustomerModel;
import service.supplier.IManagementCustomerService;

/**
 *
 * @author MaiGiang
 */
public class ManagementCustomerService implements IManagementCustomerService{
    private ICustomerDAO customerDAO = new CustomerDAO();
    
    @Override
    public List<CustomerModel> getAllCutomerBySupplierId(int SupplierId) {
        return customerDAO.getAllCustomerBySupplierId(SupplierId);
    }
    
    
//    public static void main(String[] args) {
//        ManagementCustomerService disCustomerService = new ManagementCustomerService();
//        List<CustomerModel> list = disCustomerService.getAllCutomerBySupplierId(3);
//        
//        for (CustomerModel customerModel : list) {
//            System.out.println(list);
//        }
//    }

    @Override
    public int countTotalCustomer(int supplierId) {
        return customerDAO.countTotalCustomer(supplierId);
    }

    @Override
    public List<CustomerModel> pagingCustomerList(int supplierId, int index) {
        return customerDAO.pagingAccount(supplierId,index);
    }
    
    public static void main(String[] args) {
        IManagementCustomerService managementCustomerService = new ManagementCustomerService();
        List<CustomerModel> list = managementCustomerService.pagingCustomerList(2, 1);
        for (CustomerModel customerModel : list) {
            System.out.println(customerModel.toString());
        }
    }
    
}

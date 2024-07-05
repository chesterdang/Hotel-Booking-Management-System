/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import dao.ICustomerDAO;
import dao.impli.CustomerDAO;
import model.CustomerModel;
import service.ICustomerService;

/**
 *
 * @author Nguyen Quang Hau
 */
public class CustomerService implements ICustomerService{
    private ICustomerDAO customerDAO = new CustomerDAO();
    
    @Override
    public CustomerModel findBy(long id) {
        return customerDAO.findBy(id);
    }
    
}

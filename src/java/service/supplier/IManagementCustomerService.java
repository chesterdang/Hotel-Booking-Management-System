/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import java.util.List;
import model.CustomerModel;

/**
 *
 * 
 */
public interface IManagementCustomerService {
    List<CustomerModel> getAllCutomerBySupplierId(int SupplierId);
    int countTotalCustomer(int supplierId);
    List<CustomerModel> pagingCustomerList(int supplierId ,int index);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.ISupplierDAO;
import dao.impli.SupplierDAO;
import model.SupplierModel;
import service.supplier.ISupplierService;

/**
 *
 * @author MaiGiang
 */
public class SupplierService implements ISupplierService {

    private ISupplierDAO supplierDAO = new SupplierDAO();

    @Override
    public SupplierModel getSuplierBy(long id) {
        return supplierDAO.findBy(id);
    }

    @Override
    public boolean updateSupplierProfile(String fullname, String dob, String email, String phone, String address, String filename, long id) {
        return supplierDAO.updateSupplier(fullname, dob, email, phone, address, filename, id);
    }

    public static void main(String[] args) {
        SupplierService service = new SupplierService();
//        SupplierModel supplierModel = service.getSuplierBy(1);
//        System.out.println(supplierModel);
    if(service.updateSupplierProfile("Supplier W", "1980-03-25", "supplierAAAA@example.com", "0987765544", "Nam Ky KN", "default.jpg", 1));
        System.out.println("123");

    }

    @Override
    public boolean updatePassword(String password, long id) {
        return supplierDAO.updatePassword(password, id);
    }

}

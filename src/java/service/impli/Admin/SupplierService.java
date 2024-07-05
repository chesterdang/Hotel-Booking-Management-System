/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.Admin;

import dao.ISupplierDAO;
import dao.impli.SupplierDAO;
import java.util.HashMap;
import java.util.List;
import mapping.IRowMapping;
import model.SupplierModel;
import service.Admin.ISupplierService;

/**
 *
 * @author quandba
 */
public class SupplierService implements ISupplierService{
    private ISupplierDAO supplierDAO = new SupplierDAO() ;
    
    @Override
    public List<SupplierModel> finaAll() {
        return supplierDAO.finaAll();
    }
    
    @Override
    public SupplierModel findBy(long id) {
        return supplierDAO.findBy(id);
    }
    
    public static void main(String[] args) {
        SupplierService service = new SupplierService();
        for (SupplierModel arg : service.finaAll()) {
            System.out.println(arg.toString());
        }
        System.out.println("---------------------------------");
        System.out.println(service.findBy(1));
    }

    @Override
    public List<SupplierModel> sortList(String str, String ASCorDESC) {
         return supplierDAO.sortList(str, ASCorDESC);
    }

    @Override
    public List<SupplierModel> searchBy(String str, String column) {
        return supplierDAO.searchBy(str, column);
    }


    @Override
    public HashMap<Integer, Integer> numberSupplierRegisteredbymonth() {
        return supplierDAO.numberSupplierRegisteredbymonth();
    }

    
    @Override
    public boolean delete(long id) {
        return supplierDAO.delete(id);
    }

    
    @Override
    public int getTotalSupplier(String where) {
        return supplierDAO.getTotalSupplier(where);
    }

    @Override
    public List<SupplierModel> pagingListSupplier(String column,String ASCorDESC,int index, int quantityPerPage,String where) {
        return supplierDAO.pagingListSupplier(column, ASCorDESC, index, quantityPerPage, where);

    }

    @Override
    public boolean unlock(long id) {
         return supplierDAO.unlock(id);
    }
    
    
    @Override
    public int getTotalNumberRegister(int month) {
        return  supplierDAO.getTotalNumberRegister(month);
    }

    @Override
    public List<Integer> getDistinctRegistrationMonths() {
        return  supplierDAO.getDistinctRegistrationMonths();
    }


    

    
    

   

   



  

    
    
}

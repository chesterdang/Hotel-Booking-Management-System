/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.InvoiceModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IInvoiceDAO {
     InvoiceModel findBy(long id);
    List<InvoiceModel> findInvoiceByCustomerID(long id);
    List<InvoiceModel> findWithLimit(int offset, int fetch);
    Integer countTotal(long id) ;
    List<InvoiceModel> findInvoiceByCustomerID(long id, int offset, int fetch);
    List<InvoiceModel> findAll();
    List<InvoiceModel> findAll(int offset, int fetch);
}

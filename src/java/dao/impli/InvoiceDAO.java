/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IInvoiceDAO;
import java.util.ArrayList;
import java.util.List;
import mapping.impli.InvoiceMapping;
import mapping.impli.RoomMapping;
import model.InvoiceModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class InvoiceDAO extends AbstractModel implements IInvoiceDAO{

     @Override
    public InvoiceModel findBy(long id) {
         String sql = "SELECT * FROM Invoice WHERE id = ?";
         List<InvoiceModel> list =  query(sql, new InvoiceMapping(), id);
        return  (list.isEmpty())?null:list.get(0);
    }
    
      @Override
    public List<InvoiceModel> findInvoiceByCustomerID(long id){
        String sql = "SELECT * FROM Invoice WHERE customerID = ?";
        List<InvoiceModel> list =  query(sql, new InvoiceMapping(), id);
        return  (list.isEmpty())?null:list;
    }
    
     @Override
    public List<InvoiceModel> findInvoiceByCustomerID(long id, int offset, int fetch){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Invoice where customerID = ? ");
        sql.append("order by paymentDate desc ");
        sql.append("offset ? rows ");
        sql.append("fetch next ? rows only ");
        return query(sql.toString(), new InvoiceMapping(),id,(offset-1)*fetch,fetch);
    }
    
    @Override
    public List<InvoiceModel> findWithLimit(int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Invoice ");
        sql.append("order by paymentDate desc ");
        sql.append("offset ? rows ");
        sql.append("fetch next ? rows only");
        return query(sql.toString(), new RoomMapping(),(offset-1)*fetch,fetch);
    }
    
    @Override
    public Integer countTotal(long id) {
        String sql = "SELECT * FROM Invoice WHERE customerID = ?";
        List<InvoiceModel> list =  query(sql, new InvoiceMapping(), id);
        return list==null?0:list.size();
    }
    
    
        @Override
    public List<InvoiceModel> findAll() {
        String sql = "SELECT * FROM Invoice Where status = 1";
        List<InvoiceModel> list = new ArrayList<>();
        list = query(sql, new InvoiceMapping());
        return list;
               
    }
    
    

    @Override
    public List<InvoiceModel> findAll(int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Invoice");
        sql.append("WHERE status = 1");
        sql.append("offset ? rows ");
        sql.append("fetch next ? rows only");
        return query(sql.toString(), new InvoiceMapping(),offset,fetch);
        
        
    }
    
    
    
}

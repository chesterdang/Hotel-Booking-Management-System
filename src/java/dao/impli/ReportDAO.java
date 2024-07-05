/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IReportDAO;
import java.sql.Timestamp;
import java.util.List;
import mapping.impli.ReportMapping;
import model.ReportModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ReportDAO extends AbstractModel implements IReportDAO {

   @Override
    public ReportModel findBy(long id) {
        String sql = "SELECT * FROM Report WHERE id = ?";
        List<ReportModel> list = query(sql, new ReportMapping(), id);
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public Long insert(ReportModel report) {
        String sql = """
                     INSERT INTO [dbo].[Report] ([customerId], [roomNo], [createdDate], [content])
                     VALUES (?, ?, ?, ?);""";
        return insert(sql,report);
    }
    
    
     @Override
    public Long insert(long cusID, long roomNo, Timestamp createdDate, String content) {
        String sql = """
                     INSERT INTO [dbo].[Report] ([customerId], [roomNo], [createdDate], [content])
                     VALUES (?, ?, ?, ?);""";
        return insert(sql, cusID, roomNo, createdDate, content);
    }
    
    
    @Override
    public List<ReportModel> findAll() {
        String sql = "SELECT * FROM Report";
        return query(sql, new ReportMapping());
    }

  
    @Override
    public List<ReportModel> sortList(String str, String ASCcOrDESC) {
        String sql ="SELECT * FROM Supplier ORDER BY "+str+" "+ASCcOrDESC+";";//tangdan
        return query(sql, new ReportMapping());
    }

    @Override
    public List<ReportModel> searchBy(String sth, String column) {
        String sql = "select * from Supplier where "+column+" like ?;";
       return query(sql, new ReportMapping(), "%"+sth+"%");
    }
    
   

    @Override
    public List<ReportModel> pagingListReport(String column, String ASCorDESC, int index, int quantityPerPage,String where) {
        String sql = "select * from report "+where+ "\n"
                + "order by " + column + " " + ASCorDESC + "\n"
                + "offset ? Rows fetch next " + quantityPerPage + " rows only;";
        return query(sql, new ReportMapping(), (index - 1) * quantityPerPage);

    }

    @Override
    public int getTotalReport(String where) {
        String sql = "SELECT COUNT(*)  FROM Report "+where;
        return countRows(sql);
    }

    @Override
    public boolean unlock(Long id) {
        String sql = "Update Report set status = 1 where id =?";
        return update(sql, id);
    }
    
    @Override
    public boolean delete(Long id) {
        String sql = "UPDATE report set status = 0 WHERE id =?";
        return update(sql, id);
    }
    
}

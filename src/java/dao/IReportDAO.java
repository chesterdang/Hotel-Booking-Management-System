/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import model.ReportModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IReportDAO {
    ReportModel findBy(long id);
    Long insert(ReportModel report);
    List<ReportModel> findAll();
    Long insert(long cusID, long roomNo, Timestamp createdDate, String content);
    List<ReportModel> sortList(String str,String ASCcOrDESC);
    
    
    List<ReportModel> searchBy(String sth,String column);
    boolean delete(Long id);
    
    boolean unlock(Long id);

    List<ReportModel> pagingListReport(String column, String ASCorDESC, int index, int quantityPerPage,String where);

    int getTotalReport(String where);
}

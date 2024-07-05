/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Admin;

import java.util.List;
import model.ReportModel;

/**
 *
 * @author quandba
 */
public interface IReportService {
    List<ReportModel> findAll();
    List<ReportModel> sortList(String tr,String ASCorDESC);
    
    List<ReportModel> searchBy(String str, String column);
    
    boolean delete(long id);
    
    int getTotalReport(String where);

    List<ReportModel> pagingListReport(String column, String ASCorDESC, int index, int quantityPerPage,String where);
    
    boolean unlock(long id);
}

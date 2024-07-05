/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.Admin;

import dao.IReportDAO;
import dao.impli.ReportDAO;
import java.util.List;
import model.ReportModel;
import service.Admin.IReportService;

/**
 *
 * @author quandba
 */
public class ReportService  implements IReportService{
    private IReportDAO reportDAO = new ReportDAO() ;
    @Override
    public List<ReportModel> findAll() {
        return  reportDAO.findAll();
    }

    @Override
    public List<ReportModel> sortList(String tr, String ASCorDESC) {
        return reportDAO.sortList(tr, ASCorDESC);
    }

    @Override
    public List<ReportModel> searchBy(String str, String column) {
        return reportDAO.searchBy(str, column);
    }
    
    
    @Override
    public boolean delete(long id) {
        return reportDAO.delete(id);
    }

    @Override
    public int getTotalReport(String where) {
        return reportDAO.getTotalReport(where);
    }

    @Override
    public List<ReportModel> pagingListReport(String column, String ASCorDESC, int index, int quantityPerPage,String where) {
        return reportDAO.pagingListReport(column, ASCorDESC, index, quantityPerPage,where);
    }

    @Override
    public boolean unlock(long id) {
         return reportDAO.unlock(id);
    }
    
}

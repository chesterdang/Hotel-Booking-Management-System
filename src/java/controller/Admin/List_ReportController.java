/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.ReportModel;
import service.Admin.IReportService;
import service.impli.Admin.ReportService;

/**
 *
 * @author quandba
 */
public class List_ReportController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet List_ReportController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet List_ReportController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IReportService reportService = new ReportService();
        List<ReportModel> list = null;

        final int quantityPerPage = 1;
        int index = 1;

        String searchInput = request.getParameter("search");
        int count = reportService.getTotalReport("");
        String sqlSearchWhere = "WHERE id LIKE \'%" + searchInput + "%\' OR roomNo LIKE \'%" + searchInput + "%\' OR content LIKE \'%" + searchInput + "%\' OR createdDate LIKE \'%" + searchInput + "";
//        macdinh
        list = reportService.pagingListReport("id", "ASC", index, quantityPerPage, "");
        if (searchInput != null) {
            count = reportService.getTotalReport(sqlSearchWhere);

        }

        int endPage = count / quantityPerPage;
        if (count % quantityPerPage != 0) {
            endPage++;
        }

        request.setAttribute("endPage", endPage);
        //
        String action = request.getParameter("action");
        //delete
        

        String id = request.getParameter("id");



        if (action == null) {
            request.setAttribute("sortType", "numASC");
            list = reportService.pagingListReport("id", "ASC", 1, quantityPerPage, "");
            request.setAttribute("list_customer", list);
            request.getRequestDispatcher("views/Admin/ListReport.jsp").forward(request, response);

        }
        if (action != null) {
            String indexPage = request.getParameter("index");
            if (indexPage != null) {

                index = Integer.parseInt(indexPage);
                if (index > endPage) {
                    index = 1;
                }
            }

            switch (action) {

                case "az":

//                    list = customerService.sortList("fullname", "ASC");
                    list = reportService.pagingListReport("content", "ASC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = reportService.pagingListReport("content", "ASC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
                case "za":
//                    list = customerService.sortList("fullname", "DESC");
                    list = reportService.pagingListReport("content", "DESC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = reportService.pagingListReport("content", "DESC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
                case "numASC":
//                    list = customerService.sortList("id", "ASC");

                    if (searchInput != null) {
                        list = reportService.pagingListReport("id", "ASC", index, quantityPerPage, sqlSearchWhere);
                    } else {
                        list = reportService.pagingListReport("id", "ASC", index, quantityPerPage, "");
                    }
                    break;
                case "numDESC":
//                    list = customerService.sortList("id", "DESC");
                    list = reportService.pagingListReport("id", "DESC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = reportService.pagingListReport("id", "DESC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
                case "searchCustomer":
                    list = reportService.searchBy(request.getParameter("inputSearch"), "fullname");

                    break;

                default:
                    throw new AssertionError();
            }
        }

        request.setAttribute("searchValue", searchInput);
        request.setAttribute("sortType", action);
        request.setAttribute("index", index);
        request.setAttribute("list_report", list);
        request.getRequestDispatcher("views/Admin/ListReport.jsp").forward(request, response);


      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

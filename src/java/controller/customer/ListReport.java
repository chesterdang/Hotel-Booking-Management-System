/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.CustomerModel;
import model.ReportModel;
import service.Admin.IReportService;
import service.impli.Admin.ReportService;


/**
 *
 * @author HI
 */
@WebServlet(name = "ListReport", urlPatterns = {"/listreport"})
public class ListReport extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListReport</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListReport at " + request.getContextPath() + "</h1>");
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
        CustomerModel c = (CustomerModel) (request.getSession().getAttribute("user"));
        List<ReportModel> list = null;

        final int quantityPerPage = 2;
        int index = 1;

        String searchInput = request.getParameter("search");
        int count = reportService.getTotalReport("where customerId =" + c.getId());
        String sqlSearchWhere = "WHERE customerId = " + c.getId() + " AND (roomNo LIKE '%" + searchInput + "%' OR content LIKE '%" + searchInput + "%' OR createdDate LIKE '%" + searchInput + "%')";
//        macdinh
        list = reportService.pagingListReport("createdDate", "DESC", index, quantityPerPage, "where customerId =" + c.getId());
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

        String indexPage = request.getParameter("index");
        
        if (action == null) {
            request.setAttribute("sortType", "DateDESC");
            list = reportService.pagingListReport("createdDate", "DESC", indexPage==null ? index : Integer.parseInt(indexPage), quantityPerPage, "where customerId =" + c.getId());
            request.setAttribute("list_report", list);
            request.getRequestDispatcher("views/customer/Report.jsp").forward(request, response);

        }
        if (action != null) {
//            String indexPage = request.getParameter("index");
            if (indexPage != null) {

                index = Integer.parseInt(indexPage);
                if (index > endPage) {
                    index = 1;
                }
            }

            switch (action) {
                case "DateASC":
//                    list = customerService.sortList("id", "ASC");

                    if (searchInput != null) {
                        list = reportService.pagingListReport("createdDate", "ASC", index, quantityPerPage, sqlSearchWhere);
                    } else {
                        list = reportService.pagingListReport("createdDate", "ASC", index, quantityPerPage, "");
                    }
                    break;
                case "DateDESC":
//                    list = customerService.sortList("id", "DESC");
                    list = reportService.pagingListReport("createdDate", "DESC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = reportService.pagingListReport("createdDate", "DESC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
            }
        }

        request.setAttribute("searchValue", searchInput);
        request.setAttribute("sortType", action);
        request.setAttribute("index", index);
        request.setAttribute("list_report", list);
        request.getRequestDispatcher("views/customer/Report.jsp").forward(request, response);
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

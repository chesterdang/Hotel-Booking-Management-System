/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.SupplierModel;
import service.Admin.ISupplierService;
import service.impli.Admin.SupplierService;

/**
 *
 * @author quandba
 */
@MultipartConfig(maxFileSize = 1024 * 10)
@WebServlet(name = "List_SupplierController", urlPatterns = {"/list_supplier"})
public class List_SupplierController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet List_SupplierController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet List_SupplierController at " + request.getContextPath() + "</h1>");
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
        ISupplierService supplierService = new SupplierService();
        List<SupplierModel> list = supplierService.finaAll();

        final int quantityPerPage = 4;
        int index = 1;

        String searchInput = request.getParameter("search");
        int count = supplierService.getTotalSupplier("");
        String sqlSearchWhere = "WHERE id LIKE \'%" + searchInput + "%\' OR fullname LIKE \'%" + searchInput + "%\' OR email LIKE \'%" + searchInput + "%\' OR status LIKE \'%" + searchInput + "%\'or phone like \'%" + searchInput + "%\' ";
//        macdinh
        list = supplierService.pagingListSupplier("id", "ASC", index, quantityPerPage, "");
        if (searchInput != null) {
            count = supplierService.getTotalSupplier(sqlSearchWhere);

        }

        int endPage = count / quantityPerPage;
        if (count % quantityPerPage != 0) {
            endPage++;
        }

        request.setAttribute("endPage", endPage);
        //
        String action = request.getParameter("action");
        //delete
        String delete = request.getParameter("delete");
        String unlock = request.getParameter("unlock");

        String id = request.getParameter("id");

        if (delete != null && delete.equals("1")) {
            if (!supplierService.delete(Long.parseLong(id))) {
                request.getRequestDispatcher("views/Admin/error.jsp").forward(request, response);
            }
        }

        if (unlock != null && unlock.equals("1")) {
            if (!supplierService.unlock(Long.parseLong(id))) {
                request.getRequestDispatcher("views/Admin/error.jsp").forward(request, response);
            }
        }

        if (action == null) {
            request.setAttribute("sortType", "numASC");
            list = supplierService.pagingListSupplier("id", "ASC", 1, quantityPerPage, "");
            request.setAttribute("list_customer", list);
            request.getRequestDispatcher("views/Admin/ListCustomer.jsp").forward(request, response);

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
                    list = supplierService.pagingListSupplier("fullname", "ASC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = supplierService.pagingListSupplier("fullname", "ASC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
                case "za":
//                    list = customerService.sortList("fullname", "DESC");
                    list = supplierService.pagingListSupplier("fullname", "DESC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = supplierService.pagingListSupplier("fullname", "DESC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
                case "numASC":
//                    list = customerService.sortList("id", "ASC");

                    if (searchInput != null) {
                        list = supplierService.pagingListSupplier("id", "ASC", index, quantityPerPage, sqlSearchWhere);
                    } else {
                        list = supplierService.pagingListSupplier("id", "ASC", index, quantityPerPage, "");
                    }
                    break;
                case "numDESC":
//                    list = customerService.sortList("id", "DESC");
                    list = supplierService.pagingListSupplier("id", "DESC", index, quantityPerPage, "");
                    if (searchInput != null) {
                        list = supplierService.pagingListSupplier("id", "DESC", index, quantityPerPage, sqlSearchWhere);
                    }
                    break;
                case "searchCustomer":
                    list = supplierService.searchBy(request.getParameter("inputSearch"), "fullname");

                    break;

                default:
                    throw new AssertionError();
            }
        }

        request.setAttribute("searchValue", searchInput);
        request.setAttribute("sortType", action);
        request.setAttribute("index", index);
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/Admin/ListSupplier.jsp").forward(request, response);

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

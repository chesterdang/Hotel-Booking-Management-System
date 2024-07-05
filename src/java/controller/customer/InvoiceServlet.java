/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.customer;

import dao.IInvoiceDAO;
import dao.impli.InvoiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.CustomerModel;
import model.InvoiceModel;


/**
 *
 * @author HI
 */
@WebServlet(name = "InvoiceServlet", urlPatterns = {"/invoice"})
public class InvoiceServlet extends HttpServlet {
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
            out.println("<title>Servlet InvoiceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InvoiceServlet at " + request.getContextPath() + "</h1>");
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
//        CustomerModel c = (CustomerModel) (request.getSession().getAttribute("user"));
//        IInvoiceDAO invoiceDao = new InvoiceDAO();
//        List<InvoiceModel> listInvoiceUse = invoiceDao.findInvoiceByCustomerID(c.getId());
//        request.setAttribute("listinvoice", listInvoiceUse);
//        request.getRequestDispatcher("/views/customer/Invoice.jsp").forward(request, response);
        
        
        IInvoiceDAO invDao = new InvoiceDAO();
        CustomerModel c = (CustomerModel) (request.getSession().getAttribute("user"));
        List<InvoiceModel> list = null;

        final int quantityPerPage = 1;
        String indexPage = request.getParameter("index");
        int index = Integer.parseInt(indexPage);
        
        String searchInput = request.getParameter("search");
        String sqlSearchWhere = "WHERE customerId = " + c.getId() ;
//        macdinh
        long id = c.getId();
        list = invDao.findInvoiceByCustomerID(c.getId(),index, quantityPerPage);
//        if (searchInput != null) {
//            count = 
//
//        }
        int count = invDao.countTotal(c.getId());
        int endPage = count / quantityPerPage;
        if (count % quantityPerPage != 0) {
            endPage++;
        }

        request.setAttribute("endPage", endPage);
        request.setAttribute("index", index);
        request.setAttribute("listinvoice", list);
        request.getRequestDispatcher("views/customer/Invoice.jsp").forward(request, response);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import static com.oracle.wls.shaded.org.apache.xalan.lib.ExsltDynamic.map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.AdminModel;
import model.CustomerModel;
import service.Admin.IAdminService;
import service.Admin.ICustomerService;
import service.Admin.ISupplierService;
import service.impli.Admin.AdminService;
import service.impli.Admin.CustomerService;
import service.impli.Admin.SupplierService;
import util.SessionUtil;



/**
 *
 * @author quandba
 */
public class Main_ListController extends HttpServlet {

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
            out.println("<title>Servlet Main_ListController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Main_ListController at " + request.getContextPath() + "</h1>");
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
        ICustomerService customerService = new CustomerService();
        
        int month1 = customerService.getTotalNumberRegister(1);
        int month2 = customerService.getTotalNumberRegister(2);
        int month3 = customerService.getTotalNumberRegister(3);
        int month4 = customerService.getTotalNumberRegister(4);
        int month5 = customerService.getTotalNumberRegister(5);
        int month6 = customerService.getTotalNumberRegister(6);
        int month7 = customerService.getTotalNumberRegister(7);
        int month8 = customerService.getTotalNumberRegister(8);
        int month9 = customerService.getTotalNumberRegister(9);
        int month10 = customerService.getTotalNumberRegister(10);
        int month11 = customerService.getTotalNumberRegister(11);
        int month12 = customerService.getTotalNumberRegister(12);
        
        

     
        List<Integer> registrationNumbers_cus = new ArrayList<>();


        for (int i = 1; i <= 12; i++) {
            int registrationNumber = customerService.getTotalNumberRegister(i);
            if (registrationNumber != 0) {
                registrationNumbers_cus.add(registrationNumber);
            }
        }
        
        List nonZeroMonths_cus = customerService.getDistinctRegistrationMonths();
        
        
        
        List<Integer> registrationNumbers_sup = new ArrayList<>();


        for (int i = 1; i <= 12; i++) {
            int registrationNumber = supplierService.getTotalNumberRegister(i);
            if (registrationNumber != 0) {
                registrationNumbers_sup.add(registrationNumber);
            }
        }
        
        List nonZeroMonths_sup = supplierService.getDistinctRegistrationMonths();
        
        
       

        
        HashMap<Integer, Integer> numberSupplierModels = supplierService.numberSupplierRegisteredbymonth();
        HashMap<Integer, Integer> numberCustomerModels = customerService.numberSupplierRegisteredbymonth();

        for (Map.Entry<Integer, Integer> entry : numberSupplierModels.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        
        request.getSession().setAttribute("numberSupplierModels", numberSupplierModels);
        request.getSession().setAttribute("numberCustomerModels", numberCustomerModels);
        
        for (Map.Entry<Integer, Integer> entry : numberCustomerModels.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        
        

        request.getSession().setAttribute("registrationNumbers_cus", registrationNumbers_cus);
        request.getSession().setAttribute("nonZeroMonths_cus", nonZeroMonths_cus);
        
        
        request.getSession().setAttribute("registrationNumbers_sup", registrationNumbers_sup);
        request.getSession().setAttribute("nonZeroMonths_sup", nonZeroMonths_sup);


        
        request.getRequestDispatcher("/views/MainList.jsp").forward(request, response);
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
//        HttpSession session = request.getSession(true);
        
//        SessionUtil sessionUtil = new SessionUtil();
//        sessionUtil.putValue(request,"fullname" , "admin1@example.com");
//        String userS = (String) sessionUtil.getValue(request, "fullname");
//        
//        
//        IAdminService adminService = new AdminService();
//        AdminModel adminModel = adminService.selecByUserName(userS);
        
   
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

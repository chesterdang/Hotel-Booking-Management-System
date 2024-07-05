/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.impli.RoleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import model.Person;
import model.SupplierModel;
import service.IUserService;
import service.impli.UserService;
import util.EncryptionUtil;

/**
 *
 * @author LAPTOP DELL
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
private final EncryptionUtil eu = new EncryptionUtil();
private final RoleDAO roleDAO = new RoleDAO();
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
            out.println("<title>Servlet RegisterController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
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
        IUserService userService = new UserService();
                      
        String roleCodeS = request.getParameter("roleCode");
        String fName = request.getParameter("fullname");
        String uPass = request.getParameter("password");
        String uEmail = request.getParameter("email");
        String cfpass = request.getParameter("confirm");
        Date uDob = Date.valueOf( request.getParameter("dob"));
        String uAddress = request.getParameter("address");
        String uNumber = request.getParameter("phone");
        String encrypPass =eu.toSHA1(uPass);
                
        
    
        
        
        if (userService.checkFormatEmail(uEmail)==false){
            request.setAttribute("errorEmail", "Please enter a valid email address.");
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
        }
        
        if (userService.checkExistEmail(uEmail)){
            request.setAttribute("existEmail", "This email address was used to create the account. Do you want to receive an email to create a new password?");
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
        } 
           
       
        if (userService.checkFormatPassword(uPass)==false) {
            request.setAttribute("errorPass", "Please enter a valid password. The password must be at least 6 characters long.");
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
        }
        
        if(userService.confirmPassword(uPass, cfpass)==false) {
            request.setAttribute("errorConfirm", "Password mismatch Please re-enter your password.");
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
        }
        
        if(roleCodeS.equalsIgnoreCase("Sup")) {
            SupplierModel supplier = new SupplierModel(fName, uEmail, uPass, roleDAO.findBy(roleCodeS), uDob, uAddress, uNumber);
            
                    
            request.getSession().setAttribute("supplier", supplier);
                    
            request.getRequestDispatcher("views/hotelId.jsp").forward(request, response);
            return;
        }
        
        Long hotelId = null;
        
        if(userService.registUser(fName, encrypPass,uDob, roleCodeS, uEmail,uNumber,uAddress,hotelId)){
            request.setAttribute("mess", "Sign Up Success");
             System.out.println(userService.sendMail(uEmail, "REGIST SUCCSESS", "Your account registered successfully\n" +
             "Thank you for trusting and choosing us"));
            request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("views/LoginViews/error.jsp").forward(request, response);
        }

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

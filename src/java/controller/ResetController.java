/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import service.IUserService;
import service.impli.UserService;
import java.sql.Timestamp;
import util.EncryptionUtil;

/**
 *
 * @author Hi
 */
@WebServlet(name = "ResetController", urlPatterns = {"/reset"})
public class ResetController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IUserService userService = new UserService();
        String v = request.getParameter("validTime");
      String username = request.getParameter("username");
      String password = request.getParameter("password");
     
      String cpassword = request.getParameter("cpassword");
      String captcha = request.getParameter("code");
      
      int error = 0;
       if (!userService.isEquals(password, cpassword)) {
              request.setAttribute("errorcPass","Passwords do not match. Please re-enter passwords." );
              error++;
        }
        if (!userService.checkFormatPassword(password)) {
            request.setAttribute("errorPass", "Password is case sensitive and must be at least 3 characters long.");       
            error ++;
          
        }
        if (!userService.isEqualsCaptcha(captcha,username)) {
            request.setAttribute("errorCode", "CODE do not match. Please re-enter CODE.");       
            error ++;
          
        }
        
        if (!userService.isValidCode(new Timestamp(System.currentTimeMillis()) , username)) {
            request.setAttribute("errorCode", "CODE has expired.");       
            error ++;
          
        }
       
        if (error!=0) {
            request.setAttribute("email", username);
            
            request.setAttribute("validTime",v);
              request.getRequestDispatcher("views/LoginViews/reset.jsp").forward(request, response);
        }else{
            if (userService.editPasswordByEmail(EncryptionUtil.toSHA1(password), username)) {
                 
                request.setAttribute("mess", "Reset password successfully");
                request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
            }
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

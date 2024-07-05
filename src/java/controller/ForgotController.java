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
import java.sql.Timestamp;
import service.IUserService;
import service.impli.UserService;




/**
 *
 * @author Hi
 */
@WebServlet(name = "ForgotController", urlPatterns = {"/forgot"})
public class ForgotController extends HttpServlet {

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
            out.println("<title>Servlet ForgotController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotController at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("validTime", -1);
       request.getRequestDispatcher("views/LoginViews/forgot.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          IUserService userService = new UserService();
        String username = request.getParameter("username");
         if (userService.checkFormatEmail(username)==false) {
            request.setAttribute("usernameError", "Email address format is not valid.");  
            request.getRequestDispatcher("views/LoginViews/forgot.jsp").forward(request, response);
        }
        
         if (userService.checkExistEmail(username) && userService.findAccountByEmail(username).getStatus()==1) {
             String captcha = userService.createCaptcha();
             userService.addCaptcha(captcha, new Timestamp(System.currentTimeMillis()),username);
             System.out.println(userService.sendMail(username, "RESET PASSWORD", "<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"<meta charset=\"UTF-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"<title>Quên mật khẩu</title>\n" +
"<style>\n" +
"    /* Reset styles */\n" +
"    body, html {\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"        font-family: Arial, sans-serif;\n" +
"    }\n" +
"    \n" +
"    /* Wrapper */\n" +
"    .wrapper {\n" +
"        width: 100%;\n" +
"        max-width: 600px;\n" +
"        margin: 0 auto;\n" +
"    }\n" +
"    \n" +
"    /* Header */\n" +
"    .header {\n" +
"        background-color: #333;\n" +
"        color: #fff;\n" +
"        text-align: center;\n" +
"        padding: 10px 0;\n" +
"        font-size: 80%;\n" +
"    }\n" +
"\n" +
"    /* Password recovery */\n" +
"    .password-recovery {\n" +
"        text-align: center;\n" +
"        margin-top: 20px;\n" +
"    }\n" +
"\n" +
"    /* Password box */\n" +
"    .password-box {\n" +
"        width: 200px;\n" +
"        height: 100px;\n" +
"        background-color: #f1f1f1;\n" +
"        margin: 0 auto;\n" +
"        text-align: center;\n" +
"        line-height: 100px;\n" +
"        font-size: 24px;\n" +
"    }\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<div class=\"wrapper\">\n" +
"    <div class=\"header\">\n" +
"        <h1>This is the code used to retrieve the password (Don't let anyone peek)</h1>\n" +
"    </div>\n" +
"\n" +
"    <div class=\"password-recovery\">\n" +
"        <div class=\"password-box\">\n" +
"            "+captcha+"\n" +
"        </div>\n" +
"    </div>\n" +
"</div>\n" +
"\n" +
"</body>\n" +
"</html>\n" +
"")
             );        
             request.setAttribute("mess", "The CODE to reset your password has been sent to"+username+". Please check your mail."); 
             request.setAttribute("email", username);  
             
             request.setAttribute("validTime","-1" );
             request.getRequestDispatcher("views/LoginViews/reset.jsp").forward(request, response);
             
   
        }
         else{
              request.setAttribute("usernameError", "Email is not exist.");  
            request.getRequestDispatcher("views/LoginViews/forgot.jsp").forward(request, response);
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

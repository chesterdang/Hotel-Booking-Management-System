/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.management.relation.Role;
import model.Person;
import service.IUserService;
import service.impli.UserService;
import util.EncryptionUtil;
import util.SessionUtil;

/**
 *
 * @author Hi
 */
@WebServlet(name = "SigninController", urlPatterns = {"/signin"})
public class SignInController extends HttpServlet {

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
            out.println("<title>Servlet SignUpController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpController at " + request.getContextPath() + "</h1>");
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
        Cookie arr[] = request.getCookies();
        for (Cookie cookie : arr) {
            if (cookie.getName().equals("user1")) {
                request.setAttribute("username", cookie.getValue());

            }
            if (cookie.getName().equals("pass1")) {
                request.setAttribute("password", cookie.getValue());
            }
        }

        request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IUserService userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordEncry = EncryptionUtil.toSHA1(password);

        Person person = userService.findAccountByEmailAndPass(username, passwordEncry);
        if (username == "") {
            request.setAttribute("usernameError", "Please enter your email");
            if (password == "") {
                request.setAttribute("passError", "Please enter your password");
            }
            request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
        }

        int error = 0;
        if (userService.checkFormatEmail(username) == false) {
            request.setAttribute("usernameError", "Email address format is not valid.");
            error++;

        }
        if (userService.checkFormatPassword(password) == false) {
            request.setAttribute("passError", "Password is case sensitive and must be at least 3 characters long.");
            error++;
        }
        if (error != 0) {
            request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
        }

        try {
            if (person == null) {
                request.setAttribute("mess", "Email or Password is incorrect.");
                request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
            } else {
                if (person.getStatus() == 1) {
                    SessionUtil.getInstance().putValue(request, "user", person);

                    //luuAcctrenCookie
                    Cookie u = new Cookie("user1", username);
                    u.setMaxAge(60);
                    response.addCookie(u);//luu len chrome
                    Cookie p = new Cookie("pass1", password);
                    p.setMaxAge(60);
                    response.addCookie(p);//luu len chrome

                    String role = person.getRoleModel().getName().toLowerCase();
                    request.setAttribute("person", person);
                    if (role.equalsIgnoreCase("customer")) {
                          response.sendRedirect(request.getContextPath()+"/HomeCustomerController");
//                        response.sendRedirect("http://localhost:9999/BookingHotel_Prj301/HomeCustomerController?action=roomHome&fetch=6&page=1");
//                        request.getRequestDispatcher("HomeCustomerController").forward(request, response);
                    }
                    if(role.equalsIgnoreCase("supplier")){
                        response.sendRedirect("http://localhost:9999/BookingHotel_Prj301/views/supplier/home.jsp");
//                         request.getRequestDispatcher("HomeCustomerController").forward(request, response);
                    }
                    if(role.equalsIgnoreCase("administrator")){
                        response.sendRedirect("http://localhost:9999/BookingHotel_Prj301/Main_ListController");
                        // request.getRequestDispatcher("http://localhost:9999/BookingHotel_Prj301/Main_ListController").forward(request, response);
                    }

                } else {
                    request.setAttribute("mess", "This email account is temporarily unable to log in");
                    request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

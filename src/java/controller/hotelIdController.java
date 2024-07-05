/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.IHotelDAO;
import dao.impli.HotelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.HotelModel;
import model.SupplierModel;
import service.IUserService;
import service.impli.UserService;
import util.EncryptionUtil;

/**
 *
 * @author LAPTOP DELL
 */
@WebServlet(name = "hotelIdController", urlPatterns = {"/hotelid"})
public class hotelIdController extends HttpServlet {
    private final EncryptionUtil eu = new EncryptionUtil();
     IHotelDAO hotelDAO = new HotelDAO();

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
            out.println("<title>Servlet hotelIdController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hotelIdController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        
        SupplierModel supplier = (SupplierModel)request.getSession().getAttribute("supplier");
        String nameHotel = request.getParameter("nameHotel");
        String address = request.getParameter("address");
        String postcode = request.getParameter("postcode");
        Integer numRoom = Integer.parseInt(request.getParameter("numRoom"));
        String phone = request.getParameter("phone");
        Double starRating = Double.parseDouble(request.getParameter("starRating"));
        
//        String hotelImage = request.getParameter("hotelImage");
        
//        HotelModel hotelModel = new HotelModel();
//        hotelModel.setName(nameHotel);
//        hotelModel.setAddress(address);
//        hotelModel.setPostcode(postcode);
//        hotelModel.setNumRooms(numRoom);
//        hotelModel.setPhone(phone);
//        hotelModel.setStarRating(starRating);
        try {
          Long htId =  userService.registHotel( nameHotel, address, postcode, numRoom, phone, starRating);
            if (userService.registUser(supplier.getFullname(),eu.toSHA1(supplier.getPassword()), supplier.getDOB(), "Sup", supplier.getEmail(),supplier.getPhone() , supplier.getAddress(),htId)) {
                request.getSession().removeAttribute("supplier");
                request.setAttribute("mess", "Sign Up Success");
                request.getRequestDispatcher("views/LoginViews/login.jsp").forward(request, response);
            }else{
                request.getSession().removeAttribute("supplier");
                request.getRequestDispatcher("views/LoginViews/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
             request.getSession().removeAttribute("supplier");
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

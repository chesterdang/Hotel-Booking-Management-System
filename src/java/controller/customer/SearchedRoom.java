/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.customer;

import com.microsoft.sqlserver.jdbc.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import service.IRoomService;
import service.impli.RoomService;

/**
 *
 * @author Nguyen Quang Hau
 */
@WebServlet(name = "SearchedRoom", urlPatterns = {"/SearchedRoom"})
public class SearchedRoom extends HttpServlet {

    private IRoomService roomService = new RoomService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchedRoom</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchedRoom at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int page;
            int fetch;
            int offset;
            //paging of feedback
            try {
                page = Integer.parseInt(request.getParameter("page"));
                fetch = Integer.parseInt(request.getParameter("fetch"));
                if (fetch <= 0) {
                    throw new Exception();
                }
                offset = (page - 1) * fetch;
            } catch (Exception e) {
                page = 1;
                offset = 0;
                fetch = 6;
            }
            
            
            String address = request.getParameter("address");
            java.math.BigDecimal minPrice = new BigDecimal(request.getParameter("minPrice"));
            java.math.BigDecimal maxPrice = new BigDecimal(request.getParameter("maxPrice"));
            StringBuilder pagingUrl = new StringBuilder("/BookingHotel_Prj301/SearchedRoom?");
            pagingUrl.append("address=" + address);
            pagingUrl.append("&minPrice=" + minPrice);
            pagingUrl.append("&maxPrice=" + maxPrice);
            pagingUrl.append("&fetch=" + fetch);
            pagingUrl.append("&page=");

            int totalPage = roomService.countRoomWith(address, minPrice, maxPrice) / fetch;
            if (roomService.countRoomWith(address, minPrice, maxPrice) % fetch != 0) {
                totalPage++;
            }

            request.setAttribute("pagingUrl", pagingUrl.toString());
            request.setAttribute("address", address);
            request.setAttribute("minPrice", minPrice);
            request.setAttribute("maxPrice", maxPrice);
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("rooms", roomService.findWith(address, minPrice, maxPrice, offset, fetch));
            request.getRequestDispatcher("/views/customer/CustomerHome.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/HomeCustomerController?alert=danger&msg=SearchingError");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

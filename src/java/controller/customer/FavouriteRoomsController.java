/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import service.IRoomService;
import service.impli.RoomService;

/**
 *
 * @author Nguyen Quang Hau
 */
@WebServlet(name = "FavouriteRoomsController", urlPatterns = {"/FavouriteRoomsController"})
public class FavouriteRoomsController extends HttpServlet {

    private IRoomService roomService = new RoomService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FavouriteRoomsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FavouriteRoomsController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page;
        int fetch;
        int offset;
        int totalPage = 0;
        Cookie cFavRooms = getExplicitCookie(request, "cFavRooms");
        List<Long> roomNos = getFavRoomNos(cFavRooms.getValue());
        
        //paging
        try {
            page = Integer.parseInt(request.getParameter("page"));
            fetch = Integer.parseInt(request.getParameter("fetch"));
            if(fetch <= 0) throw new Exception();
            offset = (page - 1) * fetch;
        } catch (Exception e) {
            page = 1;
            offset = 0;
            fetch = 6;
        }
        
        if(roomNos != null){
           totalPage = roomNos.size()/fetch;
           if(roomNos.size()%fetch != 0) totalPage++;
        }
        //end Paging
        
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("rooms", roomService.findAll(roomNos, offset, offset+fetch-1));
        request.getRequestDispatcher("/views/customer/FavouriteRoom.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Cookie getExplicitCookie(HttpServletRequest request, String nameOfCookie) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(nameOfCookie)) {
                    return cookie;
                }
            }
        }
        return new Cookie(nameOfCookie, "");
    }

    private List<Long> getFavRoomNos(String cFavRooms) {
        List<Long> ids = new ArrayList<>();

        if (cFavRooms == null || cFavRooms.trim().length() == 0) {
            ids = null;
        } else {
            for (String id : cFavRooms.substring(1).split("/")) {
                try {
                    ids.add(Long.valueOf(id));
                } catch (NumberFormatException e) {
                    ids = null;
                }
            }
        }

        return ids;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.supplier;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;
import model.HotelModel;
import model.RoomModel;
import model.RoomTypeModel;
import model.SupplierModel;
import service.impli.supplier.HotelService;
import service.impli.supplier.RoomService;
import service.impli.supplier.RoomTypeService;
import service.impli.supplier.SupplierService;
import service.supplier.IHotelService;
import service.supplier.IRoomService;
import service.supplier.IRoomTypeService;
import service.supplier.ISupplierService;

/**
 *
 * @author MaiGiang
 */
@MultipartConfig(maxFileSize = 1024 * 10)
public class roomManagementServlet extends HttpServlet {

    private IRoomService roomService = new RoomService();
    private IRoomTypeService roomTypeService = new RoomTypeService();
    private IHotelService hotelService = new HotelService();
    private ISupplierService supplierService = new SupplierService();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addRoom(request, response);
                break;
            case "showAdd":
                showAdd(request, response);
                break;
            case "listRoom":
                listRoom(request, response);
                break;
            case "edit":
                updateRoom(request, response);
                break;

            case "delete":
                deleteRoom(request, response);
                break;

            case "showEditForm":
                showEditForm(request, response);
                break;

            case "showNoticeDelete":
                showEditForm(request, response);
                break;

        }

    }

    private void addRoom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long supplierId = Long.valueOf(String.valueOf(request.getSession().getAttribute("supplierId")));

        String roomType = request.getParameter("roomType");
        RoomTypeModel roomTypeModel = roomTypeService.getRoomTypeBy(Integer.valueOf(roomType));
        HotelModel hotelModel = hotelService.getHotelBy(supplierId);
        
        String occupancyStr = request.getParameter("occupancy");
        String notice = "";
        try {
            int occupancy = Integer.valueOf(occupancyStr);

            if (occupancy < 0) {
                notice = "Occupancy cannot be a negative number.";
                request.setAttribute("notice", notice);
                request.getRequestDispatcher("views/supplier/add-room.jsp").forward(request, response);
                return; 
            }

            String priceIncludes = request.getParameter("priceIncludes");
         
            String avatar = request.getParameter("avatar");
            String price = request.getParameter("roomPrice");
            BigDecimal bigDecimalValue = new BigDecimal(price);
            
            RoomModel roomModel = new RoomModel(hotelModel, roomTypeModel, occupancy, priceIncludes, (short) 1, avatar,bigDecimalValue);
            roomService.insert(roomModel);
            notice = "Room added successfully!";
            request.setAttribute("notice", notice);
            request.getRequestDispatcher("views/supplier/add-room.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Xử lý lỗi khi không thể chuyển đổi sang số nguyên
            notice = "Invalid occupancy value. Please enter a valid number.";
            e.printStackTrace(); 
            request.setAttribute("notice", notice);
            request.getRequestDispatcher("views/supplier/add-room.jsp").forward(request, response);
        }

    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int supplierId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("supplierId")));
        request.setAttribute("supplierId", supplierId);
        request.getRequestDispatcher("views/supplier/add-room.jsp").forward(request, response);

    }

    private void updateRoom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roomType = request.getParameter("roomType");

        String occupancy = request.getParameter("occupancy");
        String priceIncludes = request.getParameter("priceIncludes");
        String avatar = request.getParameter("avatar") + "";
        String roomNo = request.getParameter("roomNo");
        long roomNoo = Long.valueOf(roomNo);
        String roomPrice = request.getParameter("roomPrice");
        BigDecimal money = new BigDecimal(roomPrice);
        
        if (roomService.update(Long.valueOf(roomType), Integer.valueOf(occupancy), priceIncludes, avatar,roomNoo,money)) {
            request.setAttribute("updateStatus", "Update Success");
            request.setAttribute("room", roomService.getRoomBy((int) roomNoo));
            request.getRequestDispatcher("views/supplier/edit-room.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("views/supplier/error.jsp").forward(request, response);
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomNo = request.getParameter("roomNo");
        RoomModel room = roomService.getRoomBy(Integer.valueOf(roomNo));

        request.getSession().setAttribute("room", room);

        request.getRequestDispatcher("views/supplier/edit-room.jsp").forward(request, response);
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int supplierId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("supplierId")));
        String roomNo = request.getParameter("roomNo");

        if (roomService.delete(Long.valueOf(roomNo))) {
            List<RoomModel> list = roomService.getAllRoomBySupplierID(supplierId);
            request.getSession().setAttribute("roomList", list);
            request.getRequestDispatcher("views/supplier/all-room.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("views/supplier/error.jsp").forward(request, response);

        }

    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int supplierId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("supplierId")));
        List<RoomModel> list = roomService.getAllRoomBySupplierID(supplierId);
      
        request.getSession().setAttribute("roomList", list);

        request.getRequestDispatcher("views/supplier/all-room.jsp").forward(request, response);
    }

    private String processImage(HttpServletRequest request) {
        try {
            Part part = request.getPart("avatar");
            String realPath = request.getServletContext().getRealPath("/images/supplier");
            String fileName = java.nio.file.Path.of(part.getSubmittedFileName()).getFileName().toString();

            if (!Files.exists(java.nio.file.Path.of(realPath))) {
                Files.createDirectory(java.nio.file.Path.of(realPath));
            }

            part.write(realPath + "/" + fileName);
            return fileName;
        } catch (IOException | ServletException ex) {
            return null;
        }
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

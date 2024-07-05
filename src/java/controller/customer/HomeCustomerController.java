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
import java.sql.Timestamp;
import java.util.List;
import model.CustomerModel;
import model.FeedbackModel;
import model.Person;
import model.RoleModel;
import model.RoomModel;
import service.IFeedbackService;
import service.IRoomService;
import service.impli.FeedbackService;
import service.impli.RoomService;
import util.SessionUtil;

/**
 *
 * @author Nguyen Quang Hau
 */
@WebServlet(name = "HomeCustomerController", urlPatterns = {"/HomeCustomerController"})
public class HomeCustomerController extends HttpServlet {

    private IRoomService roomService = new RoomService();
    private IFeedbackService feedbackService = new FeedbackService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeCustomerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeCustomerController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        StringBuilder url = new StringBuilder();
        String alert = request.getParameter("alert");
        String msg = request.getParameter("msg");
        
        //paging of room
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

        if (action != null && action.equals("detailRoom")) {
            long roomNo = 0;
            Cookie cFavRooms = getExplicitCookie(request, "cFavRooms");

            try {
                roomNo = Long.valueOf(request.getParameter("roomNo"));
            } catch (Exception e) {
                request.getRequestDispatcher("/views/customer/CustomerHome.jsp").forward(request, response);
            }

            totalPage = feedbackService.countTotal(roomNo) / fetch;
            if (feedbackService.countTotal(roomNo) % fetch != 0) {
                totalPage++;
            }

            request.setAttribute("room", roomService.findBY(roomNo));
            request.setAttribute("favourite", (cFavRooms.getValue().contains("/" + roomNo + "/")));
            request.setAttribute("booked", (roomService.countBooking(((Person) SessionUtil.getInstance().getValue(request, "user")).getId(), roomNo) > 0));
            request.setAttribute("feedbacks", feedbackService.findWithLimit(roomNo, offset, fetch));
            url.append("/views/customer/DetailRoom.jsp");
        } else {
            totalPage = roomService.countTotalWith()/ fetch;
            if (roomService.countTotalWith() % fetch != 0) {
                totalPage++;
            }
            
            
            request.setAttribute("rooms", roomService.findWith(offset, fetch));
            url.append("/views/customer/CustomerHome.jsp");
        }
        
        if (alert != null && !alert.equals("") ) {
            request.setAttribute("alert", alert);
            request.setAttribute("msg", msg);
        }

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher(url.toString()).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        StringBuilder url = new StringBuilder();
        int page;
        int fetch;
        int offset;
        int totalPage;

        String alert = "";
        String msg = "";
        long roomNo = (long) Long.parseLong(request.getParameter("roomNo"));
        Cookie cFavRooms = getExplicitCookie(request, "cFavRooms");

        if (action != null && action.equals("detailRoom")) {
            url.append("/views/customer/DetailRoom.jsp");
        } else if (action != null && action.equals("feedback")) {

            FeedbackModel feedbackModel = new FeedbackModel();
            feedbackModel.setRoomModel(new RoomModel(roomNo));
            feedbackModel.setCustomerModel((CustomerModel) SessionUtil.getInstance().getValue(request, "user"));
            feedbackModel.setContent(request.getParameter("content"));
            feedbackModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            feedbackModel.setStatus((short) 1);
            if (feedbackService.insert(feedbackModel) > 0) {
                alert = "success";
                msg = "Feedback success";
            } else {
                alert = "danger";
                msg = "Feedback failure";
            }
            url.append("/views/customer/DetailRoom.jsp");
        } else if (action != null && action.equals("deletedFeedback")) {
            long feedbackID = (long) Long.parseLong(request.getParameter("feedbackID"));
            if (feedbackService.delete(feedbackID)) {
                alert = "success";
                msg = "Delete feedback success";
            } else {
                alert = "danger";
                msg = "Delete Feedback failure";
            }
            url.append("/views/customer/DetailRoom.jsp");
        } else if (action != null && action.equals("addFavRoom")) {
            String btnFav = request.getParameter("btnFav");

            if (btnFav.equals("add")) {
                if (cFavRooms.getValue().trim().length() == 0) {
                    cFavRooms.setValue(cFavRooms.getValue() + "/" + roomNo + "/");
                } else {
                    cFavRooms.setValue(cFavRooms.getValue() + roomNo + "/");
                }
            } else {
                String str = "/" + roomNo + "/";
                String value = cFavRooms.getValue();
                int point = cFavRooms.getValue().indexOf(str);
                if (point == 0) {
                    value = value.substring(str.length() - 1);
                } else if (point == cFavRooms.getValue().length() - str.length()) {
                    value = value.substring(0, point + 1);
                } else {
                    value = value.substring(0, point) + value.substring(point + str.length() - 1);
                }
                cFavRooms.setValue(value);
            }

            url.append("/views/customer/DetailRoom.jsp");
        }else{
           response.sendRedirect(request.getContextPath()+"/HomeCustomerController");
        }

        // set notification
        if (!alert.equals("")) {
            request.setAttribute("alert", alert);
            request.setAttribute("msg", msg);
        }

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

        totalPage = feedbackService.countTotal(roomNo) / fetch;
        if (feedbackService.countTotal(roomNo) % fetch != 0) {
            totalPage++;
        }
        // end paging of feedback

        cFavRooms.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cFavRooms);
        request.setAttribute("favourite", (cFavRooms.getValue().contains("/" + roomNo + "/")));
        request.setAttribute("booked", (roomService.countBooking(((Person) SessionUtil.getInstance().getValue(request, "user")).getId(), roomNo) > 0));
        request.setAttribute("room", roomService.findBY(roomNo));
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("feedbacks", feedbackService.findWithLimit(roomNo, offset, fetch));
        request.getRequestDispatcher(url.toString()).forward(request, response);
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
}

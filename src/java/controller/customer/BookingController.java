/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.BookingModel;
import model.Person;
import service.IBookingService;
import service.ICancelBookingService;
import service.impli.BookingService;
import service.impli.CancelBookingService;
import util.SessionUtil;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import model.CustomerModel;
import model.RoomModel;
import org.apache.tomcat.jakartaee.commons.lang3.StringUtils;
import service.IRoomService;
import service.impli.RoomService;

/**
 *
 * @author Nguyen Quang Hau
 */
@WebServlet(name = "BookingController", urlPatterns = {"/BookingController"})
public class BookingController extends HttpServlet {

    private IRoomService roomService = new RoomService();
    private IBookingService bookingService = new BookingService();
    private ICancelBookingService cancelBookingService = new CancelBookingService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int page;
        int fetch;
        int offset;
        int totalPage = 0;
        String alert = request.getParameter("alert");
        String msg = request.getParameter("msg");
        StringBuilder url = new StringBuilder();
        Person user = (Person) SessionUtil.getInstance().getValue(request, "user");

        //paging
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

        if (action != null && action.equals("completedBooking")) {
            totalPage = bookingService.countBooking(user.getId(), (short) 3, (short) 7) / fetch;
            if (bookingService.countBooking(user.getId(), (short) 3, (short) 7) % fetch != 0) {
                totalPage++;
            }
            request.setAttribute("bookings", bookingService.findHistoryBooking(user.getId(), offset, fetch));
            url.append("/views/customer/Booking.jsp");
        } else if (action != null && action.equals("alreadyBooking")) {
            totalPage = bookingService.countBooking(user.getId(), (short) 1, (short) 5) / fetch;
            if (bookingService.countBooking(user.getId(), (short) 1, (short) 5) % fetch != 0) {
                totalPage++;
            }
            request.setAttribute("bookings", bookingService.findAlreadyBooking(user.getId(), offset, fetch));
            request.setAttribute("title", "Already");
            url.append("/views/customer/PendingBooking.jsp");
        } else if (action != null && action.equals("cancelBooking")) {
            totalPage = cancelBookingService.countCancelBooking(user.getId()) / fetch;
            if (cancelBookingService.countCancelBooking(user.getId()) % fetch != 0) {
                totalPage++;
            }
            request.setAttribute("bookings", cancelBookingService.findCancelBooking(user.getId(), offset, fetch));
            url.append("/views/customer/CancelBooking.jsp");
        } else if (action != null && action.equals("pendingBooking")) {

            totalPage = bookingService.countBooking(user.getId(), (short) 0, (short) 4) / fetch;
            if (bookingService.countBooking(user.getId(), (short) 0, (short) 4) % fetch != 0) {
                totalPage++;
            }
            request.setAttribute("title", "Pending");
            request.setAttribute("bookings", bookingService.findPendingBooking(user.getId(), offset, fetch));
            url.append("/views/customer/PendingBooking.jsp");
        } else if (action != null && action.equals("paymentBooking")) {

            if (request.getParameter("action2") != null) {
                if (pay(request, response)) {
                    request.setAttribute("alert", "success");
                    request.setAttribute("msg", "Payment Success");
                } else {
                    request.setAttribute("alert", "danger");
                    request.setAttribute("msg", "Payment Error");
                }

                url.append("HomeCustomerController");
            } else {
                //paging
                int start = 0;
                int end = 0;
                BigDecimal totalPrice = new BigDecimal(0);
                try {
                    List<BookingModel> paymentList = (List<BookingModel>) SessionUtil.getInstance().getValue(request, "paymentList");
                    if (paymentList != null) {
                        totalPage = paymentList.size() / fetch;
                        if (paymentList.size() % fetch != 0) {
                            totalPage++;
                        }

                        start = (page - 1) * fetch;
                        end = start + fetch - 1;
                        end = (paymentList.size() - 1 > end) ? end : (paymentList.size() - 1);
                        if (end < 0) {
                            end = 0;
                        }
                        for (int i = start; i <= end; i++) {
                            totalPrice = totalPrice.add(paymentList.get(i).getRoomModel().getMoney());
                        }

                    }
                } catch (Exception e) {
                }

                request.setAttribute("start", start);
                request.setAttribute("end", end);
                request.setAttribute("price", totalPrice);
                request.setAttribute("totalPrice", NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(totalPrice));
                url.append("/views/customer/PendingPayment.jsp");
            }
        }

        // set notification
        if (alert != null && !alert.equals("")) {
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
        try {
            String action = request.getParameter("action");
            StringBuilder url = new StringBuilder(request.getContextPath());

            if (action != null && action.equals("removePayment")) {
                int position = Integer.parseInt(request.getParameter("position"));
                List<BookingModel> paymentList = (List<BookingModel>) SessionUtil.getInstance().getValue(request, "paymentList");
                paymentList.remove(position);
                SessionUtil.getInstance().putValue(request, "paymentList", paymentList);
                url.append("/BookingController?action=paymentBooking&alert=success&msg=DeleteSuccessfully");
            } else if (action != null && action.equals("cancelBooking")) {
                String reason = request.getParameter("reason");
                long bookingId = Long.parseLong(request.getParameter("bookingId"));
                long customerId = ((Person) SessionUtil.getInstance().getValue(request, "user")).getId();
                bookingService.updateStatus(2, bookingId);
                cancelBookingService.insert(customerId, bookingId, reason);
                url.append("/BookingController?action=alreadyBooking&alert=success&msg=DeleteSuccessfully");
            } else {
                if (SessionUtil.getInstance().getValue(request, "paymentList") == null) {
                    SessionUtil.getInstance().putValue(request, "paymentList", new ArrayList<BookingModel>());
                }

                List<BookingModel> paymentList = (List<BookingModel>) SessionUtil.getInstance().getValue(request, "paymentList");
                BookingModel bookingModel = toBookingModel(request);
                if (!isBooked(paymentList, bookingModel)) {
                    paymentList.add(toBookingModel(request));
                    url.append("/HomeCustomerController?alert=success&msg=BookingSuccess");
                } else {
                    url.append("/HomeCustomerController?alert=danger&msg=BookingError");
                }
                SessionUtil.getInstance().putValue(request, "paymentList", paymentList);
            }
            response.sendRedirect(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/HomeCustomerController?alert=danger&msg=Error");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Timestamp convertDateFromStr(HttpServletRequest request, String name) throws Exception {
        String date = request.getParameter(name);
        if (StringUtils.countMatches(date, ":") == 1) {
            date += ":00";
        }
        return Timestamp.valueOf(date.replace("T", " "));
    }

    private BookingModel toBookingModel(HttpServletRequest request) throws Exception {
        Long roomNo = Long.parseLong(request.getParameter("roomNo"));
        RoomModel roomModel = roomService.findBY(roomNo);
        int numOfAdults = Integer.parseInt(request.getParameter("numOfAdults"));
        int numOfChilds = Integer.parseInt(request.getParameter("numOfChilds"));

        BookingModel bookingModel = new BookingModel();
        bookingModel.setNumAdults(numOfAdults);
        bookingModel.setNumChilds(numOfChilds);
        bookingModel.setArrivalTime(convertDateFromStr(request, "arrivalDate"));
        bookingModel.setBookingTime(new Timestamp(System.currentTimeMillis()));
        bookingModel.setDepartureTime(convertDateFromStr(request, "departureDate"));
        bookingModel.setCustomerModel((CustomerModel) SessionUtil.getInstance().getValue(request, "user"));
        bookingModel.setRoomModel(roomModel);
        bookingModel.setHotelModel(roomModel.getHotelModel());
        bookingModel.setSpecialReq(request.getParameter("specReq"));

        return bookingModel;
    }

    private boolean pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action2");
        try {
            if (action.equals("success")) {
                int start = Integer.parseInt(request.getParameter("start"));
                int end = Integer.parseInt(request.getParameter("end"));
                List<BookingModel> paymentList = (List<BookingModel>) SessionUtil.getInstance().getValue(request, "paymentList");
                if (paymentList != null) {
                    bookingService.insert(paymentList, start, end);
                    List<BookingModel> successfullPaymentList =  new ArrayList<>();
                    for (int i = end; i >= start; i--) {
                        successfullPaymentList.add(paymentList.get(i));
                        paymentList.remove(i);
                    }
                    Person person = (Person)SessionUtil.getInstance().getValue(request, "user");
                    sendPaymentSuccessMail(successfullPaymentList, person.getEmail());
                    SessionUtil.getInstance().putValue(request, "paymentList", paymentList);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isBooked(List<BookingModel> list, BookingModel newBooking) {
        for (BookingModel bookingModel : list) {
            if (bookingModel.getRoomModel().getRoomNo() == newBooking.getRoomModel().getRoomNo()) {
                return true;
            }
        }
        return false;
    }

    private void sendPaymentSuccessMail(List<BookingModel> list, String cusEmail) {
        BigDecimal total  = new BigDecimal(0);
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF-8\">");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        sb.append("<title>Booking Information</title>");
        sb.append("<style>");
        sb.append("body {");
        sb.append("    font-family: Arial, sans-serif;");
        sb.append("    line-height: 1.6;");
        sb.append("    margin: 0;");
        sb.append("    padding: 0;");
        sb.append("}");
        sb.append(".container {");
        sb.append("    max-width: 600px;");
        sb.append("    margin: auto;");
        sb.append("    padding: 20px;");
        sb.append("}");
        sb.append("h1 {");
        sb.append("    text-align: center;");
        sb.append("    color: #333;");
        sb.append("}");
        sb.append("table {");
        sb.append("    width: 100%;");
        sb.append("    border-collapse: collapse;");
        sb.append("    margin-bottom: 20px;");
        sb.append("}");
        sb.append("th, td {");
        sb.append("    border: 1px solid #ddd;");
        sb.append("    padding: 8px;");
        sb.append("    text-align: left;");
        sb.append("}");
        sb.append("th {");
        sb.append("    background-color: #f2f2f2;");
        sb.append("}");
        sb.append("</style>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<div class=\"container\">");
        sb.append("<h1>Booking Information</h1>");
        sb.append("<table>");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<th>Booking NO</th>");
        sb.append("<th>Hotel</th>");
        sb.append("<th>Address</th>");
        sb.append("<th>Booking Time</th>");
        sb.append("<th>Arrival Time</th>");
        sb.append("<th>Departure Time</th>");
        sb.append("<th>Price</th>");
        sb.append("</tr>");
        sb.append("</thead>");
        sb.append("<tbody>");
        int i = 1;
        for (BookingModel bookingModel : list) {
            sb.append("<tr>");
            sb.append("<td>"+(i++)+"</td>");
            sb.append("<td>"+bookingModel.getHotelModel().getName()+"</td>");
            sb.append("<td>"+bookingModel.getHotelModel().getAddress()+"</td>");
            sb.append("<td>"+bookingModel.getBookingTime()+"</td>");
            sb.append("<td>"+bookingModel.getArrivalTime()+"</td>");
            sb.append("<td>"+bookingModel.getDepartureTime()+"</td>");
            sb.append("<td>"+bookingModel.getRoomModel().getFormatedPrice()+"</td>");
            sb.append("</tr>");
            total = total.add(bookingModel.getRoomModel().getMoney());
        }
        sb.append("</tbody>");
        sb.append("</table>");
        sb.append("<h3>Total: "+NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(total)+" <span style=\"margin-left: 30px\"></span></h3>");
        sb.append("<p>Thank you for choosing our hotel. If you have any questions or need further assistance, please don't hesitate to contact us.</p>");
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");
        util.SendMail.sendMail(cusEmail, "Successfull Payment", sb.toString());
    }

}

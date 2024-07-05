/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.BookingModel;
import service.impli.supplier.ConfirmBooking;
import service.impli.supplier.ConfirmEmail;
import service.supplier.IConfirmBooking;
import service.supplier.IConfirmEmail;

/**
 *
 * @author danhv
 */
public class confirmBookingServlet extends HttpServlet {

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
            out.println("<title>Servlet confirmBookingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmBookingServlet at " + request.getContextPath() + "</h1>");
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
        short action = Short.parseShort(request.getParameter("action"));
        long bookingId = Long.parseLong(request.getParameter("bookingId"));
        List<BookingModel> list = (List<BookingModel>) request.getSession().getAttribute("list");
        IConfirmEmail ce = new ConfirmEmail();
        int id = Integer.parseInt(request.getParameter("id"));
        String customerEmail = list.get(id).getCustomerModel().getEmail();
        if (action == 1){
            String subject = "Confirmation: Your Room Booking at ".concat(list.get(id).getHotelModel().getName());
            String emailMessage = "Dear " + list.get(id).getCustomerModel().getFullname() + ",\n\n" +
                    "I am writing to confirm that your room booking at " + list.get(id).getHotelModel().getName() + " has been approved. We are delighted to accommodate you for your stay.\n\n" +
                    "Here are the details of your booking:\n\n" +
                    "Room Type: " + list.get(id).getRoomModel().getRoomTypeModel().getRoomType() + "\n" +
                    "Arrival Date: " + list.get(id).getArrivalTime() + "\n" +
                    "Departure Date: " + list.get(id).getDepartureTime() + "\n" +
                    "Price: " + list.get(id).getRoomModel().getMoney() + "\n\n" +
                    "We look forward to welcoming you to our hotel on " + list.get(id).getArrivalTime() + " and ensuring that your stay is comfortable and enjoyable. If you have any further questions or special requests, please feel free to reach out to us at " + list.get(id).getHotelModel().getPhone() + ".\n\n" +
                    "Thank you for choosing " + list.get(id).getHotelModel().getName() + ". We appreciate your business and hope to provide you with a memorable experience during your stay.\n\n" +
                    "Warm regards,\n\n" +
                    list.get(id).getHotelModel().getName();
            ce.sendMail(customerEmail, subject, emailMessage);
        } else if (action ==2) {
            String subject = "Confirmation of Room Booking Cancellation";
            String emailMessage = "Dear " + list.get(id).getCustomerModel().getFullname() + ",\n" +
"\n" +
"We hope this email finds you well.\n" +
"\n" +
"We regret to inform you that your room booking at " + list.get(id).getHotelModel().getName() + " has been cancelled by the hotel due to unforeseen circumstances.\n" +
"\n" +
"We understand that this may cause inconvenience and disappointment, and for that, we sincerely apologize. Please rest assured that we are actively working to resolve the situation and prevent similar occurrences in the future.\n" +
"\n" +
"We value your patronage and would like to express our gratitude for considering "+ list.get(id).getHotelModel().getName() +" for your accommodation needs. Should you have any questions or require further assistance, please do not hesitate to contact us at "+ list.get(id).getHotelModel().getPhone() +".\n" +
"\n" +
"Once again, we apologize for any inconvenience this cancellation may have caused and appreciate your understanding.\n" +
"\n" +
"Warm regards,\n" +
  list.get(id).getHotelModel().getName();    
            ce.sendMail(customerEmail, subject, emailMessage);
        }
        
        list.get(Integer.parseInt(request.getParameter("id"))).setStatus(action);
        request.getSession().removeAttribute("list");
        request.getSession().setAttribute("list", list);
        IConfirmBooking booking = new ConfirmBooking();
        booking.verifyBooking(action, bookingId);
        
        
        request.getRequestDispatcher("displayBookingServlet").forward(request, response);

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
        processRequest(request, response);
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

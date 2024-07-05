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
import java.util.Map;
import model.BookingModel;
import model.Contract;
import model.CustomerModel;
import model.HotelModel;
import service.impli.supplier.ConfirmContract;
import service.impli.supplier.ConfirmEmail;
import service.supplier.IConfirmContract;
import service.supplier.IConfirmEmail;

/**
 *
 * @author danhv
 */
public class confirmPendingContract extends HttpServlet {

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
            out.println("<title>Servlet confirmPendingContract</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmPendingContract at " + request.getContextPath() + "</h1>");
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
        List<Contract> listCC = (List<Contract>) request.getSession().getAttribute("listCC");
        Contract contract = (Contract)request.getSession().getAttribute("contract");
        IConfirmContract cc = new ConfirmContract();
        cc.verifyContract(action, contract.getHotelId(), contract.getCustomerId(), contract.getBookingTime());
        CustomerModel cus = cc.findCustomerById(contract.getCustomerId());
        Map<String,Integer> map = cc.countContractRoomType(Long.parseLong(String.valueOf(request.getSession().getAttribute("supplierId"))), contract.getHotelId(), contract.getCustomerId(), contract.getBookingTime());
        HotelModel hotel = cc.findHotelById(contract.getHotelId());
        BookingModel book = cc.findBooking(contract.getBookingTime(), contract.getHotelId());
        IConfirmEmail ce = new ConfirmEmail();
        
        String customerEmail = cus.getEmail();
        if (action == 5) {
            String subject ="Room Rental Agreement between "+ cus.getFullname() +" and "+ hotel.getName();
            String emailMessage = "Dear "+ cus.getFullname() +",\n" +
"\n" +
"This agreement is made effective between "+ cus.getFullname() +" (\"Tenant\") and "+ hotel.getName() +" (\"Landlord\"), collectively referred to as the \"Parties\".\n" +
"\n" +
"Property: Landlord agrees to rent the following rooms to Tenant at "+ hotel.getName() +":\n" +
"\n" +
"Room D: [Number of Room D] rooms (Price per room: $M)\n" +
"Room E: [Number of Room E] rooms (Price per room: $N)\n" +
"Term: The term of this agreement shall commence on "+ book.getArrivalTime() +" and end on "+ book.getDepartureTime() +".\n" +
"\n" +
"Rent: Tenant agrees to pay the total rent of $L for the duration of the lease term. Rent shall be paid in full upon check-in.\n" +
"\n" +
"Check-in and Check-out: Tenant shall check-in to the rented rooms at "+ hotel.getName() +" on "+ book.getArrivalTime() +" no later than "+ book.getArrivalTime() +". Tenant shall vacate and check-out of the rented rooms on "+ book.getDepartureTime() +" no later than "+ book.getDepartureTime() +".\n" +
"\n" +
"Use of Premises: Tenant agrees to use the rented rooms for residential purposes only and shall not sublet or assign the rooms without prior written consent from Landlord.\n" +
"\n" +
"Security Deposit: Tenant agrees to provide a security deposit to Landlord upon check-in.\n" +
"\n" +
"Cancellation: In the event of cancellation by Tenant, any deposits or payments made shall be forfeited according to the cancellation policy of Hotel B.\n" +
"\n" +
"Default: In the event of default by either party, the non-defaulting party shall have the right to pursue all remedies available under law.\n" +
"\n" +
"Governing Law: This Agreement shall be governed by and construed in accordance with the laws of Jurisdiction.\n" +
"\n" +
"Entire Agreement: This Agreement constitutes the entire understanding between the Parties with respect to the subject matter hereof and supersedes all prior agreements and understandings, whether written or oral.\n" +
"\n" +
"IN WITNESS WHEREOF, the Parties have executed this Agreement as of the date first above written.\n" +
"\n" +
"[Signature of Tenant]                               [Signature of Landlord]\n" +
"\n" +
"     "+ cus.getFullname() +"                                "+ hotel.getName() +"\n" +
"\n";
            ce.sendMail(customerEmail, subject, emailMessage);
        } else if (action == 6) {
            String subject = "Confirmation of Room Booking Cancellation";
            String emailMessage = "Dear "+ cus.getFullname() +",\n" +
"\n" +
"We hope this email finds you well.\n" +
"\n" +
"We regret to inform you that your room booking at "+ hotel.getName() +", with check-in time "+ book.getArrivalTime() +" and check-out time "+ book.getDepartureTime() +", has been cancelled by the hotel due to unforeseen circumstances.\n" +
"\n" +
"We understand that this may cause inconvenience and disappointment, and for that, we sincerely apologize. Please rest assured that we are actively working to resolve the situation and prevent similar occurrences in the future.\n" +
"\n" +
"We value your patronage and would like to express our gratitude for considering Hotel B for your accommodation needs. Should you have any questions or require further assistance, please do not hesitate to contact us at "+ hotel.getPhone()+ ".\n" +
"\n" +
"Once again, we apologize for any inconvenience this cancellation may have caused and appreciate your understanding.\n" +
"\n" +
"Warm regards, \n" +
hotel.getName();
            ce.sendMail(customerEmail, subject, emailMessage);
        }
        
        request.removeAttribute("listCC");
        request.removeAttribute("contract");
        listCC.remove(0);
        request.getSession().setAttribute("listCC", listCC);
        if (listCC != null && (listCC.size()>0) ) {
            contract = listCC.get(0);
            request.getSession().setAttribute("contract", contract);
            request.getSession().setAttribute("checkEmpty", 0);
            request.getRequestDispatcher("displayContractDetail").forward(request, response);
        } else {
             request.getSession().setAttribute("checkEmpty", 1);
             request.getRequestDispatcher("views/supplier/all-contract-pending.jsp").forward(request, response);
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

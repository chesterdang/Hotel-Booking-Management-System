/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.CustomerModel;
import model.FeedbackModel;
import service.Admin.ICustomerService;
import service.Admin.IFeedbackService;
import service.impli.Admin.CustomerService;
import service.impli.Admin.FeedbackService;
import util.SendMail;

/**
 *
 * @author quandba
 */
public class List_BB extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet List_BB</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet List_BB at " + request.getContextPath() + "</h1>");
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
        ICustomerService iCustomerService = new CustomerService();

        IFeedbackService iFeedbackService = new FeedbackService();
        List<FeedbackModel> list_item = iFeedbackService.finaAll();
        List<FeedbackModel> list = iFeedbackService.findBB(list_item);
       
        ArrayList<String> listbbb = new ArrayList<>();
        listbbb.add("chientranh");
        listbbb.add("chemnhau");

        final int quantityPerPage = 4;
        int index = 1;

        String searchInput = request.getParameter("search");
        int count = iFeedbackService.getTotalFeedback("");
        String sqlSearchWhere = "AND content LIKE \'%" + searchInput + "%'";
        
        list = iFeedbackService.pagingListFeedback("id", "ASC", index, quantityPerPage, "" ,listbbb);
        if (searchInput != null) {
            count = iFeedbackService.getTotalFeedback(sqlSearchWhere);

        }

        int endPage = count / quantityPerPage;
        if (count % quantityPerPage != 0) {
            endPage++;
        }

        CustomerModel cm = new CustomerModel();
        int idcu = (int) cm.getId();

        request.setAttribute("endPage", endPage);
        //
        String action = request.getParameter("action");
        //delete
        String delete = request.getParameter("delete");
        String unlock = request.getParameter("unlock");

        String id = request.getParameter("id");

        if (delete != null && delete.equals("1")) {
            if (!iFeedbackService.delete(Long.parseLong(id))) {
                request.getRequestDispatcher("views/Admin/error.jsp").forward(request, response);
            } else {
                if (SendMail.sendMail(iFeedbackService.findBy(Long.parseLong(id)).getCustomerModel().getEmail(), "Warning !", ""
                        + "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + " \n"
                        + "<head>\n"
                        + "    <meta charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Cảnh báo</title>\n"
                        + "    <link rel=\"stylesheet\" href=\"styles.css\">\n"
                        + "    <style>\n"
                        + "    .alert {\n"
                        + "        padding: 20px;\n"
                        + "        background-color: #f44336; /* Đỏ */\n"
                        + "        color: white;\n"
                        + "        margin-bottom: 15px;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .closebtn {\n"
                        + "        margin-left: 15px;\n"
                        + "        color: white;\n"
                        + "        font-weight: bold;\n"
                        + "        float: right;\n"
                        + "        font-size: 22px;\n"
                        + "        line-height: 20px;\n"
                        + "        cursor: pointer;\n"
                        + "        transition: 0.3s;\n"
                        + "    }\n"
                        + "    \n"
                        + "    .closebtn:hover {\n"
                        + "        color: black;\n"
                        + "    }\n"
                        + "    \n"
                        + "    </style>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "    <div class=\"alert\">\n"
                        + "        <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \n"
                        + "        <strong>Cảnh báo!</strong> Feedback của bạn (" + iFeedbackService.findBy(Long.parseLong(id)).getContent() + ") chứa nội dụng phản động hoặc mang tính phản động.\n"
                        + "    </div>\n"
                        + "</body>\n"
                        + "</html>")) {

                } else {
                    request.getRequestDispatcher("views/Admin/error.jsp").forward(request, response);
                }

            }
        }

        if (unlock != null && unlock.equals("1")) {
            if (!iFeedbackService.unlock(Long.parseLong(id))) {
                request.getRequestDispatcher("views/Admin/error.jsp").forward(request, response);
            }
        }

        if (action == null) {
            request.setAttribute("sortType", "numASC");
            list = iFeedbackService.pagingListFeedback("id", "ASC", 1, quantityPerPage, "", listbbb);
            request.setAttribute("list_BB", list);
            request.getRequestDispatcher("views/Admin/List_BB.jsp").forward(request, response);

        }
        if (action != null) {
            String indexPage = request.getParameter("index");
            if (indexPage != null) {

                index = Integer.parseInt(indexPage);
                if (index > endPage) {
                    index = 1;
                }
            }

            switch (action) {


                case "numASC":
//                    list = customerService.sortList("id", "ASC");

                    if (searchInput != null) {
                        list = iFeedbackService.pagingListFeedback("id", "ASC", index, quantityPerPage, sqlSearchWhere ,listbbb);
                    } else {
                        list = iFeedbackService.pagingListFeedback("id", "ASC", index, quantityPerPage, "",listbbb);
                    }
                    break;
                case "numDESC":
//                    list = customerService.sortList("id", "DESC");
                    list = iFeedbackService.pagingListFeedback("id", "DESC", index, quantityPerPage, "",listbbb);
                    if (searchInput != null) {
                        list = iFeedbackService.pagingListFeedback("id", "DESC", index, quantityPerPage, sqlSearchWhere,listbbb);
                    }
                    break;
                case "searchCustomer":
                    list = iFeedbackService.searchBy(request.getParameter("inputSearch"), "fullname");

                    break;

                default:
                    throw new AssertionError();
            }
        }

        request.setAttribute("searchValue", searchInput);
        request.setAttribute("sortType", action);
        request.setAttribute("index", index);

        request.setAttribute("list_BB", list);
        request.getRequestDispatcher("views/Admin/List_BB.jsp").forward(request, response);
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

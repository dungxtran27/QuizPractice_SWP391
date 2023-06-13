package controller;

import DAO.subjectListDAO;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.subject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SubjectList", urlPatterns = {"/subject-list"})
public class SubjectList extends HttpServlet {

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
            out.println("<title>Servlet SubjectList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectList at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        final int PAGE_SIZE = 3;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int totalSearch = new subjectListDAO().getTotalSubject();
        int totalPage = totalSearch / PAGE_SIZE;
        if (totalSearch % PAGE_SIZE != 0) {
            totalPage += 1;
        }

        subjectListDAO subjectListDAO = new subjectListDAO();
        List<subject> listSubjects = subjectListDAO.getAllSubject();
        request.setAttribute("listSubjects", listSubjects);
        List<subject> listSubjectsByPagging = subjectListDAO.getListSubjectsByPagging(page, PAGE_SIZE);
        request.setAttribute("listSubjectsByPagging", listSubjectsByPagging);

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("search_url", "search_subject");
        request.setAttribute("pagination_url", "subject-list?");
        request.getRequestDispatcher("subject.jsp").forward(request, response);
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
        //processRequest(request, response);
        final int PAGE_SIZE = 3;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int totalSearch = new subjectListDAO().getTotalSubject();
        int totalPage = totalSearch / PAGE_SIZE;
        if (totalSearch % PAGE_SIZE != 0) {
            totalPage += 1;
        }

        subjectListDAO subjectListDAO = new subjectListDAO();
        List<subject> listSubjects;
        String sortBy = request.getParameter("sort");
        if (sortBy != null && sortBy.equals("createDate")) {
            listSubjects = subjectListDAO.sortByDate();
        } else {
            listSubjects = subjectListDAO.getAllSubject();
        }
        List<subject> listSubjectsByPagging;
        if (sortBy != null && sortBy.equals("createDate")) {
            listSubjectsByPagging = subjectListDAO.getListSubjectsByPaggingAndSort(page, PAGE_SIZE, "createDate");
        } else {
            listSubjectsByPagging = subjectListDAO.getListSubjectsByPagging(page, PAGE_SIZE);
        }
        request.setAttribute("listSubjects", listSubjects);

        request.setAttribute("listSubjectsByPagging", listSubjectsByPagging);

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("search_url", "search_subject");
        request.setAttribute("pagination_url", "subject-list?");
        request.getRequestDispatcher("subject.jsp").forward(request, response);
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

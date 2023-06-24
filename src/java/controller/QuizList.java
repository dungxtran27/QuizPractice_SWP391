/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.QuizDAO;
import DAO.subjectListDAO;
import DAO.typeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.quiz;
import model.subject;
import model.Type;

/**
 *
 * @author Admin
 */
@WebServlet(name = "QuizList", urlPatterns = {"/quiz-list"})
public class QuizList extends HttpServlet {

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
            out.println("<title>Servlet QuizList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizList at " + request.getContextPath() + "</h1>");
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
        PrintWriter pr = response.getWriter();
        QuizDAO quiz1 = new QuizDAO();
        final int PAGE_SIZE_6 = 6;
        int page = 1;
        String pageStr = request.getParameter("page");

        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        
          int totalSearch = quiz1.getTotalQuiz();
       int totalPage = totalSearch / PAGE_SIZE_6;
        if (totalSearch % PAGE_SIZE_6 != 0) {
            totalPage += 1;
        }

        
        
          List<subject> listSubjects = new subjectListDAO().getAllSubject();
        List<Type> listTypeQuizes = new typeDAO().getListTypeQuizes();
         List<quiz> listQuizzesByPagging = quiz1.getListQuizzesByPagging(page, PAGE_SIZE_6);
       // int listQuizzesByPagging = tuanvm.getListQuizzesByPagging(page, PAGE_SIZE_6);
        int test=quiz1.test(1, 3);
        request.setAttribute("listSubjects", listSubjects);
        request.setAttribute("listTypeQuizes", listTypeQuizes);
        request.getSession().setAttribute("listQuizzesByPagging", listQuizzesByPagging);
       
        
        
      
      

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pagination_url", "quiz-list?");
        pr.print(listQuizzesByPagging);
        pr.print(test);
        pr.print(totalSearch);
        request.getRequestDispatcher("QuizList.jsp").forward(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

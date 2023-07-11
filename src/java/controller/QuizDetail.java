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
@WebServlet(name="QuizDetail", urlPatterns={"/quiz-detail"})
public class QuizDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet QuizDetail</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizDetail at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        int message = Integer.parseInt(request.getParameter("message"));

        switch (action) {
            case "edit-quiz":
                int quizId = Integer.parseInt(request.getParameter("quizId"));
                quiz quizByQuizId = new QuizDAO().getQuizByQuizId(quizId);

                request.setAttribute("quizByQuizId", quizByQuizId);
                request.getSession().setAttribute("quizId", quizId);
                request.getSession().setAttribute("action", "edit-quiz");
                break;

            case "add-quiz":
                request.getSession().setAttribute("action", "add-quiz");
                break;
        }

        List<subject> listSubjects = new subjectListDAO().getAllSubject();
        List<Type> listTypeQuizes = new typeDAO().getListTypeQuizes();

        request.setAttribute("listSubjects", listSubjects);
        request.setAttribute("listTypeQuizes", listTypeQuizes);
        if (message == 0) {
            request.getSession().setAttribute("messageQuiz", "");
        }

        request.getRequestDispatcher("QuizDetail.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        int message = Integer.parseInt(request.getParameter("message"));

        switch (action) {
            case "edit-quiz":
                int quizId = Integer.parseInt(request.getParameter("quizId"));
                quiz quizByQuizId = new QuizDAO().getQuizByQuizId(quizId);

                request.setAttribute("quizByQuizId", quizByQuizId);
                request.getSession().setAttribute("quizId", quizId);
                request.getSession().setAttribute("action", "edit-quiz");
                break;

            case "add-quiz":
                request.getSession().setAttribute("action", "add-quiz");
                break;
        }

        List<subject> listSubjects = new subjectListDAO().getAllSubject();
        List<Type> listTypeQuizes = new typeDAO().getListTypeQuizes();

        request.setAttribute("listSubjects", listSubjects);
        request.setAttribute("listTypeQuizes", listTypeQuizes);
        if (message == 0) {
            request.getSession().setAttribute("messageQuiz", "");
        }

        request.getRequestDispatcher("QuizDetail.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

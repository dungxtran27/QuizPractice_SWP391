/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.QuestionDAO;
import DAO.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.quiz;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditQuiz", urlPatterns = {"/edit-quiz"})
public class EditQuiz extends HttpServlet {

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
            out.println("<title>Servlet EditQuiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditQuiz at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        int quizId = (int) request.getSession().getAttribute("quizId");
        String title = request.getParameter("title");
        int subId = Integer.parseInt(request.getParameter("subId"));
        String description = request.getParameter("description");
        String level = request.getParameter("level");
        int durarion = Integer.parseInt(request.getParameter("duration"));
        Float rate = Float.parseFloat(request.getParameter("rate"));
        String typeId = request.getParameter("typeId");
        int totalQues = Integer.parseInt(request.getParameter("totalQues"));
        int attempt = Integer.parseInt(request.getParameter("attempt"));

        quiz quizByQuizId = new QuizDAO().getQuizByQuizId(quizId);
        boolean checkExistDoQuiz = new QuizDAO().checkExistDoQuiz(quizId);
        int totalQuesExist = new QuestionDAO().getTotalQuestionExist(quizId, subId);

        if (quizByQuizId.getTitle().equalsIgnoreCase(title)
                && quizByQuizId.getSubId() == subId
                && quizByQuizId.getDescription().equalsIgnoreCase(description)
                && quizByQuizId.getLevel().equalsIgnoreCase(level)
                && quizByQuizId.getDuration() == durarion
                && quizByQuizId.getRate() == rate
                ) {
            if (totalQues > 30) {
                request.getSession().setAttribute("messageQuiz", "Total Question must no more 30!!!");
                request.getSession().setAttribute("CheckEditQuiz", "false");
                response.sendRedirect("quiz-detail?quizId=" + quizId + "&action=edit-quiz&message=1");
            } else if (totalQuesExist > totalQues) {
                request.getSession().setAttribute("messageQuiz", "Total Question must more than " + totalQuesExist + "!!!");
                request.getSession().setAttribute("CheckEditQuiz", "false");
                response.sendRedirect("quiz-detail?quizId=" + quizId + "&action=edit-quiz&message=1");
            } else if (totalQues < 30 && totalQuesExist < totalQues) {
                new QuizDAO().updateQuiz(title, subId, description, durarion, level, rate, typeId, quizId, totalQues, attempt);
                request.getSession().setAttribute("CheckEditQuiz", "true");
                request.getSession().setAttribute("messageQuiz", "Edit Successful!!!");
                response.sendRedirect("quiz-detail?quizId=" + quizId + "&action=edit-quiz&message=1");
            }
        } else {
            request.getSession().setAttribute("messageQuiz", "Edit Error: You can only change Total Ques!!!");
            request.getSession().setAttribute("CheckEditQuiz", "false");
            response.sendRedirect("quiz-detail?quizId=" + quizId + "&action=edit-quiz&message=1");
        }

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

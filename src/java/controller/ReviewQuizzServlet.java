/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AnswerDAO;
import DAO.QuestionDAO;
import DAO.QuizDAO;
import model.*;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author dungmuahahaha
 */
@WebServlet(name = "ReviewQuizzServlet", urlPatterns = {"/ReviewQuizzServlet"})
public class ReviewQuizzServlet extends HttpServlet {

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
            out.println("<title>Servlet ReviewQuizzServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewQuizzServlet at " + request.getContextPath() + "</h1>");
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
         String url = "";
        try {
            int quizzId = Integer.parseInt(request.getParameter("quizzId"));
            int subId = Integer.parseInt(request.getParameter("subId"));
            int attempt = Integer.parseInt(request.getParameter("attempt"));
            HttpSession session = request.getSession();

            QuizDAO quizDAO = new QuizDAO();
            QuestionDAO questionDAO = new QuestionDAO();
            AnswerDAO answerDAO = new AnswerDAO();
            User account = (User) session.getAttribute("currUser");
            if (account != null) {

                boolean isDoQUizz = quizDAO.isDoQuizz(account.getUserid(), quizzId);

                if (isDoQUizz) {

                    int questionTime = quizDAO.getQuizByQuizId(quizzId).getDuration();

                    HashMap<Question, List<Answer>> quizz = new HashMap<>();
                    List<Question> questions = questionDAO.getQuestionByQuizId(quizzId);
                    for (Question question : questions) {
                        List<Answer> answers = answerDAO.getAnswerByQuestionId(question.getQuestionId());
                        for (Answer answer : answers) {
                            if (quizDAO.checkUserIsChoosen(answer.getAnswerId(), quizzId, account.getUserid(), attempt)) {
                                answer.setUserCheck(true);
                            }
                        }
                        quizz.put(question, answers);
                    }
                    session.setAttribute("REVIEW_QUIZZ", quizz);

                    request.setAttribute("quizzId", quizzId);
                    quiz quiz = quizDAO.getQuizByQuizId(quizzId);
                    quiz.setTotalQues(quizz.size());
                    quiz_point quizzPoint = quizDAO.getQuizPoint(account.getUserid(), quizzId, attempt);
                    request.setAttribute("QUIZZ_POINT", quizzPoint);
                    request.setAttribute("QUIZZ", quiz);
                    request.setAttribute("subId", subId);

                    url = "reviewQuizz.jsp";
                } else {
                    url = "lesson-quiz?subId=" + subId + "&action=get";
                }
            } else {
                url = "SignIn.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;


import DAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import model.Answer;
import model.AnswerDetail;
import model.Question;
import model.*;

/**
 *
 * @author Admin
 */
@WebServlet(name="QuizHandle", urlPatterns={"/QuizHandle"})
public class QuizHandle extends HttpServlet {
   
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String method = request.getParameter("method");
            if (method.equals("get")) {
                doGet(request, response);
            } else {
                doPost(request, response);
            }
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
        //processRequest(request, response);
        String url = "";
        try {
            int quizzId = Integer.parseInt(request.getParameter("quizzId"));
            int subId = Integer.parseInt(request.getParameter("subId"));

            HttpSession session = request.getSession();

            QuizDAO quizDAO = new QuizDAO();
            QuestionDAO questionDAO = new QuestionDAO();
            AnswerDAO answerDAO = new AnswerDAO();

            User user = (User) session.getAttribute("currUser");

            if (user == null) {
                url = "SignIn.jsp";
            } else {

                quiz quiz = quizDAO.getQuizByQuizId(quizzId);
                quiz_point quizzPoint = quizDAO.getQuizPointAttempt(user.getUserid(), quizzId);

                int maxAttemp = quiz.getAttempt(); //get The max attempt of quizz
                int lastAttempt = 0;
                if (quizzPoint == null) { //Have not Attemp

                } else {
                    lastAttempt = quizzPoint.getAttempt(); //get The number user have been Attempt
                }

                boolean check = true;
                if (maxAttemp <= lastAttempt) { //user attempt max
                    check = false;
                }

                if (check) {

                    int questionTime = quizDAO.getQuizByQuizId(quizzId).getDuration();

                    HashMap<Question, List<Answer>> quizz = new HashMap<>();
                    List<Question> questions = questionDAO.getQuestionByQuizId(quizzId);
                    for (Question question : questions) {
                        quizz.put(question, answerDAO.getAnswerByQuestionId(question.getQuestionId()));
                    }
                    session.setMaxInactiveInterval(questionTime * 60);

                    session.setAttribute("TIMER", questionTime);
                    session.setAttribute("DO_QUIZZ", quizz);

                    request.setAttribute("quizzId", quizzId);
//                Quiz quiz = quizDAO.getQuizByQuizId(quizzId);
                    quiz.setTotalQues(quizz.size());
                    request.setAttribute("QUIZZ", quiz);
                    request.setAttribute("attempt", lastAttempt);
                    request.setAttribute("subId", subId);
                    url = "DoQuizz.jsp";
             }
//else {
//                    request.setAttribute("WARNING", "You have done this quizz!");
//                    url = "subject-list?subId=" + subId + "&action=get";
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

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
        //processRequest(request, response);
        String url = "";
        try {
            int correct = 0;
            //
            String[] questionIds = request.getParameterValues("questionId");
            AnswerDAO answerDAO = new AnswerDAO();
            int quizId = Integer.parseInt(request.getParameter("quizzId"));
            int subId = Integer.parseInt(request.getParameter("subId"));

            int attempt = Integer.parseInt(request.getParameter("attempt"));
            attempt++; //Have been do quizz the attempt will increasing
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currUser");
            QuizDAO quizDAO = new QuizDAO();
            QuestionDAO questionDAO = new QuestionDAO();

            if (user == null) {
                url = "SignIn.jsp";
            } else {
                boolean isDoQuizz = quizDAO.isDoQuizz(user.getUserid(), quizId);
//                quizDAO.deleteAnswerDetail(account.getUserid(), quizId);

                float pointForEachQuestion = (float) 10 / questionIds.length;

                float multipleScore = 0;

                for (String questionId : questionIds) {
                    //Check qquestion is Multiple choice;
                    if (questionDAO.getQuestionById(Integer.parseInt(questionId)).isIsMultipleChoice()) {
                        if (request.getParameter("answer_" + questionId) == null) {

                        } else {
                            String[] answerIds = request.getParameterValues("answer_" + questionId);
                            int totalCorrectAnswer = answerDAO.getTotalCorrectAnswer(Integer.parseInt(questionId));

                            float pointForMul = pointForEachQuestion / totalCorrectAnswer;
                            int mulCorrect = 0; //1
                            for (String answerId : answerIds) {
                                AnswerDetail answerDetail
                                        = new AnswerDetail(0,
                                                Integer.parseInt(questionId),
                                                Integer.parseInt(answerId),
                                                user.getUserid(),
                                                quizId,
                                                attempt);
                                quizDAO.insertAnswerDetail(answerDetail);
                                if (answerIds.length > totalCorrectAnswer) {

                                } else {
                                    if (answerDAO.checkAnswerIsCorrect(Integer.parseInt(answerId))) {
                                        mulCorrect++;
                                        multipleScore += pointForMul * mulCorrect;
                                    }
                                }

                            }
                        }

                    } else {//Not Multiple Choice

                        if (request.getParameter("answer_" + questionId) == null) {

                        } else {
                            //insert the answerDetail;
                            AnswerDetail answerDetail
                                    = new AnswerDetail(0,
                                            Integer.parseInt(questionId),
                                            Integer.parseInt(request.getParameter("answer_" + questionId)),
                                            user.getUserid(),
                                            quizId,
                                            attempt);
                            quizDAO.insertAnswerDetail(answerDetail);
                            if (answerDAO.checkAnswerIsCorrect(Integer.parseInt(request.getParameter("answer_" + questionId)))) {
                                correct++;
                            }
                        }
                    }
                }
                float point = pointForEachQuestion * correct;
                point += multipleScore;
                float pointPercent = point * 10;
                float numQuesTrueFloat = (point / 10) * questionIds.length;
                int numQuesTrue = 0;
                if (numQuesTrueFloat % 1 == 0) {
                    numQuesTrue = (int) numQuesTrueFloat;
                } else {
                    numQuesTrue = (int) (numQuesTrueFloat / 1);
                }

//            }
                // 0.2
                quiz_point quizzPoint = new quiz_point(1, user.getUserid(), point, quizId, attempt);
                if (isDoQuizz) {
                    quizDAO.insertQuizPoint(quizzPoint, pointPercent, numQuesTrue);
                } else {
                    quizDAO.insertQuizPoint(quizzPoint, pointPercent, numQuesTrue);
                }

                request.setAttribute("SCORE", point);
                request.setAttribute("attempt", attempt);
                request.setAttribute("subId", subId);
                request.setAttribute("quizzId", quizId);
                url = "scorePage.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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

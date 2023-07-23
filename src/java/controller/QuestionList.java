/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.QuestionDAO;
import DAO.subjectListDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Question;
import model.subject;

/**
 *
 * @author dungmuahahaha
 */
@WebServlet(name = "QuestionList", urlPatterns = {"/QuestionList"})
public class QuestionList extends HttpServlet {

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
            out.println("<title>Servlet QuestionList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionList at " + request.getContextPath() + "</h1>");
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
        PrintWriter pr = response.getWriter();
        try {
            int quizId = Integer.parseInt(request.getParameter("quizzId"));

            final int PAGE_SIZE = 7;
            int page = 1;
            String pageStr = request.getParameter("page");
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }
            QuestionDAO qd = new QuestionDAO();
            subjectListDAO sd = new subjectListDAO();
            List<subject> quesList = sd.getAllSubject();
            int totalSearch = qd.getTotalQuestionExist(quizId);
            int totalPage = totalSearch / PAGE_SIZE;
            if (totalSearch % PAGE_SIZE != 0) {
                totalPage += 1;
            }
            QuestionDAO questionDao = new QuestionDAO();
            // request.getSession().setAttribute("listQuestion", questionDao.getAllQuestion());
            ArrayList<Question> listQuestionByPagging = questionDao.getQuestionByQuizIdAndPagging(quizId, page, PAGE_SIZE);
            request.setAttribute("listQuestion", listQuestionByPagging);
            request.setAttribute("listSubject", quesList);
            for (Question q : listQuestionByPagging) {
                pr.print(q.getContent() + " ");

            }
            request.getSession().setAttribute("page", page);
            request.getSession().setAttribute("quizzId", quizId);
            request.getSession().setAttribute("totalPage", totalPage);
            request.getSession().setAttribute("search_url", "search-question?quizzId="+quizId);
            request.getSession().setAttribute("pagination_url", "QuestionList?quizzId="+quizId+"&");
           // pr.print(listQuestionByPagging.get(1).getContent());
           // pr.print(totalSearch);
           // pr.print(quesList.size());
            pr.print(totalPage);
            
            pr.print(quesList.size());
            request.getRequestDispatcher("QuestionList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}

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
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "QuizList", urlPatterns = {"/quiz-list"})
public class QuizList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        List<quiz> listQuizzesByPaggingAd = quiz1.getListQuizzesByPaggingAdmin(page, PAGE_SIZE_6);

        List<quiz> listQuizzesByPagging = quiz1.getListQuizzesByPagging(page, PAGE_SIZE_6);
        request.getSession().setAttribute("listQuizzesByPagging", listQuizzesByPagging);
        request.getSession().setAttribute("listQuizzesByPaggingAd", listQuizzesByPaggingAd);

        request.setAttribute("listSubjects", listSubjects);
        request.setAttribute("listTypeQuizes", listTypeQuizes);

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pagination_url", "quiz-list?");

        request.getRequestDispatcher("QuizList.jsp").forward(request, response);
    }

}

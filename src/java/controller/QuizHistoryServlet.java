/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.QuizPointDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import model.User;
import model.quiz_point;

/**
 *
 * @author dungmuahahaha
 */
public class QuizHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pr = response.getWriter();

        User currUser = (User) request.getSession().getAttribute("currUser");
        QuizPointDAO qpd = new QuizPointDAO();
        ArrayList<quiz_point> qplist = new ArrayList<>();
       
       

        if (currUser == null) {
            
            response.sendRedirect("SignIn.jsp");
        } else {
             final int page_5 = 5;
        int page = 1;
        String pageStr = request.getParameter("page");

        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        int totalSearch = qpd.getTotalQuiz2(currUser.getUserid());
        int totalPage = totalSearch / page_5;
        if (totalSearch % page_5 != 0) {
            totalPage += 1;
        }
            qplist = qpd.getQuizHistory(currUser.getUserid(), page, page_5);
            request.getSession().setAttribute("qplist", qplist);
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("pagination_url", "QuizHistoryServlet?");
            request.getRequestDispatcher("userPage.jsp").forward(request, response);

        }

        //  request.setAttribute("Testlist", "muahaha");
    }

}

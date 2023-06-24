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
        ArrayList<quiz_point> qplist =new ArrayList<>() ;
      //  int qptest=0;
        if (currUser == null) {
            response.sendRedirect("SignIn.jsp");
        } else {
                qplist= qpd.getQuizHistory(currUser.getUserid());
            request.setAttribute("qplist", qplist);
          request.getRequestDispatcher("userPage.jsp").forward(request, response);

        }
      //  request.setAttribute("Testlist", "muahaha");

    
              

    }
    
}

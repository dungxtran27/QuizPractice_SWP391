/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import DAO.userDAO;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

@WebServlet(urlPatterns = {"/login"})
public class LogInServlet extends HttpServlet {

    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        request.getSession().setAttribute("currentYear", currentYear);
        PrintWriter pr = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        User currUser;
        userDAO t = new userDAO();

        currUser = t.getUser(email, pass);
        request.getSession().setAttribute("currUser", currUser);

        String logResult = "";

        if (currUser == null) {
            logResult = "Sorry, username and/or password are/ is invalid!";
             request.setAttribute("err", logResult);
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);

        } else {
            logResult = "Login is successful!";
        request.getRequestDispatcher("Home.jsp").forward(request, response);

        }

       
        pr.print(email + " " + pass);
        pr.print(logResult);

    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.userDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author admin
 */
@WebServlet(name = "signUp", urlPatterns = {"/signUp"})
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        
        userDAO dao = new userDAO();
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");
        
        RequestDispatcher dispatcher = null;

         //check email format
        if(!dao.checkEmail(email)){
            request.setAttribute("status", "Invalid Email");
            dispatcher = request.getRequestDispatcher("SignUp.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //check email exist
        if(dao.checkEmailExist(email)){
            request.setAttribute("status", "Email already exists");
            dispatcher = request.getRequestDispatcher("SignUp.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // check phonenumber valid
        if(!dao.checkPhonenumber(phone)){
            request.setAttribute("status", "Invalid Phonenumber");
            dispatcher = request.getRequestDispatcher("SignUp.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //check valid cua username
        if(dao.checkUsername(username)){
            request.setAttribute("status", "Username has already existed");
            dispatcher = request.getRequestDispatcher("SignUp.jsp");
            dispatcher.forward(request, response);
            return;
        }

        //check valid cua password
        if(!dao.checkPassword(pass)){
            request.setAttribute("status", "Invalid Password");
            dispatcher = request.getRequestDispatcher("SignUp.jsp");
            dispatcher.forward(request, response);
            return;
        }

        //check password repeat
        if(!repass.equals(pass)){
            request.setAttribute("status", "Password Repeat has to be similar to Password");
            dispatcher = request.getRequestDispatcher("SignUp.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
       
        
        //Create new user
        User user = new User();
        user.setFullname(fullname);
       // user.setUsername(username);
        user.setPassword(pass);
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        
        dao.signUp(user);
       // pr.print(user.getEmail());
        
        request.setAttribute("status", "successfully");
        dispatcher = request.getRequestDispatcher("SignIn.jsp");
        dispatcher.forward(request, response);
        
        
    }

    
}

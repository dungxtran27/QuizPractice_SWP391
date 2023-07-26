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
 * @author dungmuahahaha
 */
@WebServlet(name = "addTeacher", urlPatterns = {"/add-teacher"})
public class addTeacher extends HttpServlet {

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
            out.println("<title>Servlet addTeacher</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addTeacher at " + request.getContextPath() + "</h1>");
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

        userDAO dao = new userDAO();
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String address = request.getParameter("address");

        RequestDispatcher dispatcher = null;

       
//
//        //check email exist
        if (dao.checkEmailExist(email)) {
            request.getSession().setAttribute("statusTeacher", "Email already exists");
            request.getSession().setAttribute("checkSuccessTeacher", "false");
            response.sendRedirect("addTeacher.jsp");
//
//            dispatcher = request.getRequestDispatcher("addTeacher.jsp");
//            dispatcher.forward(request, response);
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
        user.setAddress(address);

        dao.addTeacher(user);
        // pr.print(user.getEmail());
        request.getSession().setAttribute("checkSuccessTeacher", "true");

        request.getSession().setAttribute("statusTeacher", "add teacher successfully");
//      
//        dispatcher = request.getRequestDispatcher("user-list");
//        
//        dispatcher.forward(request, response);
       response.sendRedirect("user-list");
    }

}

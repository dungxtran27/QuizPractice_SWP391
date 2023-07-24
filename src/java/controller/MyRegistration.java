/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.RegistrationDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import model.RegistrationDTO;
import model.User;

/**
 *
 * @author admin
 */
@WebServlet(name = "MyRegistration", urlPatterns = {"/my-registration"})
public class MyRegistration extends HttpServlet {

    private final String MYREGISTRATION_PAGE = "MyRegistration.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String url = "";
        String msg = "";
        HttpSession session = request.getSession();
        //Is Login
        if (session.getAttribute("currUser") == null) {
           request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        }//Logined
        else {
            try {

                RegistrationDAO registrationDAO = new RegistrationDAO();
                User user = (User) session.getAttribute("currUser");
                List<RegistrationDTO> rlist = registrationDAO.getRegistrationByAccount(user.getUserid());
                request.setAttribute("rlist", rlist);
                request.setAttribute("testmua1", "test");
                pr.print(rlist.size());
                for(RegistrationDTO r : rlist)
                    pr.print("["+r.getRegisId()+"}");
                
                pr.print(user.getUserid());
               
            

        }catch (Exception e) {
            log("Error at MyRegistrationServlet: " + e.getMessage());
        }
        request.getRequestDispatcher("MyRegistration.jsp").forward(request, response);

    }}

    
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

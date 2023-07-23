/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Question;

import DAO.QuestionDAO;
import DAO.subjectListDAO;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author 84969
 */
@WebServlet(name = "FilterController", urlPatterns = {"/FilterController"})
public class FilterQuestionController extends HttpServlet {

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
        PrintWriter pr = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
//            HttpSession session = request.getSession();           
//            Account a = (Account) session.getAttribute("account");
            int status = Integer.parseInt(request.getParameter("statusFilter"));
            int subjectId = Integer.parseInt(request.getParameter("subjectIdFilter"));
            int quizId = Integer.parseInt(request.getParameter("quizId"));
           
            ArrayList<Question> questionList = null;
            if(request.getParameter("statusFilter") != null){
                questionList = new QuestionDAO().getQuestionByStatus(status,subjectId,quizId);
            if (!questionList.isEmpty()) {
                            request.setAttribute("listQuestion", questionList);
                        } else {
                            request.setAttribute("message", "Not have question!");
                        }
            } 
            
            request.setAttribute("status", status);
            request.setAttribute("subjectId", subjectId);
             request.setAttribute("listSubject", new subjectListDAO().getAllSubject());
            
            
            
            
            pr.println(questionList.size());
            request.getRequestDispatcher("QuestionList.jsp").forward(request, response);
            
        }catch (Exception e) {
            e.printStackTrace();
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

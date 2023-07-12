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

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchQuiz", urlPatterns = {"/search-quiz"})
public class SearchQuiz extends HttpServlet {

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
        String typeId = request.getParameter("typeId");
        int subId = Integer.parseInt(request.getParameter("subId"));
        String keyword = request.getParameter("keyword");
        PrintWriter pr = response.getWriter();
        final int PAGE_SIZE_6 = 6;
        int page = 1;
        String pageStr = request.getParameter("page");

        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int totalSearch = 0;
        int totalPage = 0;
        if (subId == 0 && typeId.equalsIgnoreCase("Q0")) {
            totalSearch = new QuizDAO().getTotalQuizOnlySearch(keyword);
            totalPage = totalSearch / PAGE_SIZE_6;
            if (totalSearch % PAGE_SIZE_6 != 0) {
                totalPage += 1;
            }

            List<quiz> listQuizzesByPagging = new QuizDAO().getListQuizzesBySearchAndPagging(page, PAGE_SIZE_6, keyword);
            List<quiz> listQuizzesByPaggingAd = new QuizDAO().getListQuizzesBySearchAndPaggingAd(page, PAGE_SIZE_6, keyword);

            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.getSession().setAttribute("listQuizzesByPagging", listQuizzesByPagging);
            request.getSession().setAttribute("listQuizzesByPaggingAd", listQuizzesByPaggingAd);
        } else if (subId != 0 && typeId.equalsIgnoreCase("Q0")) {
            totalSearch = new QuizDAO().getTotalQuizBySubIdAndSearch(keyword, subId);
            totalPage = totalSearch / PAGE_SIZE_6;
            if (totalSearch % PAGE_SIZE_6 != 0) {
                totalPage += 1;
            }

            List<quiz> listQuizzesByPagging = new QuizDAO().getListQuizzesBySubIdAndSearchAndPagging(page, PAGE_SIZE_6, keyword, subId);
            List<quiz> listQuizzesByPaggingAd = new QuizDAO().getListQuizzesBySubIdAndSearchAndPaggingAd(page, PAGE_SIZE_6, keyword, subId);

            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.getSession().setAttribute("listQuizzesByPagging", listQuizzesByPagging);
            request.getSession().setAttribute("listQuizzesByPaggingAd", listQuizzesByPaggingAd);
        } else if (subId == 0 && typeId.equalsIgnoreCase("Q0") == false) {
            totalSearch = new QuizDAO().getTotalQuizByTypeIdAndSearch(keyword, typeId);
            totalPage = totalSearch / PAGE_SIZE_6;
            if (totalSearch % PAGE_SIZE_6 != 0) {
                totalPage += 1;
            }

            List<quiz> listQuizzesByPagging = new QuizDAO().getListQuizzesByTypeIdSearchAndPagging(page, PAGE_SIZE_6, keyword, typeId);
            List<quiz> listQuizzesByPaggingAd = new QuizDAO().getListQuizzesByTypeIdSearchAndPaggingAd(page, PAGE_SIZE_6, keyword, typeId);

            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.getSession().setAttribute("listQuizzesByPagging", listQuizzesByPagging);
            request.getSession().setAttribute("listQuizzesByPaggingAd", listQuizzesByPaggingAd);
        } else if (subId != 0 && typeId.equalsIgnoreCase("Q0") == false) {
            totalSearch = new QuizDAO().getTotalQuizByTypeIdAndSubIdAndSearch(keyword, subId, typeId);
            pr.print("new"+totalSearch);
            totalPage = totalSearch / PAGE_SIZE_6;
            if (totalSearch % PAGE_SIZE_6 != 0) {
                totalPage += 1;
            }

            List<quiz> listQuizzesByPagging = new QuizDAO().getListQuizzesBySubIdAndTypeIdAndSearchAndPagging(page, PAGE_SIZE_6, keyword, subId, typeId);
            List<quiz> listQuizzesByPaggingAd = new QuizDAO().getListQuizzesBySubIdAndTypeIdAndSearchAndPaggingAd(page, PAGE_SIZE_6, keyword, subId, typeId);

            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.getSession().setAttribute("listQuizzesByPagging", listQuizzesByPagging);
            request.getSession().setAttribute("listQuizzesByPaggingAd", listQuizzesByPaggingAd);
        }

        List<subject> listSubjects = new subjectListDAO().getAllSubject();
        List<Type> listTypeQuizes = new typeDAO().getListTypeQuizes();

        request.setAttribute("typeId", typeId);
        request.setAttribute("subId", subId);
        request.setAttribute("keyword", keyword);
        request.setAttribute("listSubjects", listSubjects);
        request.setAttribute("listTypeQuizes", listTypeQuizes);
        request.setAttribute("pagination_url", "search-quiz?typeId=" + typeId + "&subId=" + subId + "&keyword=" + keyword + "&");

         request.getRequestDispatcher("QuizList.jsp").forward(request, response);
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

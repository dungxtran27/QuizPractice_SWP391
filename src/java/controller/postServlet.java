/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.BlogDAO;
import DAO.postDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Post;

/**
 *
 * @author dungmuahahaha
 */
public class postServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String postId, thumbnail, userId, categoryBlogId, content, created_date, edit_date, status, brifInfor, title, postFiled;
        Date cDate, eDate;
        int pId, uId, cBlogId, pFiled;
        boolean stats;
        
        
        postId = request.getParameter("postId");
        userId = request.getParameter("userId");
        created_date = request.getParameter("created_date");
        edit_date = request.getParameter("edit_date");
        thumbnail = request.getParameter("thumbnail");
        categoryBlogId = request.getParameter("categoryBlogId");
        content = request.getParameter("content");
        status = request.getParameter("status");
        brifInfor = request.getParameter("brifInfor");
        title = request.getParameter("title");
        postFiled = request.getParameter("postFiled");
       
        
        if (postId != null && userId!=null) {
            pId = Integer.parseInt(postId);
            uId = Integer.parseInt(userId);
            cBlogId = Integer.parseInt(categoryBlogId);
            pFiled = Integer.parseInt(postFiled);
            eDate = Date.valueOf(edit_date);
            cDate = Date.valueOf(created_date);
            stats = Boolean.valueOf(status);

            Post p = new Post(pId, thumbnail, uId, cBlogId, content, eDate, edit_date, stats, brifInfor, title, pFiled);
            request.setAttribute("p", p);

            request.getRequestDispatcher("post.jsp").forward(request, response);
        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Blog;
import DAO.BlogDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BlogListController extends HttpServlet {

   
    

   
    @Override
   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
     
           
        BlogDAO bd = new BlogDAO();
        List<Blog> blist = bd.getAllBlog();
        request.setAttribute("blist", blist);
       
        
        request.getRequestDispatcher("Home.jsp").forward(request, response);

        

    }

   
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

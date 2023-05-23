
package controller;

import DAO.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("change.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
           request.setCharacterEncoding("utf-8");
       
        userDAO userDao = new userDAO();
        //phien cua nguoi dung hien tai
        User curUser =(User) request.getSession().getAttribute("user");
        //tim user theo id
        int userid = curUser.getUserid();
        //thay doi mat khau va luu du lieu vao db
        String newPassword = request.getParameter("npass");
        userDao.changePassword(userid, newPassword);
        curUser.setPassword(newPassword);
        request.getSession().setAttribute("user", curUser);
        //quay ve trang profile 
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

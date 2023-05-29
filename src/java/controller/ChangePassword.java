//
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

@WebServlet(name = "ChangePassword", urlPatterns = {"/changepw"})
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
        User curUser =(User) request.getSession().getAttribute("currUser");
        int userid = curUser.getUserid();
//        String u = request.getParameter("user");
//        String oldPassword =  request.getParameter("opass");
        String newPassword =  request.getParameter("npass");
//        String confirmPassword = request.getParameter("currpass");
//        User user = userDao.checkLogin(userid, oldPassword);
//        if(user==null) {
//            String ms = "Old password is not correct";
//            request.setAttribute("ms", ms);
//            request.getRequestDispatcher("change.jsp").forward(request, response);
//        }else{
        //thay doi mat khau va luu du lieu vao db
        userDao.changePassword(userid, newPassword);
        curUser.setPassword(newPassword);
        request.getSession().setAttribute("currUser", curUser);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
        //}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DAO.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import model.User;

/**
 *
 * @author Admin
 */
@MultipartConfig(
        //kich thuoc tren bo nho 10MB
        fileSizeThreshold = 1024 * 1024 * 10,
        //kich thuoc toi da 50MB
        maxFileSize = 1024 * 1024 * 50,
        //tong kich thuoc toi da 100MB
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "ProfileUpdate", urlPatterns = {"/profile"})
public class ProfileUpdate extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileUpdate</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileUpdate at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("utf-8");
//        System.out.println("session: " + request.getSession().getAttribute("currUser"));
//        User user = (User) request.getSession().getAttribute("currUser");
//        System.out.println("us: " + user);
        request.setAttribute("us", request.getSession().getAttribute("currUser"));
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        userDAO userDao = new userDAO();

        String successNoti = "yes";
        request.setAttribute("successNoti", successNoti);

        User curUser = (User) request.getSession().getAttribute("currUser");
        //lay thong tin cua nguoi dung hien tai
        int userId = curUser.getUserid();
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
//        String image = request.getParameter("avatar");
        String address = request.getParameter("address");
        //String filename = uploadFile(request);
        
        User us = (User) request.getSession().getAttribute("currUser");
        
        // upload avatar
        Part part = request.getPart("avatar");
        String avatarFileName = getFileName(part);
        if (!avatarFileName.isEmpty()) {
            // lay duong dan luu tru avatar da tai len
            String applicationPath = request.getServletContext().getRealPath("");
            String uploadPath = applicationPath + File.separator + "avatars";

            // tao thu muc luu tru neu chua co
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // luu file da tai len
            String avatarFilePath = uploadPath + File.separator + avatarFileName;
            part.write(avatarFilePath);

            // cập nhật đường dẫn avatar trong user
            String avatar = "avatars" + File.separator + avatarFileName;
            us.setAvatar(avatar);
        }

        //update thong tin cua nguoi dung hien tai
        us.setFullname(fullname);
        us.setPhone(phone);
        us.setAddress(address);
//        us.setAvatar(image);
        //luu thong tin update vao db
        userDao.editProfile(us);

        User userUpdate = userDao.getUpdateUser(curUser.getEmail(), curUser.getPassword());
        request.getSession().setAttribute("currUser", userUpdate);

        response.sendRedirect("profile");

    }
    
    private String getFileName(Part part) {
    String contentDisposition = part.getHeader("content-disposition");
    //tach tieu de thanh mang
    String[] elements = contentDisposition.split(";");
    for (String element : elements) {
        //neu phan tu hien tai bat dau bang filename thi tiep tuc xu li
        if (element.trim().startsWith("filename")) {
            //tra ve ten file duoc trich xuat tu filename
            return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return "";
}

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

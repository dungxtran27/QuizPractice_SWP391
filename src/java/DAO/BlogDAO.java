/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;

/**
 *
 * @author dungmuahahaha
 */
public class BlogDAO extends MyDAO{
     
    public List<Blog> getAllBlog() {
        xSql = "select * from [Blog]";
        List<Blog> list = new ArrayList<>();
        int BlogId, SubId;
        String Blogname;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BlogId = rs.getInt("blogId");
                SubId = rs.getInt("subId");
                Blogname = rs.getString("blogName");
                list.add(new Blog(BlogId, Blogname, SubId));
                
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      public ArrayList<Blog> GetBlogs(int mode) {
        ArrayList<Blog> bl = new ArrayList<>();
          int BlogId, SubId;
        String Blogname;
        try {
           
//            if (mode == 1) {
//                ps = con.prepareCall("SELECT * FROM [QuizPractice].[dbo].[Blog] where status = 1 order by time desc ");
//            } else {
//                ps = con.prepareCall("SELECT * FROM [QuizPractice].[dbo].[Blog] order by time desc ");
//            }

            rs = ps.executeQuery();
            while (rs.next()) {
                //nu standfor new-user
                Blog blog = new Blog();
                BlogId = rs.getInt("BlogId");
                SubId = rs.getInt("SubId");
                Blogname = rs.getString("Blogname");
                bl.add(new Blog(BlogId, Blogname, SubId));
               
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bl;
    }
      public List<Blog> getAllBlogByCharacter(String blogName) {
        xSql = "SELECT * FROM Blog WHERE blogName LIKE '%"+ blogName +"%'";
        List<Blog> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(xSql);
//            ps.setString(1, "%" + character + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Blog bl = new Blog();
                bl.setBlogId(rs.getInt(1));
                bl.setBlogName(rs.getString(2));
                bl.setSubId(rs.getInt(3));
                list.add(bl);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }









}


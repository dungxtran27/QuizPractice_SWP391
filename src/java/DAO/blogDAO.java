/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.Blog;

/**
 *
 * @author admin
 */
public class BlogDAO extends MyDAO{

    public ArrayList<Blog> GetBlogs() {
        ArrayList<Blog> bl = new ArrayList<>();
        try {
            if (con != null) {
                ps = con.prepareStatement("select * from Blog");
                rs = ps.executeQuery();
                if (rs.next()) {
                    rs.getInt("blogId");
                    rs.getString("roleName");
                    rs.getInt("subId");
                    return bl;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

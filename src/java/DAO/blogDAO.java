/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author admin
 */
public class BlogDAO extends MyDAO {

    public List<Blog> getListBlogs() {
        List<Blog> list = new ArrayList<>();
        xSql = "select * from Blog";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                                  rs.getString(2),
                                  rs.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

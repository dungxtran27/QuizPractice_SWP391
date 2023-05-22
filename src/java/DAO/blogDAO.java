/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.blog;

/**
 *
 * @author admin
 */
public class blogDAO extends MyDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<blog> getListBlogs() {
        ArrayList<blog> list = new ArrayList<>();
        try {
            String sql = "select * from Blog";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                blog bl = new blog();
                bl.setBlogId(rs.getInt(1));
                bl.setBlogName(rs.getString(2));
                bl.setSubId(rs.getInt(3));

                list.add(bl);
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

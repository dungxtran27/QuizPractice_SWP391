/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.slider;

/**
 *
 * @author dungmuahahaha
 */
public class SliderDAO extends MyDAO {

    public List<slider> getAllSlider() {
        xSql = "select * from [Slider]";
        List<slider> list = new ArrayList<>();
        int sliderId, SubId;
        String slider_url, title, content, backlink, notes;
        Boolean status, isShow;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sliderId = rs.getInt("sliderId");
                slider_url = rs.getString("slider_url");
                status = rs.getBoolean("status");
                title = rs.getString("title");

                content = rs.getString("content");
                backlink = rs.getString("backlink");
                notes = rs.getString("notes");
                isShow = rs.getBoolean("isShow");

                SubId = rs.getInt("subId");

                list.add(new slider(sliderId, slider_url, status, title, content, backlink, notes, true, SubId));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
}

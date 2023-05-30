/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.subject;

/**
 *
 * @author dungmuahahaha
 */
public class subjectDAO extends MyDAO {

    public List<subject> getAllSubject() {
        xSql = "select * from [Subject]";
        List<subject> slist = new ArrayList<>();

        int subjectId;
        int categoryId;
        String thumbnail;
        int tagLine;
        String content;
        String description;
        String title;
        String subjectName;

        boolean status;
        ;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {

                subjectId = rs.getInt("subjectId");
                subjectName = rs.getString("subjectName");
                categoryId = rs.getInt("categoryId");
                status = rs.getBoolean("status");
                tagLine = rs.getInt("tagLine");
                title = rs.getString("title");
                thumbnail = rs.getString("thumbnail");
                description = rs.getString("description");

                slist.add(new subject(subjectId, subjectName, categoryId, status, categoryId, title, thumbnail, description));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slist;
    }
}

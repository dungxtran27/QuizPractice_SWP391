/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.security.auth.Subject;
import model.subject;

/**
 *
 * @author dungmuahahaha
 */
public class subjectListDAO extends MyDAO {

    public List<subject> getAllSubject() {
        xSql = "select * from [Subject]";
        List<subject> slist = new ArrayList<>();

        int xsubjectId;
        int xcategoryId;
        String xthumbnail;
        int xtagLine;
        String xcontent;
        String xdescription;
        String xtitle;
        String xsubjectName;

        boolean xstatus;
        ;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {

                xsubjectId = rs.getInt("subjectId");
                xsubjectName = rs.getString("subjectName");
                xcategoryId = rs.getInt("categoryId");
                xstatus = rs.getBoolean("status");
                xtagLine = rs.getInt("tagLine");
               xtitle = rs.getString("title");
                xthumbnail = rs.getString("thumbnail");
                xdescription = rs.getString("description");

                slist.add(new subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slist;
    }
}

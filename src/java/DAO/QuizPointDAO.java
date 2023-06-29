/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.sql.Date;
import java.util.*;
import model.*;

/**
 *
 * @author dungmuahahaha
 */
public class QuizPointDAO extends MyDAO {

//    public int getSubId(int quizId) {
//        xSql = "select q.subId as 'subId'\n"
//                + "from QUIZ_POINT qp ,Quiz q\n"
//                + "where qp.quizId=q.quizId\n"
//                + "and qp.quizId=?";
//
//    }
    public ArrayList<quiz_point> getQuizHistory(int userId, int page, int page_5) {
        xSql = "with t as (select ROW_NUMBER() over (order by qp.id asc) as r,*\n"
                + "from QUIZ_POINT qp where qp.userId=?)\n"
                + "select * from t where r between ?*?-(?-1) and ?*?";
        ArrayList<quiz_point> qpList = new ArrayList<>();
        float point;
        int quizId;
        Date taken_date;
        float pointPercent;
        int attemp;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, page);
            ps.setInt(3, page_5);
            ps.setInt(4, page_5);
            ps.setInt(5, page);
            ps.setInt(6, page_5);
            rs = ps.executeQuery();
            while (rs.next()) {
                point = rs.getFloat("point");
                quizId = rs.getInt("quizId");
                taken_date = rs.getDate("taken_date");
                pointPercent = rs.getFloat("pointPercent");
                attemp = rs.getInt("attempt");
                qpList.add(new quiz_point(point, quizId, taken_date, pointPercent, attemp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qpList;

    }
    public int getTotalQuiz2(int userId) {
        int a=0;
        try {
            if (con != null) {
                xSql = "select distinct count(Q.userId) as 'count'\n" +
"                        from QUIZ_POINT AS Q  where q.userId=?";
                ps = con.prepareStatement(xSql);
                  ps.setInt(1, userId);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                     a=rs.getInt("count");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }
        return a;
    }
}

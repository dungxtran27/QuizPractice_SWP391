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

    public ArrayList<quiz_point> getQuizHistory(int userId) {
        xSql = "select * from QUIZ_POINT where userId = ?";
        ArrayList<quiz_point> qpList = new ArrayList<>();
        float point;
        int quizId;
        Date taken_date;
        float pointPercent;
        int attemp;
        try {
            ps = con.prepareStatement(xSql);
             ps.setInt(1, userId);
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
}

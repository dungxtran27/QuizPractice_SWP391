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
    public ArrayList<Practice> getQuizHistory(int userId, int page, int page_5) {
        xSql = " with t as (select ROW_NUMBER() over (order by QP.id asc) as r,\n"
                + " QP.point, QP.taken_date, Qz.title, Qz.duration, Qz.totalQues,\n"
                + "	QP.pointPercent, QP.numQuesTrue, \n"
                + " S.subjectId, S.subjectName, COUNT(Q.questionId) \n"
                + "	AS \"numOfQues\", Qz.quizId,QP.attempt \n"
                + "	from QUIZ_POINT QP\n"
                + "inner join Quiz Qz on QP.quizId = Qz.quizId \n"
                + "	inner join Question Q on Q.quizId = Qz.quizId \n"
                + "inner join Subject S on Qz.subId = S.subjectId \n"
                + "WHERE QP.userId = ?\n"
                + "GROUP BY QP.point, QP.taken_date, Qz.title, Qz.duration, Qz.totalQues,\n"
                + "	QP.pointPercent, QP.numQuesTrue, S.subjectId,\n"
                + "	S.subjectName,Qz.quizId,QP.attempt,QP.id)\n"
                + "	select * from t  where r between ?*?-(?-1) and ?*?\n";
               
        ArrayList<Practice> qpList = new ArrayList<>();
        float point;
        int quizId;
        Date taken_date;
        float pointPercent;
        int attempt;
        String title;
        int duration;
        int totalQues;
        int numQuesTrue;
        int subjectId;
        String subjectName;
        int numOfQues;
        
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
                title = rs.getString("title");
                numOfQues = rs.getInt("numOfQues");
                numQuesTrue = rs.getInt("numQuesTrue");
                subjectId = rs.getInt("subjectId");
                subjectName = rs.getString("subjectName");
                totalQues = rs.getInt("totalQues");
                taken_date = rs.getDate("taken_date");
                duration = rs.getInt("duration");
                pointPercent = rs.getFloat("pointPercent");
                attempt = rs.getInt("attempt");
                
                
                qpList.add(new Practice(userId, point, quizId, title, duration, totalQues, taken_date, numOfQues, attempt, pointPercent, numQuesTrue, subjectName, subjectId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qpList;

    }
     public ArrayList<Practice> getQuizHistoryAd( int page, int page_5) {
        xSql = " with t as (select ROW_NUMBER() over (order by QP.id asc) as r,\n"
                + " QP.point, QP.taken_date, Qz.title, Qz.duration, Qz.totalQues,\n"
                + "	QP.pointPercent, QP.numQuesTrue, \n"
                + " S.subjectId, S.subjectName, COUNT(Q.questionId) \n"
                + "	AS \"numOfQues\", Qz.quizId,QP.attempt \n"
                + "	from QUIZ_POINT QP\n"
                + "inner join Quiz Qz on QP.quizId = Qz.quizId \n"
                + "	inner join Question Q on Q.quizId = Qz.quizId \n"
                + "inner join Subject S on Qz.subId = S.subjectId \n"
                
                + "GROUP BY QP.point, QP.taken_date, Qz.title, Qz.duration, Qz.totalQues,\n"
                + "	QP.pointPercent, QP.numQuesTrue, S.subjectId,\n"
                + "	S.subjectName,Qz.quizId,QP.attempt,QP.id)\n"
                + "	select * from t  where r between ?*?-(?-1) and ?*?\n";
               
        ArrayList<Practice> qpList = new ArrayList<>();
        float point;
        int quizId;
        Date taken_date;
        float pointPercent;
        int attempt;
        String title;
        int duration;
        int totalQues;
        int numQuesTrue;
        int subjectId;
        String subjectName;
        int numOfQues;
        
        try {
            ps = con.prepareStatement(xSql);
           
            ps.setInt(1, page);
            ps.setInt(2, page_5);
            ps.setInt(3, page_5);
            ps.setInt(4, page);
            ps.setInt(5, page_5);
            rs = ps.executeQuery();
            while (rs.next()) {
                point = rs.getFloat("point");
                quizId = rs.getInt("quizId");
                title = rs.getString("title");
                numOfQues = rs.getInt("numOfQues");
                numQuesTrue = rs.getInt("numQuesTrue");
                subjectId = rs.getInt("subjectId");
                subjectName = rs.getString("subjectName");
                totalQues = rs.getInt("totalQues");
                taken_date = rs.getDate("taken_date");
                duration = rs.getInt("duration");
                pointPercent = rs.getFloat("pointPercent");
                attempt = rs.getInt("attempt");
                
                
                qpList.add(new Practice( point, quizId, title, duration, totalQues, taken_date, numOfQues, attempt, pointPercent, numQuesTrue, subjectName, subjectId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qpList;

    }

    public int getTotalQuiz2(int userId) {
        int a = 0;
        try {
            if (con != null) {
                xSql = "select distinct count(Q.userId) as 'count'\n"
                        + "                        from QUIZ_POINT AS Q  where q.userId=?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();

                while (rs.next()) {
                    a = rs.getInt("count");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return a;
    }
}

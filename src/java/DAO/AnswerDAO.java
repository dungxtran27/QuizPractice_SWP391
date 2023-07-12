/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Answer;

/**
 *
 * @author dungmuahahaha
 */
public class AnswerDAO extends MyDAO {

    public List<Answer> getAnswerByUserIdandAttempt(int userId, int attempt) {
        xSql = "SELECT\n"
                + "  a.answerId,\n"
                + "  a.content,\n"
                + "  a.correct,\n"
                + "  a.quesId,\n"
                + "  CASE WHEN a.answerId = ad.answerId THEN 1 ELSE 0 END AS 'userCheck'\n"
                + "FROM \n"
                + "  [SWP391_DB].[dbo].[Answer] a\n"
                + "LEFT OUTER JOIN\n"
                + "  [SWP391_DB].[dbo].[answerDetail] ad ON a.quesId = ad.questionId\n"
                + "WHERE\n"
                + "  attempt = ? \n"
                + "  AND userId = ? \n";
        List<Answer> aList = new ArrayList<>();
        int quesId, answerId;
        String content;
        boolean userCheck, correct;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(2, userId);
            ps.setInt(1, attempt);
            rs = ps.executeQuery();
            while (rs.next()) {
                answerId = rs.getInt(1);
                content = rs.getString(2);
                correct = rs.getBoolean(3);
                quesId = rs.getInt(4);
                userCheck = rs.getBoolean(5);

                aList.add(new Answer(answerId, content, correct, quesId, userCheck));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aList;
    }

    public List<Answer> getAnswerByQuestionId(int QuestionId) {
        List<Answer> list = new ArrayList<>();
        int xanswerId;
        String xcontent;
        boolean xcorrect;
        int xquesId;
        
        try {

            xSql = "select answerId, content, correct, quesId\n"
                    + "from Answer\n"
                    + "where quesId = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, QuestionId);
            rs = ps.executeQuery();

            while (rs.next()) {
                xanswerId = rs.getInt("answerId");
                xcontent = rs.getString("content");
                xcorrect = rs.getBoolean("correct");
                xquesId = rs.getInt("quesId");

                list.add(new Answer(xanswerId, xcontent, xcorrect, xquesId, xcorrect));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean checkAnswerIsCorrect(int answerId) {
        try {
            
                xSql = "select answerId, content, correct, quesId\n"
                        + "from Answer\n"
                        + "where answerId = ? and correct = 1";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, answerId);
                rs = ps.executeQuery();
              
                    while (rs.next()) {
                        return true;
                    }
                
            

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }

    public int getTotalCorrectAnswer(int questionId) {
        try {
            if (con != null) {
                xSql = "select COUNT(answerId) as total\n"
                        + "from Answer\n"
                        + "where quesId = ? and correct = 1";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, questionId);
                rs = ps.executeQuery();
                if (rs != null) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

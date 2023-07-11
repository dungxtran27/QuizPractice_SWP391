/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Question;

/**
 *
 * @author dungmuahahaha
 */
public class QuestionDAO extends MyDAO{
    
    public List<Question> getQuestionByQuizId(int QuizId) {
        List<Question> list = new ArrayList<>();
        int xquestionId;
        String xcontent;
        int xsubjectId;
        int xlessonId;
        int xtopicId;
        String xlevel;
        boolean xstatus;
        int xquizId;
        boolean xisMultipleChoice;
        try {
            if (con != null) {
                xSql = "select questionId, content, subjectId, lessonId, topicId, level, status, quizId,isMultipleChoice\n"
                        + "from Question\n"
                        + "where quizId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, QuizId);
                rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        xquestionId = rs.getInt("questionId");
                        xcontent = rs.getString("content");
                        xsubjectId = rs.getInt("subjectId");
                        xlessonId = rs.getInt("lessonId");
                        xtopicId = rs.getInt("topicId");
                        xlevel = rs.getString("level");
                        xstatus = rs.getBoolean("status");
                        xquizId = rs.getInt("quizId");
                        xisMultipleChoice = rs.getBoolean("isMultipleChoice");

                        list.add(new Question(xquestionId, xcontent, xsubjectId, xlessonId, xtopicId, xlevel, xstatus, xquizId, xlevel, xisMultipleChoice));
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Question getQuestionById(int questionId) {
        try {
            if (con != null) {
                xSql = "SELECT questionId, content, subjectId, lessonId, topicId, level, status, quizId, isMultipleChoice\n"
                        + "FROM Question\n"
                        + "WHERE questionId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, questionId);
                rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    int qId = rs.getInt("questionId");
                    String content = rs.getString("content");
                    int subjectId = rs.getInt("subjectId");
                    int lessonId = rs.getInt("lessonId");
                    int topicId = rs.getInt("topicId");
                    String level = rs.getString("level");
                    boolean status = rs.getBoolean("status");
                    int quizId = rs.getInt("quizId");
                    boolean isMultipleChoice = rs.getBoolean("isMultipleChoice");

                    Question question = new Question(qId, content, subjectId, lessonId, topicId, level, status, quizId, isMultipleChoice);
                    return question;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

 public int getTotalQuestionExist(int quizId,int subjectId) {
        try {
            if (con != null) {
                xSql = "select COUNT(questionId) from Question where quizId = ? and subjectId=?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizId);
                ps.setInt(2, subjectId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}

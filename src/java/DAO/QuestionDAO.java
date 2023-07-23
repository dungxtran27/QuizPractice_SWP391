/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Question;

/**
 *
 * @author dungmuahahaha
 */
public class QuestionDAO extends MyDAO {

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
        }
        return list;
    }

    /**
     *
     * @param QuizId
     * @param page
     * @param page10
     * @return
     */
    public ArrayList<Question> getQuestionByQuizIdAndPagging(int QuizId, int page, int page10) {
        ArrayList<Question> list = new ArrayList<>();
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

            xSql = "with t as (select ROW_NUMBER() over (order by Q.questionId asc) as r,\n"
                    + "Q.* from Question AS Q where Q.quizId = ? )\n"
                    + " select * from t where    r between    ?*?-(?-1) and ?*?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, QuizId);

            ps.setInt(2, page);
            ps.setInt(3, page10);
            ps.setInt(4, page10);
            ps.setInt(5, page);
            ps.setInt(6, page10);
            rs = ps.executeQuery();

            while (rs.next()) {
                xquestionId = rs.getInt("questionId");
                xcontent = rs.getString("content");
                xsubjectId = rs.getInt("subjectId");
                xlessonId = rs.getInt("lessonId");
                xtopicId = rs.getInt("topicId");
                xlevel = rs.getString("level");
                xstatus = rs.getBoolean("status");
                // xquizId = rs.getInt("quizId");
                xisMultipleChoice = rs.getBoolean("isMultipleChoice");

                list.add(new Question(xquestionId, xcontent, xsubjectId, xlessonId, xtopicId, xlevel, xstatus, QuizId, xlevel, xisMultipleChoice));
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        }
        return null;
    }

    public int getTotalQuestionExist(int quizId, int subjectId) {
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

    public int getTotalQuestionExist(int quizId) {
        try {

            xSql = "select COUNT(questionId) from Question where quizId = ? ";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Question> getQuestionByStatus(int status, int subjectId, int quizId) {
        ArrayList<Question> list = new ArrayList<>();

        try {

            xSql = "select distinct Q.* from Question AS Q where Q.quizId=? and Q.status =?";
            if (subjectId != 0) {
                xSql += " and Q.subjectId = " + subjectId;
            }

            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {

                int qId = rs.getInt("questionId");
                String content = rs.getString("content");
                //int subjectId = rs.getInt("subjectId");
                int lessonId = rs.getInt("lessonId");
                int topicId = rs.getInt("topicId");
                String level = rs.getString("level");
                boolean xstatus = rs.getBoolean("status");
                // int quizId = rs.getInt("quizId");
                boolean isMultipleChoice = rs.getBoolean("isMultipleChoice");
                Question question = new Question(qId, content, subjectId, lessonId, topicId, level, xstatus, quizId, isMultipleChoice);
                list.add(question);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Question> getListQuestionByKeyword(String keyword, String quizId) {
        List<Question> list = new ArrayList<>();
        try {

            xSql = "select distinct Q.* from Question AS Q where Q.content like ?\n"
                    + "and Q.quizId=?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int qId = rs.getInt("questionId");
                String content = rs.getString("content");
                int subjectId = rs.getInt("subjectId");
                int lessonId = rs.getInt("lessonId");
                int topicId = rs.getInt("topicId");
                String level = rs.getString("level");
                boolean xstatus = rs.getBoolean("status");
                 int xquizId = rs.getInt("quizId");
                boolean isMultipleChoice = rs.getBoolean("isMultipleChoice");
                Question question = new Question(qId, content, subjectId, lessonId,
                        topicId, level, xstatus, xquizId, isMultipleChoice);
                list.add(question);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

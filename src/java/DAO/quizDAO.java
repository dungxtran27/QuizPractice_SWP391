/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.AnswerDetail;
import model.Blog;
import model.quiz;
import model.quiz_point;

/**
 *
 * @author dungmuahahaha
 */
public class QuizDAO extends MyDAO {

    public int getTotalQuiz() {
        int a = 0;
        try {
            if (con != null) {
                xSql = "select distinct count(Q.quizId) as 'id'\n"
                        + "from Quiz AS Q inner join Lesson AS L\n"
                        + "on Q.lessonId = L.lessonId";
                ps = con.prepareStatement(xSql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    a = rs.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return a;
    }
//
//    public int test(int page, int PAGE_SIZE_6) {
//        int a = 10;
//        for (int i = 0; i < 5; i++) {
//            a++;
//
//        }
//        return a;
//    }

    public List<quiz> getListQuizzesByPagging(int page, int PAGE_SIZE_6) {
        List<quiz> list = new ArrayList<>();
        int xquizId;
        String xtitle;
        String xlevel;
        boolean xstatus;
        float xrate;
        int xsubId;
        int xlessonId = 1;
        String xtypeId;
        int xduration;
        String xdescription;
        int xtotalQues;
        String xtypeName;
        String xsubjectName;

        try {
            xSql = "with t as (select ROW_NUMBER() over (order by Q.quizId asc) as r, Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.subId, Q.typeId, Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName \n"
                    + "from Quiz AS Q inner join Subject S\n"
                    + "on Q.subId = S.subjectId inner join Type T on Q.typeId = T.typeId)\n"
                    + "select * from t where status =1 and r between ?*? - (?-1) and ?*?";
            if (con != null) {
                // System.out.println("muahha");
                ps = con.prepareStatement(xSql);
                ps.setInt(1, page);
                ps.setInt(2, PAGE_SIZE_6);
                ps.setInt(3, PAGE_SIZE_6);
                ps.setInt(4, page);
                ps.setInt(5, PAGE_SIZE_6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xquizId = rs.getInt("quizId");
                    xtitle = rs.getString("title");
                    xlevel = rs.getString("level");
                    xstatus = rs.getBoolean("status");
                    xrate = rs.getFloat("rate");
                    xsubId = rs.getInt("subId");
                    // xlessonId = rs.getInt("lessonId");
                    xtypeId = rs.getString("typeId");
                    xduration = rs.getInt("duration");
                    xdescription = rs.getString("description");
                    xtotalQues = rs.getInt("totalQues");
                    xtypeName = rs.getString("typeName");
                    xsubjectName = rs.getString("subjectName");
                    //  a++;
                    //System.out.println(a);
                    // System.out.println("a++");
                    list.add(new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues));
                }
            } else {
                System.out.println("arghhhh");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return list;
    }
     public List<quiz> getListQuizzesByPaggingAdmin(int page, int PAGE_SIZE_6) {
        List<quiz> list = new ArrayList<>();
        int xquizId;
        String xtitle;
        String xlevel;
        boolean xstatus;
        float xrate;
        int xsubId;
        int xlessonId = 1;
        String xtypeId;
        int xduration;
        String xdescription;
        int xtotalQues;
        String xtypeName;
        String xsubjectName;

        try {
            xSql = "with t as (select ROW_NUMBER() over (order by Q.quizId asc) as r, Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.subId, Q.typeId, Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName \n"
                    + "from Quiz AS Q inner join Subject S\n"
                    + "on Q.subId = S.subjectId inner join Type T on Q.typeId = T.typeId)\n"
                    + "select * from t where  r between ?*? - (?-1) and ?*?";
            if (con != null) {
                // System.out.println("muahha");
                ps = con.prepareStatement(xSql);
                ps.setInt(1, page);
                ps.setInt(2, PAGE_SIZE_6);
                ps.setInt(3, PAGE_SIZE_6);
                ps.setInt(4, page);
                ps.setInt(5, PAGE_SIZE_6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xquizId = rs.getInt("quizId");
                    xtitle = rs.getString("title");
                    xlevel = rs.getString("level");
                    xstatus = rs.getBoolean("status");
                    xrate = rs.getFloat("rate");
                    xsubId = rs.getInt("subId");
                    // xlessonId = rs.getInt("lessonId");
                    xtypeId = rs.getString("typeId");
                    xduration = rs.getInt("duration");
                    xdescription = rs.getString("description");
                    xtotalQues = rs.getInt("totalQues");
                    xtypeName = rs.getString("typeName");
                    xsubjectName = rs.getString("subjectName");
                    //  a++;
                    //System.out.println(a);
                    // System.out.println("a++");
                    list.add(new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues));
                }
            } else {
                System.out.println("arghhhh");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return list;
    }

    public int getTotalQuizOnlySearch(String keyword) {
        try {
            if (con != null) {
                xSql = "select distinct count(Q.quizId)\n"
                        + "from Quiz AS Q inner join Lesson AS L\n"
                        + "on Q.lessonId = L.lessonId where Q.title like ?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
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

    public int getTotalQuizBySubIdAndSearch(String keyword, int subId) {
        try {
            if (con != null) {
                xSql = "select distinct count(Q.quizId)\n"
                        + "from Quiz AS Q inner join Subject S\n"
                        + "on S.subjectId = Q.subId where Q.title like ? and Q.subId = ?\n";

                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, subId);
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

    public List<quiz> getListQuizzesBySearchAndPagging(int page, int PAGE_SIZE_6, String keyword) {
        List<quiz> list = new ArrayList<>();
        int xquizId;
        String xtitle;
        String xlevel;
        boolean xstatus;
        float xrate;
        int xsubId;
        int xlessonId;
        String xtypeId;
        int xduration;
        String xdescription;
        int xtotalQues;
        String xtypeName;
        String xsubjectName;
        try {
            if (con != null) {
                xSql = "with t as (select ROW_NUMBER() over (order by Q.quizId asc) as r, Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.lessonId, Q.subId, Q.typeId, Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName \n"
                        + "from Quiz AS Q inner join Subject S on Q.subId = S.subjectId \n"
                        + "inner join Type T on Q.typeId = T.typeId where Q.title like ?) \n"
                        + "select * from t where r between ?*?-(?-1) and ?*?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, page);
                ps.setInt(3, PAGE_SIZE_6);
                ps.setInt(4, PAGE_SIZE_6);
                ps.setInt(5, page);
                ps.setInt(6, PAGE_SIZE_6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xquizId = rs.getInt("quizId");
                    xtitle = rs.getString("title");
                    xlevel = rs.getString("level");
                    xstatus = rs.getBoolean("status");
                    xrate = rs.getFloat("rate");
                    xsubId = rs.getInt("subId");
                    xlessonId = rs.getInt("lessonId");
                    xtypeId = rs.getString("typeId");
                    xduration = rs.getInt("duration");
                    xdescription = rs.getString("description");
                    xtotalQues = rs.getInt("totalQues");
                    xtypeName = rs.getString("typeName");
                    xsubjectName = rs.getString("subjectName");

                    list.add(new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues));
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

    public List<quiz> getListQuizzesBySubIdAndSearchAndPagging(int page, int PAGE_SIZE_6, String keyword, int subId) {
        List<quiz> list = new ArrayList<>();
        int xquizId;
        String xtitle;
        String xlevel;
        boolean xstatus;
        float xrate;
        int xsubId;
        int xlessonId;
        String xtypeId;
        int xduration;
        String xdescription;
        int xtotalQues;
        String xtypeName;
        String xsubjectName;
        try {
            if (con != null) {
                xSql = "with t as (select ROW_NUMBER() over (order by Q.quizId asc) as r, Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.lessonId, Q.subId, Q.typeId, Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName\n"
                        + "  from Quiz AS Q inner join Subject S on Q.subId =   S.subjectId \n"
                        + "inner join Type T on Q.typeId = T.typeId where Q.title like ? and S.subjectId = ?) \n"
                        + "select * from t where r between ?*?-(?-1) and ?*?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, subId);
                ps.setInt(3, page);
                ps.setInt(4, PAGE_SIZE_6);
                ps.setInt(5, PAGE_SIZE_6);
                ps.setInt(6, page);
                ps.setInt(7, PAGE_SIZE_6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xquizId = rs.getInt("quizId");
                    xtitle = rs.getString("title");
                    xlevel = rs.getString("level");
                    xstatus = rs.getBoolean("status");
                    xrate = rs.getFloat("rate");
                    xsubId = rs.getInt("subId");
                    xlessonId = rs.getInt("lessonId");
                    xtypeId = rs.getString("typeId");
                    xduration = rs.getInt("duration");
                    xdescription = rs.getString("description");
                    xtotalQues = rs.getInt("totalQues");
                    xtypeName = rs.getString("typeName");
                    xsubjectName = rs.getString("subjectName");

                    list.add(new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues));
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

    public int getTotalQuizByTypeIdAndSearch(String keyword, String typeId) {
        try {
            if (con != null) {
                xSql = "select distinct count(Q.quizId)\n"
                        + "from Quiz AS Q inner join Lesson AS L\n"
                        + "on Q.lessonId = L.lessonId  inner join Type T\n"
                        + "on T.typeId = Q.typeId where Q.title like ? and T.typeId = ?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, typeId);
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

    public List<quiz> getListQuizzesByTypeIdSearchAndPagging(int page, int PAGE_SIZE_6, String keyword, String typeId) {
        List<quiz> list = new ArrayList<>();
        int xquizId;
        String xtitle;
        String xlevel;
        boolean xstatus;
        float xrate;
        int xsubId;
        int xlessonId;
        String xtypeId;
        int xduration;
        String xdescription;
        int xtotalQues;
        String xtypeName;
        String xsubjectName;
        try {
            if (con != null) {
                xSql = " with t as (select ROW_NUMBER() over (order by Q.quizId asc) as r, Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.lessonId, Q.subId, \n"
                        + " Q.typeId, Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName\n"
                        + "  from Quiz AS Q inner join Subject S on Q.subId =   S.subjectId \n"
                        + "inner join Type T on Q.typeId = T.typeId where Q.title like ? and T.typeId = ?) \n"
                        + "select * from t where r between ?*?-(?-1) and ?*?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, typeId);
                ps.setInt(3, page);
                ps.setInt(4, PAGE_SIZE_6);
                ps.setInt(5, PAGE_SIZE_6);
                ps.setInt(6, page);
                ps.setInt(7, PAGE_SIZE_6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xquizId = rs.getInt("quizId");
                    xtitle = rs.getString("title");
                    xlevel = rs.getString("level");
                    xstatus = rs.getBoolean("status");
                    xrate = rs.getFloat("rate");
                    xsubId = rs.getInt("subId");
                    xlessonId = rs.getInt("lessonId");
                    xtypeId = rs.getString("typeId");
                    xduration = rs.getInt("duration");
                    xdescription = rs.getString("description");
                    xtotalQues = rs.getInt("totalQues");
                    xtypeName = rs.getString("typeName");
                    xsubjectName = rs.getString("subjectName");

                    list.add(new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues));
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

    public int getTotalQuizByTypeIdAndSubIdAndSearch(String keyword, int subId, String typeId) {
        try {
            if (con != null) {
                xSql = "select distinct count(Q.quizId)\n"
                        + "from Quiz AS Q inner join Lesson AS L\n"
                        + "on Q.lessonId = L.lessonId  inner join Type T\n"
                        + "on T.typeId = Q.typeId inner join Subject S\n"
                        + "on S.subjectId = L.subId where Q.title like ? \n"
                        + "and T.typeId = ? and L.subId = ?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, typeId);
                ps.setInt(3, subId);
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

    public List<quiz> getListQuizzesBySubIdAndTypeIdAndSearchAndPagging(int page, int PAGE_SIZE_6, String keyword, int subId, String typeId) {
        List<quiz> list = new ArrayList<>();
        int xquizId;
        String xtitle;
        String xlevel;
        boolean xstatus;
        float xrate;
        int xsubId;
        int xlessonId;
        String xtypeId;
        int xduration;
        String xdescription;
        int xtotalQues;
        String xtypeName;
        String xsubjectName;
        try {
            if (con != null) {
                xSql = "with t as (select ROW_NUMBER() over (order by Q.quizId asc) as r,\n"
                        + "Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.lessonId, Q.subId, Q.typeId, "
                        + "Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName, Q.attempt from Quiz AS Q left join Lesson AS L \n"
                        + "on Q.lessonId = L.lessonId inner join Subject S on L.subId = S.subjectId \n"
                        + "inner join Type T on Q.typeId = T.typeId where Q.title like ? and S.subjectId = ? and T.typeId = ? ) \n"
                        + "select * from t where r between ?*?-(?-1) and ?*?";
                ps = con.prepareStatement(xSql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, subId);
                ps.setString(3, typeId);
                ps.setInt(4, page);
                ps.setInt(5, PAGE_SIZE_6);
                ps.setInt(6, PAGE_SIZE_6);
                ps.setInt(7, page);
                ps.setInt(8, PAGE_SIZE_6);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xquizId = rs.getInt("quizId");
                    xtitle = rs.getString("title");
                    xlevel = rs.getString("level");
                    xstatus = rs.getBoolean("status");
                    xrate = rs.getFloat("rate");
                    xsubId = rs.getInt("subId");
                    xlessonId = rs.getInt("lessonId");
                    xtypeId = rs.getString("typeId");
                    xduration = rs.getInt("duration");
                    xdescription = rs.getString("description");
                    xtotalQues = rs.getInt("totalQues");
                    xtypeName = rs.getString("typeName");
                    xsubjectName = rs.getString("subjectName");

                    list.add(new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues));
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

    public quiz getQuizByQuizId(int quizId) {
        quiz quiz = null;
        xSql = "SELECT Q.quizId, Q.title, Q.level, Q.status, Q.rate, Q.subId, Q.lessonId, Q.typeId, Q.duration, Q.description, Q.totalQues, T.typeName, S.subjectName, Q.attempt \n"
                + "FROM Quiz AS Q\n"
                + "INNER JOIN Subject S ON Q.subId = S.subjectId \n"
                + "INNER JOIN Type T ON Q.typeId = T.typeId \n"
                + "WHERE Q.quizId = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int xquizId = rs.getInt("quizId");
                    String xtitle = rs.getString("title");
                    String xlevel = rs.getString("level");
                    boolean xstatus = rs.getBoolean("status");
                    float xrate = rs.getFloat("rate");
                    int xsubId = rs.getInt("subId");
                    int xlessonId = rs.getInt("lessonId");
                    String xtypeId = rs.getString("typeId");
                    int xduration = rs.getInt("duration");
                    String xdescription = rs.getString("description");
                    int xtotalQues = rs.getInt("totalQues");
                    String xtypeName = rs.getString("typeName");
                    String xsubjectName = rs.getString("subjectName");

                    quiz = new quiz(xquizId, xtitle, xlevel, xstatus, xrate, xsubId, xlessonId, xduration, xtypeId, xtypeName, xsubjectName, xdescription, xtotalQues);
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
        return quiz;
    }

    public quiz_point getQuizPointAttempt(int userId, int quizId) {
        quiz_point quizzPoint = null;
        try {
            if (con != null) {
                xSql = "SELECT TOP 1 *\n"
                        + "FROM QUIZ_POINT\n"
                        + "WHERE quizId = ? AND userId = ?\n"
                        + "ORDER BY attempt DESC;";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizId);
                ps.setInt(2, userId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    float point = rs.getFloat("point");
                    int attempt = rs.getInt("attempt");
                    quizzPoint = new quiz_point(id, userId, point, quizId, attempt);
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
        return quizzPoint;
    }

    public boolean isDoQuizz(int userId, int quizzId) {
        try {

            if (con != null) {
                String sql = "select *\n"
                        + "from QUIZ_POINT\n"
                        + "where userId = ? and quizId = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setInt(2, quizzId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
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
        return false;
    }

    public quiz_point getQuizPoint(int userId, int quizId, int attempt) {
        quiz_point quizzPoint = null;

        int id;
        float point;
        try {
            //  con = DBContext.makeConnection();
            if (con != null) {
                String sql = "select *\n"
                        + "from QUIZ_POINT\n"
                        + "where userId = ? and quizId = ? and attempt = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, userId);
                ps.setInt(2, quizId);
                ps.setInt(3, attempt);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //  quiz_point quizzPoint = quiz_point.builder()
                    id = rs.getInt(1);
                    userId = rs.getInt(2);
                    point = rs.getFloat(3);
                    quizId = rs.getInt(4);
                    attempt = rs.getInt(8);
                    quizzPoint = new quiz_point(id, userId, point, quizId, attempt);

                    return quizzPoint;

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

    public boolean checkUserIsChoosen(int answerId, int quizId, int userid, int attempt) {
        try {

            if (con != null) {
                String sql = "select *\n"
                        + "from answerDetail\n"
                        + "where answerId = ? and quizId = ? and userId = ? and attempt = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, answerId);
                ps.setInt(2, quizId);
                ps.setInt(3, userid);
                ps.setInt(4, attempt);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
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
        return false;
    }

    public boolean insertAnswerDetail(AnswerDetail answerDetail) {
        try {
            if (con != null) {
                xSql = "insert into answerDetail values(?,?,?,?,?);";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, answerDetail.getQuestionId());
                ps.setInt(2, answerDetail.getAnswerId());
                ps.setInt(3, answerDetail.getUserId());
                ps.setInt(4, answerDetail.getQuizId());
                ps.setInt(5, answerDetail.getAttempt());
                if (ps.executeUpdate() > 0) {
                    return true;
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
        return false;
    }

    public boolean insertQuizPoint(quiz_point quizzPoint, float pointPercent, int numQuesTrue) {
        try {
            if (con != null) {
                DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//Zoned datetime instance
                ZonedDateTime zdt = ZonedDateTime.now();

//Get formatted String
                String nowDate = FOMATTER.format(zdt);

                xSql = "insert into QUIZ_POINT values(?,?,?,?,?,?,?);";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizzPoint.getUserId());
                ps.setDouble(2, Double.parseDouble("" + quizzPoint.getPoint()));
                ps.setInt(3, quizzPoint.getQuizId());
                ps.setString(4, nowDate);
                ps.setFloat(5, pointPercent);
                ps.setInt(6, numQuesTrue);
                ps.setInt(7, quizzPoint.getAttempt());
                if (ps.executeUpdate() > 0) {
                    return true;
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
        return false;
    }

    public quiz insertQuiz(quiz q) {
        xSql = "INSERT INTO [Quiz]\n"
                + "          ([title]\n"
                + "          ,[level]\n"
                + "          ,[rate]\n"
                + "          ,[subId]\n"
                + "          ,[duration]\n"
                + "          ,[typeId]\n"
                + "          ,[description]\n"
                + "          ,[totalQues]\n"
                + "          ,[status]\n"
                + "          ,[attempt])\n"
                + "           VALUES\n"
                + "            (?,?,?,?,?,?,?,?,1,?)";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setString(1, q.getTitle());
                ps.setString(2, q.getLevel());
                ps.setFloat(3, q.getRate());
                ps.setInt(4, q.getSubId());
                ps.setInt(5, q.getDuration());
                ps.setString(6, q.getTypeId());
                ps.setString(7, q.getDescription());
                ps.setInt(8, q.getTotalQues());
                ps.setInt(9, q.getAttempt());
                ps.executeUpdate();

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
        return q;
    }

    public boolean checkExistDoQuiz(int quizId) {
        try {
            if (con != null) {
                xSql = "select * from QUIZ_POINT where quizId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return true;
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
        return false;
    }

    public void updateQuiz(String title, int subId, String description, int durarion, String level, Float rate, String typeId, int quizId, int totalQues, int attempt) {
        xSql = "UPDATE [Quiz]\n"
                + "   SET [title] = ?\n"
                + "      ,[level] = ?\n"
                + "      ,[rate] = ?\n"
                + "      ,[subId] = ?\n"
                + "      ,[duration] = ?\n"
                + "      ,[typeId] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[attempt] = ?\n"
                + "      ,[totalQues] = ?\n"
                + " WHERE quizId = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setString(1, title);
                ps.setString(2, level);
                ps.setFloat(3, rate);
                ps.setInt(4, subId);
                ps.setInt(5, durarion);
                ps.setString(6, typeId);
                ps.setString(7, description);
                ps.setInt(8, attempt);
                ps.setInt(9, totalQues);
                ps.setInt(10, quizId);
                ps.executeUpdate();

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
    }

    public void hideQuizByQuizId(int quizId) {
        xSql = "UPDATE [dbo].[Quiz]\n"
                + "   SET [status] = 0\n"
                + " WHERE quizId = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizId);
                ps.executeUpdate();

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
    }

    public void showQuizByQuizId(int quizId) {
        xSql = "UPDATE [dbo].[Quiz]\n"
                + "   SET [status] = 1\n"
                + " WHERE quizId = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setInt(1, quizId);
                ps.executeUpdate();

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
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.security.auth.Subject;
import model.SubjectRegister;
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
    
    public List<subject> getListSubjectBySubjectId(int subjectId) {
        ArrayList<subject> list = new ArrayList<>();
        int xsubjectId;
        int xcategoryId;
        String xthumbnail;
        int xtagLine;
        String xcontent;
        String xdescription;
        String xtitle;
        String xsubjectName;
        boolean xstatus;
        float xsalePrice;
        float xprice;
        try {
            if (con != null) {
                xSql = "SELECT DISTINCT S.*, PP.salePrice, PP.price\n"
                        + "FROM Subject AS S\n"
                        + "JOIN PricePackage AS PP ON S.subjectId = PP.priceId\n"
                        + "WHERE S.subjectId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, subjectId);
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
                    xsalePrice = rs.getFloat("salePrice");
                    xprice = rs.getFloat("price");

                    list.add(new subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription, xsalePrice, xprice));}
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
    
public List<subject> getListSubjectsByPaggingAndSort(int page, int pageSize, String sortBy) {
    List<subject> list = new ArrayList<>();
    int xsubjectId;
    int xcategoryId;
    String xthumbnail;
    int xtagLine;
    String xcontent;
    String xdescription;
    String xtitle;
    String xsubjectName;
    boolean xstatus;
    Date xdate; // Thêm biến xdate kiểu Timestamp

    try {
        if (con != null) {
            xSql = "  with t as (select ROW_NUMBER() over (order by S.createDate asc) as r, S.* from Subject AS S) \n" +
" select * from t where r between  ? * ? - (?-1) and ? * ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageSize);
            ps.setInt(4, page);
            ps.setInt(5, pageSize);
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
                xdate = rs.getDate("createDate"); // Lấy giá trị thời gian của trường "date"

                list.add(new subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription, xdate)); // Thêm xdate vào constructor của Subject
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
public List<subject> sortByDate() {
    List<subject> sortedList = new ArrayList<>();
    int xsubjectId;
    int xcategoryId;
    String xthumbnail;
    int xtagLine;
    String xcontent;
    String xdescription;
    String xtitle;
    String xsubjectName;
    boolean xstatus;
    Date xdate;

    try {
        if (con != null) {
           xSql = "SELECT * FROM Subject ORDER BY createDate ASC";
            ps = con.prepareStatement(xSql);
          rs = ps.executeQuery(xSql);
            while (rs.next()) {
                xsubjectId = rs.getInt("subjectId");
                xsubjectName = rs.getString("subjectName");
                xcategoryId = rs.getInt("categoryId");
                xstatus = rs.getBoolean("status");
                xtagLine = rs.getInt("tagLine");
                xtitle = rs.getString("title");
                xthumbnail = rs.getString("thumbnail");
                xdescription = rs.getString("description");
                xdate = rs.getDate("createDate");

                sortedList.add(new subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription, xdate));
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
    return sortedList;
}
     public List<subject> getListSubjectsByPagging(int page, int PAGE_SIZE_3) {
        List<subject> list = new ArrayList<>();
        int xsubjectId;
        int xcategoryId;
        String xthumbnail;
        int xtagLine;
        String xcontent;
        String xdescription;
        String xtitle;
        String xsubjectName;
        boolean xstatus;
        int i = 0;
        try {
            if (con != null) {
                xSql = "with t as (select ROW_NUMBER() over (order by S.subjectId asc) as r,\n"
                        + "S.* from Subject AS S )\n"
                        + "select * from t where r between ?*?-(?-1) and ?*?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, page);
                ps.setInt(2, PAGE_SIZE_3);
                ps.setInt(3, PAGE_SIZE_3);
                ps.setInt(4, page);
                ps.setInt(5, PAGE_SIZE_3);
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

                list.add(new subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription));
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
//     
//    public List getSubjectCat(String condition) {
//        List<SubjectCat> cats = new ArrayList<>();
//        try {
//            if (condition.isEmpty()) {
//                ps = con.prepareStatement("select * from [QuizPractice].[dbo].[SubjectCategory]");
//            } else {
//                ps = con.prepareStatement("select * from [SubjectCategory] " + condition);
//            }
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                SubjectCat sc = new SubjectCat();
//                sc.setCatId(rs.getInt("cat_id"));
//                sc.setName(rs.getString("name"));
//                sc.setStatus(rs.getInt("status"));
//                cats.add(sc);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return cats;
//    }



    public int getTotalSubject() {
        try {
            if (con != null) {
                String sql = "select distinct count(S.subjectId) from Subject AS S ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalSubject(String keyword) {
        try {
            if (con != null) {
                xSql = "select distinct count(S.subjectId)from Subject AS S where S.subjectName like ?";
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
//      public List getSubjectType(String condition) {
//        List<SubjectType> types = new ArrayList<>();
//        try {
//            if (condition.isEmpty()) {
//                ps = con.prepareStatement("select * from [QuizPractice].[dbo].[SubjectType]");
//            } else {
//                ps = con.prepareStatement("select * from [SubjectType] " + condition);
//            }
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                SubjectType st = new SubjectType();
//                st.setId(rs.getInt("typeID"));
//                st.setStatus(rs.getInt("status"));
//                st.setName(rs.getString("name"));
//                st.setCat_id(rs.getInt("cat_id"));
//                types.add(st);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return types;
//    }
//
//
//    public List<Subject> getListSubjectBySubjectId(int subjectId) {
//        ArrayList<Subject> list = new ArrayList<>();
//        int xsubjectId;
//        int xcategoryId;
//        String xthumbnail;
//        int xtagLine;
//        String xcontent;
//        String xdescription;
//        String xtitle;
//        String xsubjectName;
//        boolean xstatus;
//        float xsalePrice;
//        float xprice;
//
//        try {
//            if (con != null) {
//                xSql = "SELECT DISTINCT S.*, PP.salePrice, PP.price\n"
//                        + "FROM Subject AS S\n"
//                        + "JOIN PricePackage AS PP ON S.subjectId = PP.priceId\n"
//                        + "WHERE S.subjectId = ?";
//                ps = con.prepareStatement(xSql);
//                ps.setInt(1, subjectId);
//                rs = ps.executeQuery();
//                while (rs.next()) {
//                    xsubjectId = rs.getInt("subjectId");
//                    xsubjectName = rs.getString("subjectName");
//                    xcategoryId = rs.getInt("categoryId");
//                    xstatus = rs.getBoolean("status");
//                    xtagLine = rs.getInt("tagLine");
//                    xtitle = rs.getString("title");
//                    xthumbnail = rs.getString("thumbnail");
//                    xdescription = rs.getString("description");
//                    xsalePrice = rs.getFloat("salePrice");
//                    xprice = rs.getFloat("price");
//
//                    list.add(new Subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription, xsalePrice, xprice));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }



    public List<subject> getListSubjectsByKeywordAndPagging(String keyword, int page, int PAGE_SIZE_3) {
        List<subject> list = new ArrayList<>();
        int xsubjectId;
        int xcategoryId;
        String xthumbnail;
        int xtagLine;
        String xcontent;
        String xdescription;
        String xtitle;
        String xsubjectName;
        boolean xstatus;
        try {
            if (con != null) {
                String sql = "with t as (select ROW_NUMBER() over (order by S.subjectId asc) as r,\n"
                        + "                    S.*from Subject AS S \n"
                        + "                    where S.subjectName like ?) select * from t where r between ?*?-(?-1) and ?*?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, page);
                ps.setInt(3, PAGE_SIZE_3);
                ps.setInt(4, PAGE_SIZE_3);
                ps.setInt(5, page);
                ps.setInt(6, PAGE_SIZE_3);
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

                    list.add(new subject(xsubjectId, xsubjectName, xcategoryId, xstatus, xtagLine, xtitle, xthumbnail, xdescription));
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
    

    public List getSubjectsRegisterByUser(String condition, int uId) {
        List<SubjectRegister> subjects = new ArrayList<>();
        String userCondition = "";
        if (uId > 0) {
            userCondition = "and SubjectRegister.u_id = " + uId;
        }

        try {
            String query = " select SubjectRegister.u_id,Subject.description, Subject.name,Subject.typeID,Subject.instructor_id,Subject.image,Subject.logo,Subject.\n"
                    + "  organization, Subject.s_id, PricePackage.price, PricePackage.currency_unit,\n"
                    + "   SubjectRegister.[status], SubjectRegister.register_date\n"
                    + "  from ((PricePackage INNER JOIN [Subject] on [Subject].s_id=PricePackage.s_id) \n"
                    + "  inner join SubjectRegister on SubjectRegister.price_id= PricePackage.price_id)\n"
                    + "   where SubjectRegister.[status]='1'" + userCondition + condition;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    SubjectRegister s = new SubjectRegister();
                    s.setSubjectId(rs.getInt("subjectId"));
                    s.setSubjectName(rs.getString("subjectNaame"));
                    s.setCategoryId(rs.getInt("categoryId"));
                    s.setDescription(rs.getString("description"));
                    s.setStatus(true);
                    s.setRegis_Date(rs.getString("regis_Date"));
                    s.setPrice(rs.getInt("Price"));
                    subjects.add(s);
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
        return subjects;
    }

    public subject getSubjectById(int subjectId) {
        String subjectName;
        int categoryId;
        boolean status;
        int tagLine;
        String title;
        String thumbnail;
        String description;

        try {
            if (con != null) {
                xSql = "select distinct S.* from Subject AS S where S.subjectId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, subjectId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    subjectId = rs.getInt(1);
                    subjectName = rs.getString(2);
                    categoryId = rs.getInt(3);
                    status = rs.getBoolean(4);
                    tagLine = rs.getInt(5);
                    title = rs.getString(6);
                    thumbnail = rs.getString(7);
                    description = rs.getString(8);
                    return new subject(subjectId, subjectName, categoryId, status, tagLine, title, thumbnail, description);
                }
            }
        } catch (Exception ex) {
            
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

}

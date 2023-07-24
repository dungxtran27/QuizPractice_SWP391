/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Date;
import model.RegistrationDTO;
import java.util.ArrayList;
import java.util.List;
import model.PricePackage;
import model.Registration;
import model.subject;

/**
 *
 * @author yentt
 */
public class RegistrationDAO extends MyDAO {

    public List<RegistrationDTO> getRegistrationByAccount(int userid) {
        List<RegistrationDTO> list = new ArrayList<>();
        int xregisId;
        Date xregis_Date;
        boolean xstatus;
        int xsubId;
        int xpriceId;
        int xuserId;

        try {

            xSql = "select rs.regisId,rs.priceId, rs.subId,rs.regis_Date,s.subjectName,p.name ,rs.statis from Registration_Subject rs\n"
                    + "left outer join Subject s \n"
                    + "on rs.subId=s.subjectId \n"
                    + "left outer join PricePackage p\n"
                    + "on rs.priceId=p.priceId\n"
                    + "where userId = ?";
//            xSql = " select * from Registration_Subject\n"
//                    + " where userId=?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
//                    RegistrationDTO registrationDTO = new RegistrationDTO();
                xregisId = rs.getInt(1);
                xregis_Date = rs.getDate(4);
                String date = String.valueOf(xregis_Date);
                String subName = rs.getString(5);
                String pricename = rs.getString(6);
                xstatus = rs.getBoolean(7);
                xsubId = rs.getInt(3);
                xpriceId = rs.getInt(2);
                RegistrationDTO r = new RegistrationDTO(xregisId, date, xstatus, subName, pricename, xsubId, xpriceId, userid);
             //  RegistrationDTO r = new RegistrationDTO(xregisId, date, xstatus, xsubId, xpriceId, userid);
                list.add(r);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalMonthPrice(int currentYear) {
        try {

            String sql = "select SUM(salePrice) as TOTAL\n"
                    + "from Registration_Subject\n"
                    + "inner join Subject on Registration_Subject.subId = Subject.subjectId\n"
                    + "right join PricePackage on Registration_Subject.priceId = PricePackage.priceId\n"
                    + "Where Month(regis_Date) = Month(getDate()) and YEAR(regis_Date) = ?";
//                        + "Where Registration_Subject.regis_Date < DATEADD(DAY,-30,GETDATE())";
            ps = con.prepareStatement(sql);
            ps.setInt(1, currentYear);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("TOTAL");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Object getTotalPrice() {
        try {
            if (con != null) {
                String sql = "select SUM(salePrice) as TOTAL\n"
                        + "from Registration_Subject\n"
                        + "inner join Subject on Registration_Subject.subId = Subject.subjectId\n"
                        + "right join PricePackage on Registration_Subject.priceId = PricePackage.priceId";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("TOTAL");
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

    public int getTotalPriceEachMonth(int month, int year) {
        try {
            if (con != null) {
                String sql = "select SUM(salePrice) as TOTAL\n"
                        + "from Registration_Subject\n"
                        + "inner join Subject on Registration_Subject.subId = Subject.subjectId\n"
                        + "right join PricePackage on Registration_Subject.priceId = PricePackage.priceId\n"
                        + "Where Month(regis_Date) = ? and YEAR(regis_Date) = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, month);
                ps.setInt(2, year);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("TOTAL");
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

    public List<Registration> getListYear() {
        List<Registration> list = new ArrayList<>();
        try {
            if (con != null) {
                String sql = "select distinct YEAR(regis_Date) from Registration_Subject";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int year = (rs.getInt(1));
                    Registration registration = new Registration(year, sql, true, year, sql, sql, sql);
                    list.add(registration);
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
}

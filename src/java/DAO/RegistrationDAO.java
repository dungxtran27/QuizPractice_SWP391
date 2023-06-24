/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class RegistrationDAO extends MyDAO{

    public List<RegistrationDTO> getRegistrationByAccount(int userid) {
        List<RegistrationDTO> list = new ArrayList<>();
        int xregisId;
        String xregis_Date;
        boolean xstatus;
        int xsubId;
        int xpriceId;
        int xuserId;
        
        try {
            if (con != null) {
                xSql = "select regisId, regis_Date, statis, subId, priceId, userId\n"
                        + "from Registration_Subject\n"
                        + "where userId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, userid);
                rs = ps.executeQuery();
                while (rs.next()) {
//                    RegistrationDTO registrationDTO = new RegistrationDTO();
                    xregisId = rs.getInt(1);
                    xregis_Date = rs.getString(2);
                    xstatus = rs.getBoolean(3);
                    subjectListDAO subjectDAO = new subjectListDAO();
//                    xsubId = Integer.parseInt(subjectDAO.getSubjectById(rs.getInt(4)));
//                    PricePackageDAO pricePackageDAO = new PricePackageDAO();
//                    registrationDTO.setPricePackage(pricePackageDAO.getPricePackageById(rs.getInt(5)));
//                    userDAO ud = new userDAO();
//                    registrationDTO.setUser(ud.getUserById(userid));
//                    list.add(new RegistrationDTO(userid, xSql, true, userid, userid, userid));
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

    public int getTotalMonthPrice(int currentYear) {
        try {
            if (con != null) {
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


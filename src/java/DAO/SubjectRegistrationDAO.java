/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.SubjectRegister;

/**
 *
 * @author admin
 */
public class SubjectRegistrationDAO extends MyDAO{
    public void createSubjectRegister(SubjectRegister sr) {
        try {
            
            if (con != null) {
                xSql = "INSERT INTO [dbo].[Registration_Subject]\n"
                        + "           ([regis_Date]\n"
                        + "           ,[statis]\n"
                        + "           ,[subId]\n"
                        + "           ,[priceId]\n"
                        + "           ,[userId])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?)";
                ps = con.prepareStatement(xSql);
                ps.setString(1, sr.getRegis_Date());
                ps.setString(2, sr.getStatis());
                ps.setInt(3, sr.getSubId());
                ps.setInt(4, sr.getPriceId());
                ps.setInt(5, sr.getUserId());;
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

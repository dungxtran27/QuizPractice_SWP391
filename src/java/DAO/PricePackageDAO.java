/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.PricePackage;
/**
 *
 * @author Admin
 */
public class PricePackageDAO extends MyDAO {
    public List<PricePackage> getAllPackage() {
        ArrayList<PricePackage> list = new ArrayList<>();
        int xpriceID;
        String xname;
        int xaccessDuration;
        float xprice;
        float xsalePrice;
        boolean xstatus;
        String xdescription;
        try {
            if (con != null) {
                xSql = "Select * from PricePackage ";
                ps = con.prepareStatement(xSql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xpriceID = rs.getInt("priceId");
                            xname = rs.getString("name");
                            xaccessDuration = rs.getInt("acessDuration");
                            xprice = rs.getFloat("price");
                            xsalePrice = rs.getFloat("salePrice");
                            xstatus = rs.getBoolean("status");
                            xdescription = rs.getString("description");

                    list.add(new PricePackage(xpriceID, xname, xaccessDuration, xprice, xsalePrice, xstatus, xdescription));
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
    
     
    public PricePackage getPricePackageById(int priceId) {
        try {
            if (con != null) {
                xSql = "select priceId, name, acessDuration, price, salePrice, status, description\n"
                        + "from PricePackage\n"
                        + "where priceId = ?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, priceId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    PricePackage pricePackage = new PricePackage();
                    pricePackage.setPriceId(rs.getInt(1));
                    pricePackage.setName(rs.getString(2));
                    pricePackage.setAcessDuration(rs.getInt(3));
                    pricePackage.setPrice(rs.getFloat(4));
                    pricePackage.setSalePrice(rs.getFloat(5));
                    pricePackage.setStatus(rs.getBoolean(6));
                    pricePackage.setDescription(rs.getString(7));
                    return pricePackage;
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

    public ArrayList<PricePackage> getAllPricePackageBySubjectId(int subjectId) {
        ArrayList<PricePackage> list = new ArrayList<>();
        int xpriceID;
        String xname;
        int xaccessDuration;
        float xprice;
        float xsalePrice;
        boolean xstatus;
        String xdescription;
        try {
            if (con != null) {
                xSql = "Select * from PricePackage  as P inner join SubjectPrice as SP on  P.priceId = SP.priceId where SP.subjectId=?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, subjectId);
                rs = ps.executeQuery();
                while (rs.next()) {
                            xpriceID = rs.getInt("priceId");
                            xname = rs.getString("name");
                            xaccessDuration = rs.getInt("acessDuration");
                            xprice = rs.getFloat("price");
                            xsalePrice = rs.getFloat("salePrice");
                            xstatus = rs.getBoolean("status");
                            xdescription = rs.getString("description");

                    list.add(new PricePackage(xpriceID, xname, xaccessDuration, xprice, xsalePrice, xstatus, xdescription));
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

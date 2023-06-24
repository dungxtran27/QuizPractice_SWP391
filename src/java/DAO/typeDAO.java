/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Type;

public class typeDAO extends MyDAO {
    
    public List<Type> getTypes() {
        List<Type> list = new ArrayList<>();
        String xtypeId;
        String xtypeName;
        try {
            if (con != null) {
                xSql = "select typeId, typeName\n"
                        + "from Type\n"
                        + "where typeId like '%l%'";
                ps = con.prepareStatement(xSql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xtypeId = rs.getString("typeId");
                    xtypeName = rs.getString("typeName");
                    list.add(new Type(xtypeId, xtypeName));
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
    
    public List<Type> getListTypeQuizes() {
        List<Type> list = new ArrayList<>();
        String xtypeId;
        String xtypeName;
        try {
            if (con != null) {
                xSql = "select typeId, typeName\n"
                        + "from Type\n"
                        + "where typeId like '%Q%'";
                ps = con.prepareStatement(xSql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    xtypeId = rs.getString("typeId");
                    xtypeName = rs.getString("typeName");
                    list.add(new Type(xtypeId, xtypeName));
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

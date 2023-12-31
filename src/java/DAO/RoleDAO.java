/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author admin
 */
public class RoleDAO extends MyDAO {

    public Role getRoleById(int roleId) {
        xSql = "Select *\n"
                + "From Role R\n"
                + "where R.roleId = ?";
        Role role = null;

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String roleName = rs.getString("rolename");
                role = new Role(roleId, roleName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public ArrayList<Role> getAllRole() {
        ArrayList<Role> List = new ArrayList<>();
        xSql = "SELECT * FROM [Role]";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String roleName = rs.getNString("roleName");
                int roleId = rs.getInt("roleId");
                Role role = new Role(roleId, roleName);
                List.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List;
    }
}

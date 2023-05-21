/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import model.DBContext;
import java.util.ArrayList;
import model.Role;
/**
 *
 * @author Admin
 */
public class userDAO extends MyDAO{

     public void editProfile(User us) {
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        
        xSql = "UPDATE [User] SET [fullname] =? , [phone] =?, [avatar]=?, [modify_date]= ?, [address] =? WHERE [userId] = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setString(1, us.getFullname());
                ps.setString(2, String.valueOf(us.getPhone()));
                ps.setString(3, us.getAvatar());
                ps.setTimestamp(4, createdTime);
                ps.setString(5, us.getAddress());
                ps.setInt(6, us.getUserid());

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
     public User getUser(String email, String password) {
        try {
            if (con != null) {
                xSql = "SELECT u.*, r.* FROM [User] u , [Role] r  WHERE [email] = ? AND [password] = ? and r.roleId = u.roleId";
                ps = con.prepareStatement(xSql);
                ps.setString(1, email);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    User user = new User();
                    Role role = new Role();

                    role.setRole_id(rs.getInt("RoleID"));
                    role.setRole_name(rs.getString("Name"));
                    user.setUserid(rs.getInt("userId"));
                    user.setFullname(rs.getString("fullname"));
                    user.setPhone(rs.getInt("phone"));
                    user.setEmail(rs.getString("email"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setCreated_date(rs.getTimestamp("created_date"));
                    user.setModify_date(rs.getTimestamp("modify_date"));
                    user.setAddress(rs.getString("address"));
                    user.setPassword(rs.getString("password"));
                    return user;
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
}

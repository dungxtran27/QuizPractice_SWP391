/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.DBContext;
import java.util.ArrayList;
import model.Role;

/**
 *
 * @author Admin
 */
public class userDAO extends MyDAO {

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

    public boolean checkLogin(String user, String pass) {
        xSql = "SELECT * FROM User WHERE [username] = ? and [password] = ?";
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            while (rs.next()) {
                //return new User(rs.getString(1), rs.getString(2))
                //Get Role For Authen

                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.getRoleById(rs.getInt("roleId"));
                int xuserid = rs.getInt(1);
                String xusername = rs.getString(2);
                String xpassword = rs.getString(3);
                String xfullname = rs.getString(7);
                int xphone = rs.getInt(6);
                String xaddress = rs.getString(8);
                String xemail = rs.getString(5);
                String xava = rs.getString(10);

                x = new User(xuserid, xusername, xpassword, xfullname, xphone, xaddress, xemail, xava, role);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(x==null){
            return false;
        }else{
            return true;
        }
    }

    public User checkUserExit(String user) {
        xSql = "SELCT * FROM User"
                + "WHERE [username] = ?";
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            rs = ps.executeQuery();

            while (rs.next()) {
                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.getRoleById(rs.getInt("roleId"));
                int xuserid = rs.getInt(1);
                String xusername = rs.getString(2);
                String xpassword = rs.getString(3);
                String xfullname = rs.getString(7);
                int xphone = rs.getInt(6);
                String xaddress = rs.getString(8);
                String xemail = rs.getString(5);
                String xava = rs.getString(10);

                x = new User(xuserid, xusername, xpassword, xfullname, xphone, xaddress, xemail, xava, role);
                return x;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Sign Up for Customer
    public void signUp(String user, String pass, String email) {
        xSql = "INSERT INTO User ([username], [password] ,[email], [roleId]) VALUES (?, ?, ?, 2)";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    
    public User getUser(String user, String pass) {
        xSql = "SELECT * FROM [User] WHERE [username] = 'admin' and [password] = '123456'";
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
//            ps.setString(1, user);
//            ps.setString(2, pass);

            rs = ps.executeQuery();
            while (rs.next()) {
                //return new User(rs.getString(1), rs.getString(2))
                //Get Role For Authen

                RoleDAO roleDAO = new RoleDAO();
                Role role = roleDAO.getRoleById(rs.getInt("roleId"));
                int xuserid = rs.getInt(1);
                String xusername = rs.getString(2);
                String xpassword = rs.getString(3);
                String xfullname = rs.getString(7);
                int xphone = rs.getInt(6);
                String xaddress = rs.getString(8);
                String xemail = rs.getString(5);
                String xava = rs.getString(10);

                x = new User(xuserid, xusername, xpassword, xfullname, xphone, xaddress, xemail, xava, role);
                return x;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}

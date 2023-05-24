/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import model.DBContext;
import java.util.ArrayList;
import model.Role;

import model.User;

/**
 *
 * @author Admin
 */
public class userDAO extends MyDAO{
    
    public User checkLogin(String user, String pass){
        xSql = "SELECT * FROM User WHERE [username] = ? and [password] = ?";
        User  x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            while(rs.next()){
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
                
                x = new User(xuserid, xusername, xpassword, xfullname, xphone,xaddress,xemail, xava, role);
                return x;
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public User checkUserExit (String user){
        xSql = "SELCT * FROM User"
                + "WHERE [username] = ?";
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            
            while(rs.next()){
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
                
                x = new User(xuserid, xusername, xpassword, xfullname, xphone,xaddress,xemail, xava, role);
                return x;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    //Sign Up for Customer
    public void signUp(String user, String pass, String email){
        xSql = "INSERT INTO User ([username], [password] ,[email], [roleId]) VALUES (?, ?, ?, 2)";
        
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        //cap nhat thong tin user trong db
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
         // tim user theo email va password
    
     public User getUpdateUser(String username, String password){
        try {
            if (con != null) {
                xSql = "SELECT u.*, r.* FROM [User] u , [Role] r  WHERE [username] = ? AND [password] = ? and r.roleId = u.roleId";
                ps = con.prepareStatement(xSql);
                ps.setString(1, username);
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
    //tim nguoi dung theo id va cap nhat mat khau
    public void changePassword(int userID, String newPassword) {
        xSql = "UPDATE User SET password = ? WHERE userId = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setInt(2, userID);
                ps.setString(1, newPassword);
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


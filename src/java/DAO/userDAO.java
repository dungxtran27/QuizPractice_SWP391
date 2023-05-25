/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.User;

/**
 *
 * @author dungmuahahaha
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.DBContext;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                String xphone = rs.getString(6);
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
                String xphone = rs.getString(6);
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
    public void signUp(User x) {
        xSql = "INSERT INTO [User] ([fullname],[gender],[username],[phone], [password] ,[email], [roleId]) VALUES (?, ?, ?, ?, ?, ?, 2)";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getFullname());
            ps.setString(2, x.getGender());
            ps.setString(3, x.getUsername());
            ps.setString(4, x.getPhone());
            ps.setString(5, x.getPassword());
            ps.setString(6, x.getEmail());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    
    public User getUser(String email, String pass) {
        xSql = "select * from [User] WHERE [email] =? and [password] =?";
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
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
                String xphone = rs.getString(6);
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
    
    
    //Kiểm tra input username nhập vào có bị trùng với username đã có hay không
    public boolean checkUsername(String username){
        try{
            xSql="SELECT [username] FROM [User] WHERE [username]=?";
            ps = con.prepareStatement(xSql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    //check phonenumber
    public boolean checkPhonenumber(String phone){
        String regex = "^\\d{10}$";
        Pattern p = Pattern.compile(regex);
        if (phone == null) {
            return false;
        }

        Matcher m = p.matcher(phone);
        return m.matches();
    }
    
    //  Kiểm tra password nhập vào có đúng điều kiện không, điều kiên 
    //  cụ thể ở đây là password phải có từ 6 đến 20 kí tự bao gồm chữ và số.
    public boolean checkPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z]).{6,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);
        return m.matches();
    }
    
    //Kiem tra email
    /*
    - Cho phep cac gia tri tu 0-9
    - Cho phep ca cac chu hoa va chu thuong tu a den z
    - dau "-" va dau"." khong duoc phep o dau va cuoi phan ten mien
    - khong co dau cham lien tiep
    */
    public boolean checkEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(regex);
        if (email == null) {
            return false;
        }

        Matcher m = p.matcher(email);
        return m.matches();
    }
    
    //kiem tra email ton tai
    public boolean checkEmailExist(String email){
        try{
            xSql="SELECT [email] FROM [User] WHERE [email]=?";
            ps = con.prepareStatement(xSql);
            ps.setString(1,email);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    
}


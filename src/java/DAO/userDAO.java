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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public User getUpdateUser(String email, String password) {
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
                    user.setPhone(rs.getString("phone"));
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
    public void changePassword(int userId, String newPassword) {
        xSql = "UPDATE [dbo].[User] SET password = '" + newPassword + "' WHERE userId = ?";
        try {
            if (con != null) {
                ps = con.prepareStatement(xSql);
                ps.setInt(1, userId);
                // ps.setString(1, newPassword);
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

    public User checkLogin(int userId, String pass) {
        xSql = "SELECT * FROM User WHERE [userId] = ? and [password] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
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

                return new User(xuserid, xusername, xpassword, xfullname, xphone, xaddress, xemail, xava, role);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
        xSql = "INSERT INTO [User] ([fullname],[phone], [password] ,[email], [roleId],[gender]) VALUES (?,?,?,?, 2,?)";

        try {
            ps = con.prepareStatement(xSql);

            ps.setString(1, x.getFullname());
            //  ps.setString(3, x.getUsername());
            ps.setString(2, x.getPhone());
            ps.setString(3, x.getPassword());
            ps.setString(4, x.getEmail());
            ps.setBoolean(5, Boolean.parseBoolean(x.getGender()));

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
                String xemail = rs.getString(5);
                String xphone = rs.getString(6);
                String xfullname = rs.getString(7);
                String xaddress = rs.getString(8);
                String xava = rs.getString(10);

                x = new User(xuserid, xusername, xpassword, xemail, xphone, xfullname, xaddress, xava, role);
                return x;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Kiểm tra input username nhập vào có bị trùng với username đã có hay không
    public boolean checkUsername(String username) {
        try {
            xSql = "SELECT [username] FROM [User] WHERE [username]=?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //check phonenumber
    public boolean checkPhonenumber(String phone) {
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
    public boolean checkEmail(String email) {
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
    public boolean checkEmailExist(String email) {
        try {
            xSql = "SELECT [email] FROM [User] WHERE [email]=?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(int userid) {
        try {
            if (con != null) {
                String sql = "select userid, username, password, email, phone, fullname, address, gender, avatar, roleId, created_date, modify_date\n"
                        + "from Account\n"
                        + "where userId = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, userid);
                rs = ps.executeQuery();
                if (rs.next()) {
                    RoleDAO roleDAO = new RoleDAO();
                    Role role = roleDAO.getRoleById(rs.getInt("roleId"));
                    userid = rs.getInt("userid");
                    String username = rs.getString("username");

                    return new User(userid, username);
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

    public int getTotalAccount() {
        try {

            xSql = " select distinct count(userId)\n"
                    + "  from [User] ";
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String xUserName, password, email, phone, fullname, address, status, gender;
        int roleId, userId;

        try {

            xSql = "  select * from [User]";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 userId = rs.getInt(1);
                xUserName = rs.getString(2);
                password = rs.getString(3);
                // status = rs.getString(4);
                boolean xstat = rs.getBoolean(4);
                status = String.valueOf(xstat);
                email = rs.getString(5);
                phone = rs.getString(6);
                fullname = rs.getString(7);
                address = rs.getString(8);
                roleId = rs.getInt(11);
                boolean genderBool = rs.getBoolean(9);
                gender = String.valueOf(genderBool);
                User u = new User(userId, xUserName, password, email, phone, fullname, status, address, gender, roleId);
                list.add(u);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<User> getListUsersByPagging(int page, int PAGE_SIZE_10) {
        ArrayList<User> list = new ArrayList<>();
        String xUserName, password, email, phone, fullname, address, status, gender;
        int roleId, userId;

        try {

            xSql = "  with t as (select ROW_NUMBER() over (order by A.userId asc) as r,\n"
                    + "   A.* from [User] AS A )\n"
                    + "   select * from t\n"
                    + "   where r between ?*?-(?-1) and ?*?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE_10);
            ps.setInt(3, PAGE_SIZE_10);
            ps.setInt(4, page);
            ps.setInt(5, PAGE_SIZE_10);
            rs = ps.executeQuery();
            while (rs.next()) {

                userId = rs.getInt(2);
                xUserName = rs.getString(3);
                password = rs.getString(4);
                // status = rs.getString(4);
                boolean xstat = rs.getBoolean(5);
                status = String.valueOf(xstat);
                email = rs.getString(6);
                phone = rs.getString(7);
                fullname = rs.getString(8);
                address = rs.getString(9);
                roleId = rs.getInt(12);
                boolean genderBool = rs.getBoolean(10);
                gender = String.valueOf(genderBool);
                User u = new User(userId, xUserName, password, email, phone, fullname, status, address, gender, roleId);
                list.add(u);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
    public ArrayList<User> getListStudentAndPaging(int page, int PAGE_SIZE_10) {
        ArrayList<User> list = new ArrayList<>();
        String xUserName, password, email, phone, fullname, address, status, gender;
        int roleId, userId;

        try {

            xSql = "  with t as (select ROW_NUMBER() over (order by A.userId asc) as r,\n"
                    + "   A.* from [User] AS A )\n"
                    + "   select * from t\n"
                    + "   where  roleId=2 and r between ?*?-(?-1) and ?*?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE_10);
            ps.setInt(3, PAGE_SIZE_10);
            ps.setInt(4, page);
            ps.setInt(5, PAGE_SIZE_10);
            rs = ps.executeQuery();
            while (rs.next()) {

                userId = rs.getInt(2);
                xUserName = rs.getString(3);
                password = rs.getString(4);
                // status = rs.getString(4);
                boolean xstat = rs.getBoolean(5);
                status = String.valueOf(xstat);
                email = rs.getString(6);
                phone = rs.getString(7);
                fullname = rs.getString(8);
                address = rs.getString(9);
                roleId = rs.getInt(12);
                boolean genderBool = rs.getBoolean(10);
                gender = String.valueOf(genderBool);
                User u = new User(userId, xUserName, password, email, phone, fullname, status, address, gender, roleId);
                list.add(u);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
    
    public void addTeacher(User x) {
        xSql = "INSERT INTO [User] ([fullname],[phone], [password] ,[email], [roleId],[gender]) VALUES (?,?,?,?, 2,?)";

        try {
            ps = con.prepareStatement(xSql);

            ps.setString(1, x.getFullname());
            //  ps.setString(3, x.getUsername());
            ps.setString(2, x.getPhone());
            ps.setString(3, x.getPassword());
            ps.setString(4, x.getEmail());
            ps.setBoolean(5, Boolean.parseBoolean(x.getGender()));

            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

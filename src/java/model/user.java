/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author diu
 */
public class User {
    private int userid;
    private String username;
    private String password;
    private String status;
    private String email;
    private String phone;
    private String fullname;
    private String address;
    private String gender;
    private String avatar;
    private int roleid;
    private Role role;
    private Timestamp created_date;
    private Timestamp modify_date;
    private String password_token;

    public User() {
    }

    public User(int userid, String username, String password, String email, String phone, String fullname, String address, String avatar, Role role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
        this.avatar = avatar;
        this.role = role;
    }
    
    

    public User(int userid, String username, String password, String status, String email, String phone, String fullname, String address, String gender, String avatar, int roleid, Role role, Timestamp created_date, Timestamp modify_date) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
        this.gender = gender;
        this.avatar = avatar;
        this.roleid = roleid;
        this.role = role;
        this.created_date = created_date;
        this.modify_date = modify_date;
    }

    public User(int userid, String username, String password, String status, String email, String phone, String fullname, String address, String gender, String avatar, int roleid, Role role, Timestamp created_date, Timestamp modify_date, String password_token) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
        this.gender = gender;
        this.avatar = avatar;
        this.roleid = roleid;
        this.role = role;
        this.created_date = created_date;
        this.modify_date = modify_date;
        this.password_token = password_token;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getModify_date() {
        return modify_date;
    }

    public void setModify_date(Timestamp modify_date) {
        this.modify_date = modify_date;
    }
    
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Registration {
    private int regisId;
    private String regisDate;
    private boolean status;
    private subject subject;
    private int subjectId;
    private String subName;
    private PricePackage pricePackage;
    private int pricePackageId;
    private User user;
    private int userid;
    private int year;
    private String priceName;
    private int price;
    private String email;

    public Registration() {
    }

    public Registration(int regisId, String regisDate, boolean status, int subjectId, int userid) {
        this.regisId = regisId;
        this.regisDate = regisDate;
        this.status = status;
        this.subjectId = subjectId;
        this.userid = userid;
        
    }

    public Registration(int regisId, String regisDate, boolean status, subject subject, int subjectId, String subName, PricePackage pricePackage, int pricePackageId, User user, int userid, int year, String priceName, int price, String email) {
        this.regisId = regisId;
        this.regisDate = regisDate;
        this.status = status;
        this.subject = subject;
        this.subjectId = subjectId;
        this.subName = subName;
        this.pricePackage = pricePackage;
        this.pricePackageId = pricePackageId;
        this.user = user;
        this.userid = userid;
        this.year = year;
        this.priceName = priceName;
        this.price = price;
        this.email = email;
    }

    public Registration(int regisId, String regisDate, boolean status, int price, String priceName, String subName, String email) {
        this.regisId = regisId;
        this.regisDate = regisDate;
        this.status = status;
        this.subName = subName;
        this.priceName = priceName;
        this.price = price;
        this.email = email;
    }

    public int getRegisId() {
        return regisId;
    }

    public void setRegisId(int regisId) {
        this.regisId = regisId;
    }

    public String getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(String regisDate) {
        this.regisDate = regisDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public subject getSubject() {
        return subject;
    }

    public void setSubject(subject subject) {
        this.subject = subject;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public PricePackage getPricePackage() {
        return pricePackage;
    }

    public void setPricePackage(PricePackage pricePackage) {
        this.pricePackage = pricePackage;
    }

    public int getPricePackageId() {
        return pricePackageId;
    }

    public void setPricePackageId(int pricePackageId) {
        this.pricePackageId = pricePackageId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

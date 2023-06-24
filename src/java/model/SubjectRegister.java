/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class SubjectRegister extends subject{
    private int regisId;
    private String regis_Date;
    private String statis;
    private int subId;
    private int priceId;
    private int userId;

    public SubjectRegister() {
    }

    public SubjectRegister(int regisId, String regis_Date, String statis, int subId, int priceId, int userId) {
        this.regisId = regisId;
        this.regis_Date = regis_Date;
        this.statis = statis;
        this.subId = subId;
        this.priceId = priceId;
        this.userId = userId;
    }

    public SubjectRegister(int regisId, String regis_Date, String statis, int subId, int priceId, int userId, int subjectId, String subjectName, int categoryId, boolean status, int tagLine, String title, String thumbnail, String description) {
        super(subjectId, subjectName, categoryId, status, tagLine, title, thumbnail, description);
        this.regisId = regisId;
        this.regis_Date = regis_Date;
        this.statis = statis;
        this.subId = subId;
        this.priceId = priceId;
        this.userId = userId;
    }

    public SubjectRegister(int regisId, String regis_Date, String statis, int subId, int priceId, int userId, int subjectId, String subjectName, int categoryId, boolean status, int tagLine, String title, String thumbnail, String description, float salePrice, float price) {
        super(subjectId, subjectName, categoryId, status, tagLine, title, thumbnail, description, salePrice, price);
        this.regisId = regisId;
        this.regis_Date = regis_Date;
        this.statis = statis;
        this.subId = subId;
        this.priceId = priceId;
        this.userId = userId;
    }

    public SubjectRegister(int userId, int regisId, int subId, String statis, int priceId) {
        this.userId = userId;
        this.regisId = regisId;
        this.subId = subId;
        this.statis = statis;
        this.priceId = priceId;
    }
    
    public int getRegisId() {
        return regisId;
    }

    public void setRegisId(int regisId) {
        this.regisId = regisId;
    }

    public String getRegis_Date() {
        return regis_Date;
    }

    public void setRegis_Date(String regis_Date) {
        this.regis_Date = regis_Date;
    }

    public String getStatis() {
        return statis;
    }

    public void setStatis(String statis) {
        this.statis = statis;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

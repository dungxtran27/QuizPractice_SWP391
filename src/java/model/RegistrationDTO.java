/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author admin
 */
public class RegistrationDTO {
    private int regisId;
    private String regisDate;
    private boolean status;
    private subject subject;
    private int subjectId;
    private PricePackage pricePackage;
    private int pricePackageId;
    private User user;
    private int userid;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int regisId, String regisDate, boolean status, int subjectId, int pricePackageId, int userid) {
        this.regisId = regisId;
        this.regisDate = regisDate;
        this.status = status;
        this.subjectId = subjectId;
        this.pricePackageId = pricePackageId;
        this.userid = userid;
    }

    public RegistrationDTO(int regisId, String regisDate, boolean status, subject subject, int subjectId, PricePackage pricePackage, int pricePackageId, User user, int userid) {
        this.regisId = regisId;
        this.regisDate = regisDate;
        this.status = status;
        this.subject = subject;
        this.subjectId = subjectId;
        this.pricePackage = pricePackage;
        this.pricePackageId = pricePackageId;
        this.user = user;
        this.userid = userid;
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
}

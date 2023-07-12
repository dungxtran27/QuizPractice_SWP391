/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author dungmuahahaha
 */
public class Practice {
  private int id;
    private int userId;
    private float point;
    private int quizzId;
    private String title;
    private int duration;
    private int totalQues;
    private Date taken_date; 
    private int numOfQues;
    private int attempt;
    private float pointPercent;
    private int numQuesTrue;
    private String subName;
    private int subId;   

    public Practice() {
    }

    public Practice(int userId, float point, int quizzId, String title, int duration, int totalQues, Date taken_date, int numOfQues, int attempt, float pointPercent, int numQuesTrue, String subName, int subId) {
        this.userId = userId;
        this.point = point;
        this.quizzId = quizzId;
        this.title = title;
        this.duration = duration;
        this.totalQues = totalQues;
        this.taken_date = taken_date;
        this.numOfQues = numOfQues;
        this.attempt = attempt;
        this.pointPercent = pointPercent;
        this.numQuesTrue = numQuesTrue;
        this.subName = subName;
        this.subId = subId;
    }

    public Practice( float point, int quizzId, String title, int duration, int totalQues, Date taken_date, int numOfQues, int attempt, float pointPercent, int numQuesTrue, String subName, int subId) {
        
        this.point = point;
        this.quizzId = quizzId;
        this.title = title;
        this.duration = duration;
        this.totalQues = totalQues;
        this.taken_date = taken_date;
        this.numOfQues = numOfQues;
        this.attempt = attempt;
        this.pointPercent = pointPercent;
        this.numQuesTrue = numQuesTrue;
        this.subName = subName;
        this.subId = subId;
    }

    public Practice(int id, int userId, float point, int quizzId, String title, int duration, int totalQues, Date taken_date, int numOfQues, int attempt, float pointPercent, int numQuesTrue, String subName, int subId) {
        this.id = id;
        this.userId = userId;
        this.point = point;
        this.quizzId = quizzId;
        this.title = title;
        this.duration = duration;
        this.totalQues = totalQues;
        this.taken_date = taken_date;
        this.numOfQues = numOfQues;
        this.attempt = attempt;
        this.pointPercent = pointPercent;
        this.numQuesTrue = numQuesTrue;
        this.subName = subName;
        this.subId = subId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public int getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(int quizzId) {
        this.quizzId = quizzId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalQues() {
        return totalQues;
    }

    public void setTotalQues(int totalQues) {
        this.totalQues = totalQues;
    }

    public Date getTaken_date() {
        return taken_date;
    }

    public void setTaken_date(Date taken_date) {
        this.taken_date = taken_date;
    }

    public int getNumOfQues() {
        return numOfQues;
    }

    public void setNumOfQues(int numOfQues) {
        this.numOfQues = numOfQues;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public float getPointPercent() {
        return pointPercent;
    }

    public void setPointPercent(float pointPercent) {
        this.pointPercent = pointPercent;
    }

    public int getNumQuesTrue() {
        return numQuesTrue;
    }

    public void setNumQuesTrue(int numQuesTrue) {
        this.numQuesTrue = numQuesTrue;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
    
}

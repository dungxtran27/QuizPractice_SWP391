/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author dungmuahahaha
 */
public class quiz_point {
    private int id;
    private int userId;
    private float point;
    private int quizId;
    private Date taken_date;
    private float pointPercent;
    private float numQuesTrue;
    private int attempt;

    public quiz_point() {
    }

    public quiz_point(int id, int userId, float point, int quizId, Date taken_date, float pointPercent, float numQuesTrue, int attempt) {
        this.id = id;
        this.userId = userId;
        this.point = point;
        this.quizId = quizId;
        this.taken_date = taken_date;
        this.pointPercent = pointPercent;
        this.numQuesTrue = numQuesTrue;
        this.attempt = attempt;
    }

    public quiz_point( float point, int quizId, Date taken_date, float pointPercent, int attempt) {
  
        this.point = point;
        this.quizId = quizId;
        this.taken_date = taken_date;
        this.pointPercent = pointPercent;
        this.attempt = attempt;
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

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Date getTaken_date() {
        return taken_date;
    }

    public void setTaken_date(Date taken_date) {
        this.taken_date = taken_date;
    }

    public float getPointPercent() {
        return pointPercent;
    }

    public void setPointPercent(float pointPercent) {
        this.pointPercent = pointPercent;
    }

    public float getNumQuesTrue() {
        return numQuesTrue;
    }

    public void setNumQuesTrue(float numQuesTrue) {
        this.numQuesTrue = numQuesTrue;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
    
    
}

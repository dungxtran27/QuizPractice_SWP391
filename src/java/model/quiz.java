/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;

/**
 *
 * @author dungmuahahaha
 */
public class quiz {
     private int quizId;
    private String title;
    private String level;
    private String imgUrl;
    private Time start_time;
    private Time end_time;
    private boolean status;
    private float rate;
    private boolean hasJoin;
    private int subId;
    private int userId;
    private int quesId;
    private int lessonId;
    private int duration;
    private String typeId;
    private String typeName;
    private String subjectName;
    private String description;
    private int totalQues;
    private int attempt;

    public quiz() {
    }

    public quiz(int quizId, String title, String level, String imgUrl, Time start_time, Time end_time, boolean status, float rate, boolean hasJoin, int subId, int userId, int quesId, int lessonId, int duration, String typeId, String typeName, String subjectName, String description, int totalQues, int attempt) {
        this.quizId = quizId;
        this.title = title;
        this.level = level;
        this.imgUrl = imgUrl;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.rate = rate;
        this.hasJoin = hasJoin;
        this.subId = subId;
        this.userId = userId;
        this.quesId = quesId;
        this.lessonId = lessonId;
        this.duration = duration;
        this.typeId = typeId;
        this.typeName = typeName;
        this.subjectName = subjectName;
        this.description = description;
        this.totalQues = totalQues;
        this.attempt = attempt;
    }
    public quiz(int quizId, String title, String level, boolean status, float rate, int subId, int lessonId, int duration, String typeId, String typeName, String subjectName, String description, int totalQues) {
        this.quizId = quizId;
        this.title = title;
        this.level = level;
        this.status = status;
        this.rate = rate;
        this.subId = subId;
        this.lessonId = lessonId;
        this.duration = duration;
        this.typeId = typeId;
        this.typeName = typeName;
        this.subjectName = subjectName;
        this.description = description;
        this.totalQues = totalQues;
    }

    public quiz(int quizId, String title, String level, String imgUrl, boolean status, float rate, int subId, int lessonId, int duration, String typeId, String typeName, String subjectName, String description, int totalQues, int attempt) {
        this.quizId = quizId;
        this.title = title;
        this.level = level;
        this.imgUrl = imgUrl;
        this.status = status;
        this.rate = rate;
        this.subId = subId;
        this.lessonId = lessonId;
        this.duration = duration;
        this.typeId = typeId;
        this.typeName = typeName;
        this.subjectName = subjectName;
        this.description = description;
        this.totalQues = totalQues;
        this.attempt = attempt;
    }

    public quiz(String title, String level, boolean status, float rate, int subId, int quesId, int duration, String typeId, String description, int totalQues, int attempt) {
        this.title = title;
        this.level = level;
        this.status = status;
        this.rate = rate;
        this.subId = subId;
        this.quesId = quesId;
        this.duration = duration;
        this.typeId = typeId;
        this.description = description;
        this.totalQues = totalQues;
        this.attempt = attempt;
    }

   

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public boolean isHasJoin() {
        return hasJoin;
    }

    public void setHasJoin(boolean hasJoin) {
        this.hasJoin = hasJoin;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalQues() {
        return totalQues;
    }

    public void setTotalQues(int totalQues) {
        this.totalQues = totalQues;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
    
}

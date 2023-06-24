/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungmuahahaha
 */
public class Question {
  
    private int questionId;
    private String content;
    private int subjectId;
    private int lessonId;
    private int topicId;
    private String level;
    private boolean status;
    private int quizId;
    private String dimension;
    private boolean isMultipleChoice;

    public Question(int questionId, String content, int subjectId, int lessonId, int topicId, String level, boolean status, int quizId, String dimension, boolean isMultipleChoice) {
        this.questionId = questionId;
        this.content = content;
        this.subjectId = subjectId;
        this.lessonId = lessonId;
        this.topicId = topicId;
        this.level = level;
        this.status = status;
        this.quizId = quizId;
        this.dimension = dimension;
        this.isMultipleChoice = isMultipleChoice;
    }

    public Question(int questionId, String content, int subjectId, int lessonId, int topicId, String level, boolean status, int quizId, boolean isMultipleChoice) {
        this.questionId = questionId;
        this.content = content;
        this.subjectId = subjectId;
        this.lessonId = lessonId;
        this.topicId = topicId;
        this.level = level;
        this.status = status;
        this.quizId = quizId;
        this.isMultipleChoice = isMultipleChoice;
    }

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public boolean isIsMultipleChoice() {
        return isMultipleChoice;
    }

    public void setIsMultipleChoice(boolean isMultipleChoice) {
        this.isMultipleChoice = isMultipleChoice;
    }
    
}

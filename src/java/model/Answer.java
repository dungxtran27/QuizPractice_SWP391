/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungmuahahaha
 */
public class Answer {
    
    private int answerId;
    private String content;
    private boolean correct;
    private int quesId;
    private boolean userCheck;

    public Answer() {
    }

    public Answer(int answerId, String content, boolean correct, int quesId, boolean userCheck) {
        this.answerId = answerId;
        this.content = content;
        this.correct = correct;
        this.quesId = quesId;
        this.userCheck = userCheck;
    }
  public Answer(int answerId, String content, boolean correct, int quesId) {
        this.answerId = answerId;
        this.content = content;
        this.correct = correct;
        this.quesId = quesId;
    }
    

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public boolean isUserCheck() {
        return userCheck;
    }

    public void setUserCheck(boolean userCheck) {
        this.userCheck = userCheck;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dungmuahahaha
 */
public class slider {
     private int sliderId;
    private String sliderUrl;
    private Boolean status;
    private String title;
    private String content;
    private String backlink;
    private String notes;
    private boolean isShow;
    private int subId;

    public slider() {
    }

    public slider(int sliderId, String sliderUrl, Boolean status, String title, String content, String backlink, String notes, boolean isShow, int subId) {
        this.sliderId = sliderId;
        this.sliderUrl = sliderUrl;
        this.status = status;
        this.title = title;
        this.content = content;
        this.backlink = backlink;
        this.notes = notes;
        this.isShow = isShow;
        this.subId = subId;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public String getSliderUrl() {
        return sliderUrl;
    }

    public void setSliderUrl(String sliderUrl) {
        this.sliderUrl = sliderUrl;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBacklink() {
        return backlink;
    }

    public void setBacklink(String backlink) {
        this.backlink = backlink;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isIsShow() {
        return isShow;
    }

    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
    
}

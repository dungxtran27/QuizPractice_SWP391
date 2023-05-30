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
public class Post {
     private int postId;
    private String thumbnail;
    private int userId;
    private int categoryBlogId;
    private String content;
    private Date created_date;
    private String edit_date;
    private Boolean status;
    private String brifInfor;
    private String title;
    private int postFileId;

    public Post(int postId, String thumbnail, int userId, int categoryBlogId, String content, Date created_date, String edit_date, Boolean status, String brifInfor, String title, int postFileId) {
        this.postId = postId;
        this.thumbnail = thumbnail;
        this.userId = userId;
        this.categoryBlogId = categoryBlogId;
        this.content = content;
        this.created_date = created_date;
        this.edit_date = edit_date;
        this.status = status;
        this.brifInfor = brifInfor;
        this.title = title;
        this.postFileId = postFileId;
    }
      public Post() {
        
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryBlogId() {
        return categoryBlogId;
    }

    public void setCategoryBlogId(int categoryBlogId) {
        this.categoryBlogId = categoryBlogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBrifInfor() {
        return brifInfor;
    }

    public void setBrifInfor(String brifInfor) {
        this.brifInfor = brifInfor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPostFileId() {
        return postFileId;
    }

    public void setPostFileId(int postFileId) {
        this.postFileId = postFileId;
    }
    
}

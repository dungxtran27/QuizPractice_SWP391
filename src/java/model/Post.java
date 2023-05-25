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
        private int userId;
        private String thumbnail;
        private int categoryBlogId;
        private String content;
        private String brifInfor ;
        private String title;
        private Date created_date;
        private Date edit_date;
        private boolean status;
        private int postFileId;

    public Post(int postId, int userId, String thumbnail, int categoryBlogId, String content, String brifInfor, String title, Date created_date, Date edit_date, boolean status, int postFileId) {
        this.postId = postId;
        this.userId = userId;
        this.thumbnail = thumbnail;
        this.categoryBlogId = categoryBlogId;
        this.content = content;
        this.brifInfor = brifInfor;
        this.title = title;
        this.created_date = created_date;
        this.edit_date = edit_date;
        this.status = status;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(Date edit_date) {
        this.edit_date = edit_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPostFileId() {
        return postFileId;
    }

    public void setPostFileId(int postFileId) {
        this.postFileId = postFileId;
    }
        
        
        
}

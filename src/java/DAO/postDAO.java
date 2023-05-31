/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.*;

/**
 *
 * @author dungmuahahaha
 */
public class postDAO extends MyDAO {

    public List<Post> getAllPost() {
        xSql = "select * from [Post] \n" +
"order by created_date desc ";
        List<Post> list = new ArrayList<>();

        int postId;
        int userId;
        String thumbnail;
        int categoryBlogId;
        String content;
        String brifInfor;
        String title;
        Date created_date;
        Date edit_date;
        boolean status;
        int postFileId;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {

                postId = rs.getInt("postId");
                thumbnail = rs.getString("thumbnail");

                userId = rs.getInt("userId");
                categoryBlogId = rs.getInt("categoryBlogId");
                content = rs.getString("content");
                created_date = rs.getDate("created_date");
                edit_date = rs.getDate("edit_date");
                status = rs.getBoolean("status");

                brifInfor = rs.getString("brifInfor");
                title = rs.getString("title");

                postFileId = rs.getInt("postFileId");

                list.add(new Post(postId, thumbnail, userId, categoryBlogId, content, created_date, title, status, brifInfor, title, postFileId));

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

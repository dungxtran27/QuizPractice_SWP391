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
        xSql = "select * from [Post] \n"
                + "order by created_date desc ";
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

    public List<Post> getPostByID(int postId) {
        ArrayList<Post> plist = new ArrayList<>();
        int xpostId;
        String xthumbnail;
        int xuserId;
        int xcategoryBlogId;
        String xcontent;
        Date xcreated_date;
        String xedit_date;
        Boolean xstatus;
        String xbrifInfor;
        String xtitle;
        int xpostFileId;
        try {
            //thumbnail, category, title, brief information,  description, flag to turn the featurning on/off, status)
            if (con != null) {
                xSql
                        = "SELECT  [postId]\n"
                        + "      ,[thumbnail]\n"
                        + "      ,[userId]\n"
                        + "      ,[categoryBlogId]\n"
                        + "      ,[content]\n"
                        + "      ,[created_date]\n"
                        + "      ,[edit_date]\n"
                        + "      ,[status]\n"
                        + "      ,[brifInfor]\n"
                        + "      ,[title]\n"
                        + "      ,[postFileId]\n"
                        + "  FROM [SWP391_DB].[dbo].[Post]\n"
                        + "  where postId=?";
                ps = con.prepareStatement(xSql);
                ps.setInt(1, postId);
                rs = ps.executeQuery();
                while (rs.next()) {
                     xpostId = rs.getInt("postId");
                    xthumbnail= rs.getString("thumbnail");
                    xuserId = rs.getInt("userId");
                    xcategoryBlogId=rs.getInt("categoryBlogId");
                    xcontent=rs.getString("content");
                    xcreated_date=rs.getDate("created_date");
                    xedit_date=rs.getString("edit_date");
                    xstatus =rs.getBoolean("status");
                    xbrifInfor=rs.getString("brifInfor");
                    xtitle=rs.getString("title");
                    xpostFileId =rs.getInt("postFileId");
                   

                    plist.add(new Post(postId, xthumbnail, xuserId, xcategoryBlogId, xcontent, xcreated_date, xedit_date, xstatus, xbrifInfor, xtitle, xpostFileId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return plist;
    }

}

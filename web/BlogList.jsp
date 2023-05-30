<%-- 
    Document   : BlogList
    Created on : May 22, 2023, 10:25:31 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>
<%
    List<Blog> blist = (List<Blog>)request.getAttribute("blist");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="NavbarStyle.css">
        <title>Manage Blog</title>
    </head>
    <body>
        <div id="content">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">
                                <li>
                                    <form action="SearchBlog" method="POST">
                                        <p><input type="text" name="blogName" value=""/>
                                        <input type="submit" value="Search"> 
                                    </form>  
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="profile.jsp">Profile</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="post.jsp">post</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="BlogList">Blog</a>
                                </li>
                                <li class="nav-item">
                                    <a class="rr" href=""><img style="width: 40px" src="img/roll.jpg" alt="alt"/></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
        </div>
        
        <div class="list">
            <%
            if (blist == null || blist.size() == 0) {
            %>
            <h1>No blogs found</h1>
            <% } else {
                for (Blog bl : blist) {
            %>
            <a class="a card" href="#">
                <div style="display: flex" class="">
                    <div style="text-align: left;" class="">
                        <h5>Blog Id: <%=bl.getBlogId()%></h5>
                        <h5>Blog name: <%=bl.getBlogName()%></h5>
                        <h5>Sub Id: <%=bl.getSubId()%></h5>
                    </div>
                </div>
            </a>
            <% }
    } %>
        </div>
    </body>
</html>

<%-- 
    Document   : header
    Created on : Jun 2, 2023, 5:03:37 PM
    Author     : dungmuahahaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User userheader = (User)request.getSession().getAttribute("currUser");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .avatar {
                display: inline-flex;
                width: 50px;
                height: 50px;
                border-radius: 50%;
            }
            .dropdown-toggle::after {
                display: none;
            }
            .dropdown:hover .dropdown-menu {
                display: block;
                margin-top: 0;
            }
            .dropdown-menu {
                margin-top: 0;
                border-radius: 0;
                box-shadow: none;
                border: none;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <a href="Home.jsp">
                        <span>Home Page</span></a>
                </button>
                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" 
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" 
                        aria-label="Toggle navigation">
                    <i class="fas fa-align-justify"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="nav navbar-nav ml-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="post.jsp">post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Page</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="BlogList">Blog</a>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <% if(userheader ==null||userheader.getAvatar()==null){%>
                                <a href="profile.jsp" class="avatar dropdown-toggle" id="avatarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="./img/roll.jpg" alt="Avatar">
                                </a>
                                <%}else{%>
                                <a href="profile.jsp"  class="avatar dropdown-toggle" id="avatarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="${sessionScope.currUser.avatar}" alt="Avatar">
                                </a>
                                <%}%>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="avatarDropdown">
                                    <a class="dropdown-item" href="profile.jsp">Profile</a>
                                    <a class="dropdown-item" href="#">Settings</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="logout">Logout</a>
                                </div>
                            </div>

                        </li>
                    </ul>
                </div>
            </div>
        </nav>    </body>
</html>

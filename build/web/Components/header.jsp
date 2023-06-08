<%-- 
    Document   : header
    Created on : Jun 2, 2023, 5:03:37 PM
    Author     : dungmuahahaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-info">
                            <i class="fas fa-align-left"></i>
                            <span>Home Page</span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
                                   <% if(u==null){%>
                                     <a href="profile.jsp">
                                        <img src="./img/roll.jpg" alt="Avatar" class="avatar">
                                    </a>
                                     <%}else{%>
                                    <a href="profile.jsp">
                                        <img src="${sessionScope.currUser.avatar}" alt="Avatar" class="avatar">
                                    </a>
                                    <%}%>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>    </body>
</html>

<%-- 
    Document   : post.jsp
    Created on : May 29, 2023, 12:28:22 PM
    Author     : dungmuahahaha
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>

<%
    post p = (animalInfo)request.getAttribute("post");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!  <%=p.getTitle()%></h1>
    </body>
</html>

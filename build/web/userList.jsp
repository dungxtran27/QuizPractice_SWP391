<%-- 
    Document   : test
    Created on : Jun 5, 2023, 11:01:50 PM
    Author     : dungmuahahaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>
<!DOCTYPE html>
<%
    User u = (User)request.getSession().getAttribute("currUser");
    if(u == null){
       response.setStatus(response.SC_MOVED_TEMPORARILY);
       response.setHeader("Location", "SignIn.jsp");
       return;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
       if(u.getRole().getRole_id()!=1){
       
       %>
       <h1>not authorized</h1>
              

       <%
           }else{%>
        
        
        <h1><%=u.getRole().getRole_id()%></h1>
         <h1> m là adminic</h1>
        <%}%>
    </body>
</html>

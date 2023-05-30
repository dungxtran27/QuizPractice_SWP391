<%-- 
    Document   : searchblog
    Created on : May 30, 2023, 3:50:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>\
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search result</title>
  </head>
  <body>
     <%
      List<Blog> blist = (List<Blog>)request.getAttribute("bl");
     %>    
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
     
     
     <p><button onclick='window.history.go(-1);'>Back to previous page</button>
  </body>
</html>

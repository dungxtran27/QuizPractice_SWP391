<%-- 
    Document   : test
    Created on : May 25, 2022, 8:15:23 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Custom scripts -->
        <%@include file="Components/AllAccess.jsp"%>
       
      
    </head>

    <body class="sb-sidenav-toggled">
        <div class="wrapper">

            <!-- Sidebar  -->
            <div style="" id="header">
                <%@include file="Components/Sidebar.jsp" %>
            </div>

            <!-- Page Content  -->
            <div id="content">



                <%@include file="Components/header.jsp" %>

                <div id="layoutSidenav">
                    <div id="layoutSidenav_content">
                        <div class="container px-4 px-lg-5" style="margin-top: 91px">
                            <!-- Heading Row-->
                            
                                <c:forEach items="${plistById}" var="p">
                                    <div style="font-size:30px"> <b class="mb-2" >Title: </b>${p.getTitle()}<br></div>
                                   <img class="img-fluid rounded mb-4 mb-lg-0 mx-auto d-block" style="height: 400px" src="${p.thumbnail}" alt="..." />
                                    
                                       
                                        <b class="mb-2">Description: </b>${p.getBrifInfor()}<br>
                                        <b class="mb-2">content: </b>${p.getContent()}<br>
                                 

                                </c:forEach>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>








        <div class="footer" >
            <%@include file="Components/footer.jsp" %>
        </div>

    </body>



</html>

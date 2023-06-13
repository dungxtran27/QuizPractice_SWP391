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
        <style>
            .avatar {
                width: 50px; /* Điều chỉnh kích thước theo ý muốn */
                height: 50px; /* Điều chỉnh kích thước theo ý muốn */
                border-radius: 50%;
            }
        </style>
        <script type="text/javascript"></script>
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
                            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                                <c:forEach items="${plistById}" var="p">
                                    <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0 mx-auto d-block" style="height: 400px" src="${p.thumbnail}" alt="..." /></div>
                                    <div class="col-lg-5">
                                        <b class="mb-2">Title: </b>${p.getTitle()}<br>
                                        <b class="mb-2">Description: </b>${p.getBrifInfor()}<br>
                                        <b class="mb-2">content: </b>${p.getContent()}<br>
                                    </div>

                                </c:forEach>
                            </div>
                            <!-- Call to Action-->
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

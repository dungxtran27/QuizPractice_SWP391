<%-- 
    Document   : MyRegistration
    Created on : Jun 22, 2023, 9:22:59 AM
    Author     : admin
--%>
<%
    subjectListDAO sd;
    sd = new subjectListDAO();
    List<subject> slist = sd.getAllSubject();
    request.setAttribute("slist", slist);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="container-fluid px-4 px-lg-5 mb-5" style="margin-top: 91px">
                    <h1>My Registrations</h1>
                    <div class="row mt-5">
                        <c:forEach var="c" items="${rlist}">
                            <div class="col-md-4 mb-3 mx-auto d-block shadow p-3 mb-5 bg-white rounded"
                                 style="padding: 10px 0px 10px 10px; border-radius: 8px; width: 32%; margin-left: 10px">
                                <form action="subject-detail" method="POST">
                                    <img class="mx-auto d-block" src="${c.subject.thumbnail}" />
                                    <h2 class="text-center">${c.subject.subjectName}</h2>
                                    <ul style="margin-left: 8%">
                                        <li><b>Price: ${c.pricePackage.price}</b></li>
                                        <li><b>Date: ${c.regisDate}</b></li>                                               
                                        <li><b>Status: ${c.statis}</b></li>                                               
                                    </ul>
                                    <div class="text-center">
                                        <a href="subject-detail?subId=${c.subject.subjectId}" class="btn btn-success">Detail</a>
                                    </div>
                                </form>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

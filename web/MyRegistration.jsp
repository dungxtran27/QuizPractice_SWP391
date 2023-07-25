<%-- 
    Document   : MyRegistration
    Created on : Jun 22, 2023, 9:22:59 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                            <div class ="row">
                                <div class="table-responsive">
                                    <table class="table  table-bordered table-hover table-striped">
                                        <thead class="thead-dark">
                                            <tr class="text-center col-md-12">
                                                <th class="col-1">Subject ID</th>
                                                <th class="col-3">Subject name</th>
                                                <th class="col-2">Regist Date</th>
                                                <th class="col-2">Price Package</th>
                                                <th class="col-1">status</th>

                                                <th class="col-1">Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="r" items="${rlist}">
                                                <tr class="text-center">
                                                    <td>${r.subjectId}</td>
                                                    <td>${r.getSubjectName()}</td>

                                                    <td>${r.regisDate}</td>
                                                    <td>${r.getPriceName()}</td>

                                                    <td>${r.status==true?"done":"not done"}</td>
                                                    <td>unEnroll</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="paging" >
            <c:choose>
                <c:when test="${rlist==null ||rlist.size()==0}">
                    Not founds
                </c:when>
                <c:when test="${totalPage < 2}">
                    <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                        <ul class="pagination">
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <li class="page-item ${i == page?"active":""}"><a class="page-link" href="${pagination_url}page=${i}">${i}</a></li>
                                </c:forEach>
                        </ul>
                    </nav>
                </c:when>
                <c:when test="${page < 2}">
                    <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                        <ul class="pagination">                               
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <li class="page-item ${i == page?"active":""}"><a class="page-link" href="${pagination_url}page=${i}">${i}</a></li>
                                </c:forEach>
                            <li class="page-item"><a class="page-link" href="${pagination_url}page=${page+1}">Next</a></li>
                        </ul>
                    </nav>
                </c:when>
                <c:when test="${page+1 > totalPage}">
                    <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="${pagination_url}page=${page-1}">Previous</a></li>
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                <li class="page-item ${i == page?"active":""}"><a class="page-link" href="${pagination_url}page=${i}">${i}</a></li>
                                </c:forEach>
                        </ul>
                    </nav>
                </c:when>
                <c:otherwise>
                    <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="${pagination_url}page=${page-1}">Previous</a></li>
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                <li class="page-item ${i == page?"active":""}"><a class="page-link" href="${pagination_url}page=${i}">${i}</a></li>
                                </c:forEach>
                            <li class="page-item"><a class="page-link" href="${pagination_url}page=${page+1}">Next</a></li>
                        </ul>
                    </nav>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="footer"> <%@include file="Components/footer.jsp" %></div>

    </body>
</html>

<%-- 
    Document   : userPage
    Created on : Jun 20, 2023, 4:24:38 PM
    Author     : dungmuahahaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/AllAccess.jsp"%>

    </head>
    <body>
        <div class="wrapper">
            <div style="" id="header">
                <%@include file="Components/Sidebar.jsp" %>
            </div>
            <div id="content">
                <%@include file="Components/header.jsp" %>
                 <h2>quiz practice</h2>
                <div>
                    <table class="table table-hover table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>Quiz ID</th>
                            <th>Total Point</th>
                            <th>pointPercent </th>
                            <th>Attempt</th>
                            <th>taken_date</th>
                            <th>Review</th>
                            

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="qp" items="${qplist}">
                            <tr>
                                <td>${qp.getQuizId()}</td>
                                <td>${qp.getPoint()}</td>
                                <td>${qp.getPointPercent()}</td>
                                <td>${qp.getAttempt()}</td>
                                <td>${qp.getTaken_date()}</td>
                                <td><a href="ReviewQuizzServlet?quizzId=${qp.getQuizId()}&attempt=${qp.getAttempt()}&subId=${qp.getSubId()}" class="btn btn-warning">review</a></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                    <c:choose>
            <c:when test="${sessionScope.qplist==null || sessionScope.qplist.size()==0}">
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

            </div>
        </div>


        <div class="footer" >
            <%@include file="Components/footer.jsp" %>
        </div>    </body>
</html>

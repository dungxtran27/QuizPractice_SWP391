<%-- 
    Document   : BlogList
    Created on : May 22, 2023, 10:25:31 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/NavbarStyle.css">
    </head>
        
    <body>
        <c:set var="a" value="${sessionScope.acc}"></c:set>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">BlogId</th>
                        <th scope="col">BlogName</th>
                        <th scope="col">SubId</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listB}" var="blog">
                    <c:if test="${acc.username!=a.username}">
                    <tr>
                        <td>${blog.BlogId}</td>
                        <td>${blog.BlogName}</td>
                        <td>${blog.SubId}</td>
                    </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</html>

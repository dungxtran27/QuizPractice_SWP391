<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/AllAccess.jsp"%>
      
    </head>

    <body class="sb-sidenav-toggled">

        <div class="wrapper">
            <%@include file="Components/Sidebar.jsp" %>
            <div class="content" style="width:100%">
                <%@include file="Components/header.jsp" %>
                    
                  
                <div class="container-fluid px-4 px-lg-5 mb-5" style="margin-top: 91px">
                    
                
                    <h1>Student List</h1>
                    <div class ="row">
                       
                            <table class="table  table-bordered table-hover table-striped">
                                <thead class="thead-dark">
                                    <tr class="text-center col-md-12">
                                        <th class="col-1">ID</th>
                                        <th class="col-3">fullname</th>
                                        <th class="col-1">email</th>
                                        <th class="col-2">phone</th>
                                        <th class="col-1">address</th>
                                        <th class="col-1">gender</th>
                                      
                                        <th class="col-2">Action</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="u" items="${listStudent}">
                                        <tr class="text-center">
                                            <td>${u.userid}</td>
                                            <td>${u.fullname}</td>
                                            <td>${u.email}</td>
                                            <td>${u.phone}</td>
                                            <td>${u.address}</td>
                                            <td>${u.gender==true?"male":"female"}</td>
                                          
                                            <td>delete</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                       
                    </div>
           
                </div>


            </div>
        </div>
        <div class="paging">
            <c:choose>
                <c:when test="${listStudent==null || listStudent.size()==0}">
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







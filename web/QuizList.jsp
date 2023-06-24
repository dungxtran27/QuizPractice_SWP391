<%-- 
    Document   : test
    Created on : May 25, 2022, 8:15:23 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/AllAccess.jsp"%>
        <style>
            .avatar {
                width: 50px; /* Điều chỉnh kích thước theo ý muốn */
                height: 50px; /* Điều chỉnh kích thước theo ý muốn */
                border-radius: 50%;
            }
        </style>

        <!-- Custom scripts -->
        <script type="text/javascript"></script>
    </head>

    <body class="sb-sidenav-toggled">

        <div class="wrapper">
            <%@include file="Components/Sidebar.jsp" %>
            <div class="content">
                 <%@include file="Components/header.jsp" %>
                  <div class="container-fluid px-4 px-lg-5 mb-5" style="margin-top: 91px">
                    <h1>Quiz List</h1>
                    <c:if test="${sessionScope.checkSuccess == 'false'}">
                        <p class="text-danger">${sessionScope.messageStatusQuiz}</p>
                    </c:if>
                    <c:if test="${sessionScope.checkSuccess == 'true'}">
                        <p class="text-success">${sessionScope.messageStatusQuiz}</p>
                    </c:if>
                    <form action="search-quiz" method="POST" style="width: 900px; float: right !important">

                        <div class="input-group">
                            <select name="subId" class="form-control ms-2" style="margin: 2px" onchange="this.form.submit()">
                                <option value="0">All Subject</option>
                                <c:forEach items="${listSubjects}" var="S">
                                    <option value="${S.subjectId}" ${S.subjectId == requestScope.subId?"selected":""}>${S.subjectName}</option>
                                </c:forEach>
                            </select>
                            <select name="typeId" class="form-control ms-2" style="margin: 2px" onchange="this.form.submit()">
                                <option value="Q0">All Type</option>
                                <c:forEach items="${listTypeQuizes}" var="TQ">
                                    <option value="${TQ.typeId}" ${TQ.typeId == requestScope.typeId?"selected":""}>${TQ.typeName}</option>
                                </c:forEach>
                            </select>
                            <input type="search" name="keyword" id="form1" value="${requestScope.keyword}" class="form-control ms-2 mb-2 py-3" style="height: 38px !important;" placeholder="Search by name"/>
                            <button type="submit" class="btn btn-primary mb-2">
                                <i class="fas fa-search"></i>
                            </button>

                        </div>
                    </form>

                    <div class ="row" style="margin-top: 80px">
                        
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead class="thead-dark">
                                    <tr class="text-center">
                                        <th>ID</th>
                                        <th>Exam Name</th>
                                        <th>Level</th>
                                        <th>Subject</th>
                                        <th>NumQues</th>
                                        <th>Duration</th>
                                        <th>Pass Rate</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listQuizzesByPagging}" var="Q">
                                        <tr class="text-center">
                                            <td>${Q.quizId}</td>
                                            <td>${Q.title}</td>
                                            <td>${Q.level}</td>
                                            <td>${Q.subjectName}</td>
                                            <td>${Q.totalQues}</td>
                                            <td>${Q.duration} (mins)</td>
                                            <td>${Q.rate} (%)</td>
                                            <td>
                                                <a href="QuizHandle?quizzId=${Q.quizId}&subId=${Q.subId}&method=get" class="btn btn-primary">Do Quiz</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div><br>
                    </div>
                
        </div>
        <c:choose>
            <c:when test="${sessionScope.listQuizzesByPagging==null || sessionScope.listQuizzesByPagging.size()==0}">
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
        <div class="footer"> <%@include file="Components/footer.jsp" %></div>
    
              


    </body>
</html>
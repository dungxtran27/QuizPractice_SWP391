<%-- 
    Document   : QuestionList
    Created on : Jul 12, 2023, 8:56:38 AM
    Author     : dungmuahahaha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/AllAccess.jsp"%>
    </head>

    <body>

        <div class="wrapper">
            <%@include file="Components/Sidebar.jsp" %>
            <div class="content">
                <%@include file="Components/header.jsp" %>
                <div class="container-fluid px-4 px-lg-5 mb-5" style="margin-top: 91px">

                    <h1>Question List</h1>
                    <div class ="row mt-5">

                        <form action="DispatchServlet" method="POST" class="col-7 row d-flex" style="float: right !important">
                            <div class="col-3 p-0">
                                <select class="form-control" name="subjectIdFilter">
                                    <option value="0">All subject</option>
                                    <c:forEach var="s" items="${listSubject}">
                                        <option value="${s.subjectId}" ${s.subjectId==requestScope.subjectId?"selected":"" } >${s.subjectName}</option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="col-2 p-0">
                                <button name="btAction" value="FilterQuestion" type="submit" class="btn btn-primary ms-4 " style="border-radius: 5px !important">Filter</button>
                            </div>
                        </form>

                        <div class="col-3 px-1 d-flex">
                            <form action="search-question" method="POST" class="d-flex">
                                <div class="input-group w-100">
                                    <input type="search" name="keyword" id="form1" class="form-control" placeholder="Search"/>
                                    <!--<label class="form-label" for="form1">Search</label>-->
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </form>
                        </div>

                        <div class="my-3">
                            <c:if test="${message!=null}">
                                ${message}
                            </c:if>
                            <c:if test="${message==null}">
                                <c:forEach var="q" items="${listQuestion}">
                                    <div class="mb-3 mx-auto d-block shadow p-3 mb-5 bg-white rounded" style="padding: 10px 10px 10px 10px; border-radius: 8px; width: 32%; margin-left: 10px; width: 100% !important">
                                        <div class="row">
                                            <b class="col-10">${q.questionId}: ${q.contentQuestion} (${q.level})</b>
                                            <b class="col-2">
                                                <div class="row">

                                                    <div class="col-6">
                                                        <c:if test="${q.status eq 'true'}">
                                                            <a href="delete-question?questionId=${q.questionId}&status=false" class="btn btn-danger" >Inactive</a>
                                                        </c:if>
                                                        <c:if test="${q.status ne 'true'}">
                                                            <a href="delete-question?questionId=${q.questionId}&status=true" class="btn btn-primary" >Active</a>
                                                        </c:if>
                                                    </div>
                                                    <div class="col-6">
                                                        <a href="question-detail?questionId=${q.questionId}" class="btn btn-primary text-decoration-none" style="color: white;">Detail</a>
                                                    </div>
                                                </div>
                                            </b>

                                        </div>

                                        <br>
                                        <div class="row d-flex mt-3 pt-2" style="border-top: 1px solid silver">
                                            <div class="col-3">
                                                Subject: ${q.subject.subjectName}
                                            </div>
                                            <div class="col-3">
                                                ${q.lesson.lessonName}- ${q.lesson.content}
                                            </div>
                                            <div class="col-3 ">
                                                Dimension: ${q.dimmension.name}
                                            </div>
                                            <div class="col-3 ">
                                                Topic: ${q.topic.topicName}
                                            </div>

                                        </div>

                                    </div>
                                </c:forEach>
                            </c:if>


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:choose>
            <c:when test="${listQuestion==null || listQuestion.size()==0}">
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
        <div class="footer"> <%@include file="Components/footer.jsp" %></div>
    </body>
</html>


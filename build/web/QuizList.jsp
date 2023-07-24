<%-- 
    Document   : test
    Created on : May 25, 2022, 8:15:23 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  User us = (User)request.getSession().getAttribute("currUser");
  if(us == null){
     response.setStatus(response.SC_MOVED_TEMPORARILY);
     response.setHeader("Location", "SignIn.jsp");
     return;
  }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/AllAccess.jsp"%>
       
     
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
                    <c:if test="${sessionScope.checkSuccess == 'true'}">
                        <p class="text-warning">${sessionScope.WARNING}</p>
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
                            <%
                          if(us.getRole().getRole_id()==1||us.getRole().getRole_id()==3){

                            %>
                            <a href="quiz-detail?action=add-quiz&message=0" class="btn btn-primary ms-4 pt-2" style="border-radius: 5px; height: 39px; padding-top: 10px; padding-top: 14px !important;"/>Add New</a>


                            <%}%>
                        </div>
                    </form>

                    <div class ="row" style="margin-top: 80px">

                        <div class="table-responsive">
                            <table class="table  table-bordered table-hover table-striped">
                                <thead class="thead-dark">
                                    <tr class="text-center col-md-12">
                                        <th class="col-1">ID</th>
                                        <th class="col-3">Exam Name</th>
                                        <th class="col-1">Level</th>
                                        <th class="col-2">Subject</th>
                                        <th class="col-1">Total questions</th>
                                        <th class="col-1">Duration</th>
                                        <th class="col-1">Pass Rate</th>
                                        <th class="col-2">Action</th>

                                    </tr>
                                </thead>
                                <tbody>


                                    <%
                         if(us.getRole().getRole_id()==1||us.getRole().getRole_id()==3){
       
                                    %>
                                    <c:forEach items="${listQuizzesByPaggingAd}" var="Q">
                                        <tr class="text-center">
                                            <td>${Q.quizId}</td>
                                            <td class="titleQuiz"><a href="QuestionList?quizzId=${Q.quizId}">${Q.title}</a></td>
                                            <td>${Q.level}</td>
                                            <td>${Q.subjectName}</td>
                                            <td>${Q.totalQues}</td>
                                            <td>${Q.duration} (mins)</td>
                                            <td>${Q.rate} (%)</td>

                                            <td>
                                                <c:if test="${Q.status == 'true'}">
                                                    <a href="hide-quiz?quizId=${Q.quizId}" class="btn btn-danger ms-3"/>Inactive</a>
                                                </c:if>
                                                <c:if test="${Q.status == 'false'}">
                                                    <a href="show-quiz?quizId=${Q.quizId}" class="btn btn-success ms-3"/>Active</a>
                                                </c:if>
                                                <a href="quiz-detail?quizId=${Q.quizId}&action=edit-quiz&message=0" class="btn btn-primary"/>Detail</a>
                                            </td>

                                        </tr>
                                    </c:forEach>


                                    <%
                          }else{%>


                                    <c:forEach items="${listQuizzesByPagging}" var="Q">
                                        <tr class="text-center">
                                            <td>${Q.quizId}</td>
                                            <td class="titleQuiz">${Q.title}</td>
                                            <td>${Q.level}</td>
                                            <td>${Q.subjectName}</td>
                                            <td>${Q.totalQues}</td>
                                            <td>${Q.duration} (mins)</td>
                                            <td>${Q.rate} (%)</td>

                                            <td>
                                                <a href="QuizHandle?quizzId=${Q.quizId}&subId=${Q.subId}" class="btn btn-primary">Do Quiz</a>
                                            </td>


                                        </c:forEach>     
                                        <%}%>   
                                </tbody>
                            </table>
                        </div><br>
                    </div>

                </div>

            </div>
        </div>
        <div class="paging" >
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
        <div class="footer"> <%@include file="Components/footer.jsp" %></div>




    </body>
</html>

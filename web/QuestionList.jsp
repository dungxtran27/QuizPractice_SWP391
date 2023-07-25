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

                     <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                        Add Question
                    </button>
                    
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="InsertQuestion">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Insert Question</h5>
                                    </div>
                                    <div class="modal-body">
                                        <p>Insert Content</p>
                                        <input type="hidden" name="subId" value="${requestScope.subId}" />
                                        <input type="hidden" name="quizzId" value="${requestScope.quizId}">
                                        <input type="text" name="content" value="" class="form-control">
                                      
                                        <input class="form-check-input" style="margin-left: 0px" name="isMultiple" type="checkbox" value="" id="flexCheckChecked">
                                          <label class="form-check">Is Multiple</label>
                                        <br>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <input type="submit" value="insert" name="action" class="btn btn-primary"/>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                    <div class ="row mt-5">
                        <form action="FilterController" method="POST" class="col-7 row d-flex" style="float: right !important">

                            <div class="col-7 row d-flex" >
                                <input type="hidden" name="quizzId" value="quizzId">
                                <div class="col-3 p-0">
                                    <select class="form-control" name="subjectIdFilter">
                                        <option value="0">All subject</option>
                                        <c:forEach var="s" items="${listSubject}">
                                            <option value="${s.subjectId}" ${s.subjectId==requestScope.subjectId?"selected":"" } >${s.subjectName}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="">
                                    <select class="form-control" name="statusFilter">
                                        <option value="1"  ${1==requestScope.status?"selected":"" }> Active</option>
                                        <option value="0" ${0==requestScope.status?"selected":"" }>Inactive</option>
                                    </select>
                                </div>

                                <div class="col-2 p-0">
                                    <button name="btAction" type="submit" class="btn btn-primary ms-4 " style="border-radius: 5px !important">Filter</button>
                                </div>

                            </div>
                        </form>
                        <div class="col-3 px-1 d-flex">
                            <form action="search-question" method="POST" class="d-flex">
                                <input type="hidden" name="quizzId" value="quizzId">

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
                            <c:forEach var="q" items="${listQuestion}">

                                <div class="mb-3 mx-auto d-block shadow p-3 mb-5 bg-white rounded" >
                                    <div class="row">
                                        <b class="col-10">${q.questionId}: ${q.content} (${q.level})</b>
                                        <b class="col-2">
                                            <div class="row">

                                                <div class="col-6">
                                                    <c:if test="${q.status == true}">
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


                                </div>
                            </c:forEach>



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


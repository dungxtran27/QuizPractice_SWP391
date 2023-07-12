<%-- 
    Document   : doQuizz
    Created on : Jun 27, 2022, 5:34:11 PM
    Author     : Fangl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/AllAccess.jsp"%>

        <!-- Custom scripts -->
        <script type="text/javascript"></script>

        <style>
            .account-div{
                position: relative;
            }

            .account-table{
                display: none;
                position: absolute;
                top: 34px;
                right: 0;
                width: 160px;
                border-radius: 5px;
                padding: 10px;
            }

            .account-div:hover .account-table{
                display: block;
            }
        </style>
    </head>
    <body class="sb-sidenav-toggled" onload="timerfunction()">

        <header class="sb-nav-fixed"><nav class="sb-topnav navbar navbar-expand navbar-light py-3" style=" background-image: url(''); background-color: #FFC533; height: 70px">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <div class="row p-2 d-flex">
                        <div>Your Time: </div><p class="p-1 form-control text-center bg-light text-dark my-auto ms-2" style="width: 90px" id="timer"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path d="M12.5 7.25a.75.75 0 00-1.5 0v5.5c0 .27.144.518.378.651l3.5 2a.75.75 0 00.744-1.302L12.5 12.315V7.25z"></path><path fill-rule="evenodd" d="M12 1C5.925 1 1 5.925 1 12s4.925 11 11 11 11-4.925 11-11S18.075 1 12 1zM2.5 12a9.5 9.5 0 1119 0 9.5 9.5 0 01-19 0z"></path></svg></p>
                    </div>
                </div>


                </div>
            </nav>
        </header>
        <div class="col-lg-4">
            <!-- Side widgets-->

        </div>
        <div id="layoutSidenav" class="mb-4">
            <div id="layoutSidenav_content">
                <div class="container-fluid px-4 px-lg-5 mb-5" style="margin-top: 91px">
                    <p class="fs-1 fw-bold">Quiz Name: ${QUIZZ.title}</p>
                    <p class="fs-2 fw-light">Total Question: ${QUIZZ.totalQues}</p>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10">

                                <!-- Blog entries-->
                                <form action="QuizHandle" method="post" id="myForm">
                                    <input type="hidden" name="quizzId" value="${requestScope.quizzId}" />
                                    <input type="hidden" name="subId" value="${requestScope.subId}" />
                                    <input type="hidden" name="attempt" value="${requestScope.attempt}" />
                                    <div class="row">
                                        <div class="col-12">
                                            <div>
                                                <ol type="1">
                                                    <c:forEach var="questionMap" items="${sessionScope.DO_QUIZZ}">
                                                        <div class="mb-3 mx-auto d-block shadow p-3 mb-5 bg-white rounded" style="padding: 10px 10px 10px 10px; border-radius: 8px; width: 32%; margin-left: 10px; width: 100% !important">
                                                            <li class="ms-3">
                                                                <span>${questionMap.getContent()} </span>
                                                                <input type="hidden" name="questionId" value="${questionMap.questionId}">
                                                                <ol type="A" class="mt-3">
                                                                    <c:if test="${questionMap.isIsMultipleChoice() == true}">
                                                                        <c:forEach var="ans" items="${questionMap.getAnswer()}">
                                                                            <li class="d-flex mb-1">
                                                                                <input type="checkbox" name="answer_${questionMap.questionId}" value="${ans.answerId}" class="col-1" style="width: 14px">
                                                                                <span class="col-11"><input type="text" name="name" value="${ans.content}" class="col-6 form-control ms-2" readonly></span>
                                                                            </li>
                                                                        </c:forEach>
                                                                    </c:if>
                                                                    <c:if test="${questionMap.isIsMultipleChoice() != true}">
                                                                        <c:forEach var="ans" items="${questionMap.getAnswer()}">
                                                                            <li class="d-flex mb-1 row">
                                                                                <input type="radio" name="answer_${questionMap.questionId}" value="${ans.answerId}" class="col-1" style="width: 14px">
                                                                                <span class="col-11"><input type="text" name="name" value="${ans.content}" class="col-6 form-control ms-2" readonly></span>
                                                                            </li>
                                                                        </c:forEach>
                                                                    </c:if>
                                                                </ol>
                                                            </li>
                                                        </div>
                                                        <br>
                                                    </c:forEach>
                                                </ol>
                                                <div class="col-12">
                                                    <div class="d-flex justify-content-center">
                                                        <!--<button type="submit" class="btn btn-primary px-4 py-2 fw-bold">check</button>-->
                                                        <button type="submit" name="btnAction" value="submitQuizz" class="btn btn-primary px-4 py-2 fw-bold">Submit</button> 
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>



                        </div>

                    </div>
                </div>
            </div>
        </div>

        <script>
           function timerfunction() {
        <% HttpSession session1 = request.getSession();%>
            var minute = <%=(int) session1.getAttribute("TIMER")%>;
            minute--;
            var sec = 59;
            setInterval(function () {
                document.getElementById("timer").innerHTML = minute + " : " + sec;
                sec--;
                if (sec == 00) {
                    minute--;
                    sec = 60;
                    if (minute == 0) {
//                            minute = 5;
                    }
                }
                if (minute == 0 && sec == 1) {
                    document.getElementById("myForm").submit();
                }
            }, 1000);
        }

        </script>



    </body>
</html>

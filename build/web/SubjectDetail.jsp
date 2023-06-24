<%-- 
    Document   : SubjectDetail
    Created on : Jun 8, 2023, 9:05:39 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>

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
        <script>
            function openPopup (popupId) {
            document.getElementById (popupId).classList.remove("popup-hidden");
            function closePopup (popupId) {
            document.getElementById (popupId).classList.add("popup-hidden");
        </script>
    </head>

    <body class="sb-sidenav-toggled">
        <div class="wrapper">

            <!-- Sidebar  -->
            <div style="" id="header">
                <%@include file="Components/sideBar2.jsp" %>
            </div>

            <!-- Page Content  -->
            <div id="content">



                <%@include file="Components/header.jsp" %>

                <div id="layoutSidenav">
                    <div id="layoutSidenav_content">
                        <div class="container px-4 px-lg-5" style="margin-top: 91px">
                            <!-- Heading Row-->
                            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                                <c:forEach items="${listSubjectBySubjectId}" var="SBSI">
                                    <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0 mx-auto d-block" style="height: 400px" src="${SBSI.thumbnail}" alt="..." /></div>
                                    <div class="col-lg-5">
                                        <h1 class="font-weight-light mb-4">${SBSI.subjectName}</h1>
                                      <b class="mb-2">Title:  </b>${SBSI.getTitle()}<br>
                                      <b class="mb-2">Description: </b>${SBSI.description}<br>
                                     <b class="mb-4">Price: </b>3200-10000<br>
                                        <button type="submit" class="btn btn-primary mt-4 me-3" data-toggle="modal" data-target="#SBSI${SBSI.getSubjectId()}">Register ${SBSI.subjectName}</button>
                                        <div id="SBSI${SBSI.getSubjectId()}"  class="modal fade" tabindex="-1" role="dialog">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <!--<button type="button" class="close btn btn-danger" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
                                                        <h4 class="modal-title">Choose price package </h4>
                                                    </div>
                                                    <form action="subject-register">
                                                        <div class="modal-body">
                                                            <div class="my-3 col-12">
                                                                <b>Price Package:
                                                                    <input type="text" value="${SBSI.getSubjectId()}" name="id" style="display:none"/>
                                                                    <select name="priceId" class="form-control" onchange="PricePackageAsync(this.value)">
                                                                        <c:forEach items="${listAllPricePackage}" var="PP">
                                                                            <option value="${PP.priceId}">${PP.name}</option>
                                                                        </c:forEach>
                                                                    </select></b>
                                                                <div class="mt-3" id="update_price_async">
                                                                    <p>SalePrice - Price : ${SBSI.getSalePrice()} - ${SBSI.getPrice()}</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                            
                                                            <button type="submit" class="btn btn-primary">Register</button>
                                                            
                                                        </div>
                                                    </form>

                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal-dialog -->
                                        </div><!-- /.modal -->
                                    </div>

                                </c:forEach>
                            </div>
                            <!-- Call to Action-->
                        </div>
                    </div>
                </div>


                
  </div>
  </div>

                <div class="footer" >
                    <%@include file="Components/footer.jsp" %>
                </div>

                </body>



                </html>

<%-- 
    Document   : SubjectRegister
    Created on : Jun 22, 2023, 4:09:53 PM
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="enrollPopup" class="popup-overlay ${not empty errorMessage ? '' : 'popup-hidden'}"> <div class="popup-content">
        <span class="close" onclick="closePopup('enrollPopup')">&times;</span>
        <div class="subject-register">
            <h2>Subject Register</h2>
            <c:forEach items="${price}" var="p">
                <c:if test="${p.status == true}">
                    <form class="price_package pb-3" action="SubjectRegister" method="POST">
                        <input type="hidden" name="uid" value="${sessionScope.user.uid}">
                        <input type="hidden" name="sid" value="${x.sid}" />
                        <input type="hidden" name="price" value="${p.price - p.sale}" /> <input type="hidden" name="duration" value="${p.duration}" />
                        <input type="hidden" name="ppname" value="${p.ppname}" />
                        <h3>Duration: ${p.ppname}</h3> <c:if test="${p.sale == 0}">
                            <h4>Price: ${p.price} </h4>
                        </c:if>
                        <c:if test="${p.sale != 0}">
                            <h4 class="sale_price" id="crossed">Price: ${p.price} </h4>
                            <h5 class="sale_price">Now sale to: ${p.price - p.sale} </h5>
                        </c:if>
                        <input type="submit" value="Enroll"/>
                               </form>
                        </c:if>
                    </c:forEach>
                    </div>
                </div>
            </div>

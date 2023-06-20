<%-- 
    Document   : userPage
    Created on : Jun 20, 2023, 4:24:38 PM
    Author     : dungmuahahaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        <h1>${requestScope.qplist.size()}</h1>

        
        
    <c:forEach  var="qp" items="${qplist}">
        <div>
                <h2 class="text-center"> ${qp.getAttempt()} </h2>
                <h2 class="text-center"> ${qp.getQuizId()} </h2>
                <h2 class="text-center"> ${qp.getPoint()} </h2>
              
          
        </div>
    </c:forEach>
</body>
</html>

<%-- 
    Document   : change
    Created on : May 19, 2023, 10:21:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/inUp.css"/>
    </head>
    <body>
        <div class="form-box">
            <span class="title">Change password form</span>
            <form class="form" action="change">
            Old password: <input type="password" name ="pass"/><br/>
            New password: <input type="password" name ="npass"/><br/>
            Confirm password: <input type="password" name ="cpass"/><br/>
            <input type="submit" value="Change"/>
        </form>
        </div>
    </body>
</html>

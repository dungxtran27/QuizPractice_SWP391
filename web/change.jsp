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
            <form class="form" action="changepw" method="post">
                Old password: <input type="password" name ="" value="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number, one uppercase, lowercase letter and at least 6 or more characters" id="old-password"/><br/>
                <p id="error-old-password" class="error"/>
                New password: <input type="password" name ="npass" value="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number, one uppercase, lowercase letter and at least 6 or more characters" id="new-password"/><br/>
                <p id="error-new-password" class="error"/>
                Confirm password: <input type="password" name ="" value="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number, one uppercase, lowercase letter and at least 6 or more characters" id="confirm-password"/><br/>
                <p id="error-confirm-password" class="error"/>
            <input type="submit" value="Change"/>
        </form>
        </div>
<!--        doan code js kiem tra mat khau ma nguoi dung nhap vao-->
<!--        <script>
            function submitForm() {
                    var oldPassword = document.getElementById("old-password").value;
                    var newPassword = document.getElementById("new-password").value;
                    var confirmPassword = document.getElementById("confirm-password").value;
                    if (oldPassword !== ${sessionScope.user.password}) {
                        document.getElementById("error-old-password").innerHTML = "Old password is not correct";
                        return false;
                    } else {
                        document.getElementById("error-old-password").innerHTML = "";
                    } 
                    if (confirmPassword !== newPassword) {
                        document.getElementById("error-confirm-password").innerHTML = "Confirm password not same as password";
                        return false;
                    } else {
                        document.getElementById("error-confirm-password").innerHTML = "";
                    }
                    return true;
                }
        </script>-->
    </body>
</html>

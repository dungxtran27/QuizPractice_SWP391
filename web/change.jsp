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
        <title>Change password</title>
        <link rel="stylesheet" href="css/profile.css"/>
    </head>
    <body>
        <div id="container">
             <form class="form" action="changepw" method="post" >
            <div id="table-head">
                <span>Change password</span>
                <h3 style="color:red">${requestScope.ms}</h3>
            </div>
            <div>
                <table>
                    <tr>
                        <td>Old password:</td>
                        <td><input type="password" name ="opass" value="" id="old-password"/></td>
                    </tr>
                    <tr><td colspan="2" id="error-old-password" class="error"></td></tr>
                    <tr>
                        <td>New password:</td> 
                        <td><input type="password" name ="npass" value="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number, one uppercase, lowercase letter and at least 6 or more characters" id="new-password"/></td>
                    </tr>
                    <tr><td id="error-new-password" class="error"></td></tr>
                    <tr>
                        <td>Confirm password:</td> 
                        <td><input type="password" name ="curpass" value="" id="confirm-password"/></td>
                    </tr>
                    <tr><td id="error-confirm-password" class="error"></td></tr>
                    <tr>
                        <td><input id="submit-btn" type="submit" value="Change"/></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
<!--        doan code js kiem tra mat khau ma nguoi dung nhap vao-->
<!--        <script>
            function submitForm() {
                    var oldPassword = document.getElementById("old-password").value;
                    var newPassword = document.getElementById("new-password").value;
                    var confirmPassword = document.getElementById("confirm-password").value;
                    if (oldPassword !== ${sessionScope.currUser.password}) {
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

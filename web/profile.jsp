<%-- 
    Document   : profile
    Created on : May 20, 2023, 9:27:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/profile.css" rel="stylesheet" type="text/css"/>

          <title>Profile Change</title>
    </head>
    <body>
    

            <div id="container">
                <form action="profile" method="POST">
                    <div id="table-header">
                        <span>My profile</span>
                    </div>

                    <div>
                        <table>            

                            <tr>
                                <td>Full name</td>
                                <td><input type="text"  name="fullname" value="${us.fullname}" required/></td>
                            </tr>
                            <tr><td colspan="2" id="error-lname" ></td></tr>
                            <tr>
                                <td>Avatar</td>
                                <td><input type="file" name="avatar" placeholder=""></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><input type="text" name="phone" value="${us.phone}" required/></td>
                            </tr>
                            <tr><td colspan="2" ></td></tr>

                            <tr>
                                <td>Email</td>
                                <td><input type="text" name="email" value="${us.email}" disabled="disabled"/></td>
                            </tr>
                            <tr><td colspan="2"></td></tr>

                            <tr>
                                <td>Password</td>
                                <td><a href="change.jsp">Change password</a></td>
                            </tr>
                            <tr><td></td></tr>

                            <tr>
                                <td>Address</td>
                                <td><input type="text" name="address" value="${us.address}" /></td>
                            </tr>
                            <tr><td colspan="2"></td></tr>



                            <tr>
                                <td colspan="2"><input id="submit-btn" type="submit" value="Save" /></td>
                            </tr>
                            <c:if test="${successNoti != null}">
                                <tr>
                                    <td colspan="2">
                                        <div id="notification">
                                            <span>Profile has been changed successfully!</span> <a href="Home.jsp">Back to home</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:if>
                        </table>
                </div>
            </form>

            <div id="avatar">
                <img src="uploads/${us.avatar}" alt="Avatar" width="250" height="250">
            </div>  
        </div>
    </body>
</html>

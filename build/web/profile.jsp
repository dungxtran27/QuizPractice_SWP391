<%-- 
    Document   : profile
    Created on : May 20, 2023, 9:27:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>

<!DOCTYPE html>
<%@include file="Components/AllAccess.jsp"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/profile.css" rel="stylesheet" type="text/css"/>

        <title>Profile</title>
    </head>
    <body>

        <div class="wrapper">
              <%@include file="Components/Sidebar.jsp" %>
              <div class="content" style="width:100%">
                  <%@include file="Components/header.jsp" %>
        <div id="container">
            <form action="profile" method="post" enctype="multipart/form-data">
                <div id="table-header">
                    <span>My profile</span>
                </div>

                <div>
                    <table>            

                        <tr>
                            <td>Full name</td>
                            <td><input type="text"  name="fullname" value="${sessionScope.currUser.fullname}" required/></td>
                        </tr>
                        <tr><td colspan="2" id="error-lname" ></td></tr>
                        <tr>
                            <td>Avatar</td>
                            <td><input type="file" name="avatar" placeholder=""></td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td><input type="text" name="phone"  pattern="(?=.*\d){10,}" value="${sessionScope.currUser.phone}" required/></td>
                        </tr>
                        <tr><td colspan="2" ></td></tr>

                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="email" value="${sessionScope.currUser.email}" disabled="disabled"/></td>
                        </tr>
                        <tr><td colspan="2"></td></tr>

                     
                        

                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="address" value="${sessionScope.currUser.address}" /></td>
                        </tr>
                        <tr><td colspan="2"></td></tr>



                        <tr>
                            <td colspan="2"><input id="submit-btn" type="submit" value="Save" /></td>
                            <td colspan="2"> <a href="Home.jsp">Cancel</a></td>
                        </tr>

                    </table>
                </div>

            </form>

            <div id="avatar">
                <p>avatar</p>
                <img src="${sessionScope.currUser.avatar}" alt="Avatar" width="250" height="250">
                 
               
                <%
  if(u.getRole().getRole_id()==1){
       
        %>
         <h4>activity:</h4>
        <div>
<button class="btn btn-default" role="button"> <a href="user-list"> <h3>User managerment</h3> </a>
            </button>
           
        </div>

        <%} else if(u.getRole().getRole_id()==3){%>
        <div>

            <a href="quiz-list"> <h3>create new quiz</h3> </a>
        </div>
        <%} else if(u.getRole().getRole_id()==4){%> 
        <div>

            <a href="userList.jsp"> <h3>make new post</h3> </a>
        </div>
        <%}%>
            </div> 
        </div>
        <a href="logout">
            <button class="btn btn-danger" role="button"> Log Out
            </button>
        </a>

    </div>
    </div>
    </body>
</html>

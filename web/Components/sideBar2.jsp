
<!-- Sidebar  -->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>
<!DOCTYPE html>
<%
    User u = (User)request.getSession().getAttribute("currUser");
   
    

    
%>
<nav id="sidebar">
    <div class="sidebar-header">
        <h3>QPS04</h3>
    </div>

    <ul class="list-unstyled components">
        <p>Quiz Practicing System</p>
        <li class="active">
              <div class="me-5 col-3" style="display: initial">
                <form action="SearchSubject" method="POST" class="d-flex">
                    <div class="input-group">
                        <input type="search" name="keyword" id="form1" class="form-control" placeholder="search by name"/>
                        <!--<label class="form-label" for="form1">Search</label>-->
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </form>
            </div>
        </li>
        <li>
             <div class="col-3">
                                    <form action="subject-list" method="GET" class="d-flex">
                                        <input type="hidden" name="page" value="${page}" />
                                        <button type="submit" name="sort" value="createDate" class="btn btn-primary">Sort by Date</button>
                                    </form>
                                </div>
        </li>
         
        <li>
            <a href="subject-list">subject</a>
        </li>
        <li>
            <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Quizzes</a>
            <ul class="collapse list-unstyled" id="pageSubmenu">
                <li>
                    <a href="QuizHistoryServlet">Quiz History</a>
                </li>
                <li>
                    <a href="quiz-list">Quiz List</a>
                </li>
                <li>
                    <a href="#">Page 3</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="profile.jsp">Profile</a>
        </li>
        <li>
            <a href="#">Contact</a>
        </li>
    </ul>
    
    
  
    
    
    <% if(u == null){
    %>
    <ul class="list-unstyled CTAs">
        <li>
            <a href="SignIn.jsp" class="login">Login</a>
        </li>
        <li>
            <a href="SignUp.jsp" class="register">Sign up</a>
        </li>
    </ul>
    <%}
    %>
    
    
</nav>



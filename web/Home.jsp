<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>
<%
    List<Blog> blist = (List<Blog>)request.getAttribute("blist");

    List<Post> plist = (List<Post>)request.getAttribute("plist");

%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Components/AllAccess.jsp"%>
        <title>QPS 04</title>
    </head>
    <body>
        <div class="wrapper">

            <!-- Sidebar  -->
            <div style="" id="header">
                <%@include file="Components/Sidebar.jsp" %>
            </div>

            <!-- Page Content  -->
            <div id="content">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-info">
                            <i class="fas fa-align-left"></i>
                            <span>Home Page</span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="profile.jsp">Profile</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="post.jsp">post</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="rr" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"><img style="width: 40px" src="img/roll.jpg" alt="alt"/></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h2>quiz prsctice</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                <div id="myCarousel" class="carousel slide" data-ride="carousel">

                    <%
                           if(plist == null||plist.size()== 0){
                    %>
                    <div class="carousel-item active">
                        <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="First Slide">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>no post</h5>
                            <p>First Slide Description</p>
                        </div>
                    </div>


                    <%
                        }else{
                           for(Post pl: plist){
                    %>



                    <a href="#">
                        <div class="carousel-item active">
                            <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="First Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>name: <%=pl.getTitle()%></h5>
                                <p>brief: <%=pl.getBrifInfor()%></p>
                            </div>
                        </div>

                    </a>
                    <%
                           }
                        }
                    %>

                    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

                <div class="mainContent">
                    <%
                   if(plist == null||plist.size()== 0){
                    %>
                    noooo


                    <%
                        }else{
                           for(Post pl: plist){
                    %>




                    <p>name: <%=pl.getTitle()%></p>


                    <%
                           }
                        }
                    %>
                    <div class="list">
                        <%
                            if(blist == null||blist.size()== 0){
                        %>
                        <h1>no blog</h1>


                        <%
                            }else{
                               for(Blog bl: blist){
                        %>



                        <a class="a card" href="#">
                            <div style="display: flex" class="">

                                <div style="text-align: left;" class=" ">

                                    <h5 >name: <%=bl.getBlogName()%>;</h5>


                                </div>
                            </div>

                        </a>
                        <%
                               }
                            }
                        %>

                    </div>
                </div>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
        </div>


        <div class="footer" >
            <%@include file="Components/footer.jsp" %>
        </div>

    </body>
</html>

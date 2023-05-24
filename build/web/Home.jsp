
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>
<%
   BlogDAO Bld = new BlogDAO();
    List<blog> list = (List<blog>)request.getAttribute("list");
//    int count = Bld.getCount();
//    int pageCount = count / 12;
//    if(count % 12 != 0){
//        pageCount++;
//    }
//    int offset = (int)request.getAttribute("offSet");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Components/AllAccess.jsp"%>
        <title>JSP Page</title>
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

                <h2>Collapsible Sidebar Using Bootstrap 4</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="First Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>First Slide Heading</h5>
                                <p>First Slide Description</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="Second Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Second Slide Heading</h5>
                                <p>Second Slide Description</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="Third Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Third Slide Heading</h5>
                                <p>Third Slide Description</p>
                            </div>
                        </div>
                    </div>
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

            <div class="list">
                <%
                    if(list == null||list.size()== 0){
                %>
                <h1>no blog</h1>


                <%
                    }else{
                       for(blog: list){
                %>



                <a class="a card" href="#">
                    <div class="">
                       
                        <div style="text-align: left;" class=" card__body card__body--back">
                            <h5 >id: <%=bl.getBlogId()%>USD&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h5>
                            <h5 >name: <%=bl.getBlogName()%>&nbsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h5>
                            <h5 >Gender: <%=bl.getSubId()%>&ensp;&ensp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</h5>
                           

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

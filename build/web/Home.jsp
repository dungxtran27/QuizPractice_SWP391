<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>

<%
      postDAO pd = new postDAO();
        List<Post> plist = pd.getAllPost();
        request.setAttribute("plist", plist);
        
        
        BlogDAO bd = new BlogDAO();
        List<Blog> blist = bd.getAllBlog();
        request.setAttribute("blist", blist);
    


%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Components/AllAccess.jsp"%>
        <title>QPS 04</title>
        <style>
            .carousel {
                display: flex;
                flex-wrap: nowrap;
                overflow-x: scroll;
                scroll-behavior: smooth;
                padding: 20px 0;
                margin-bottom: 20px;
            }

            .carousel__item {
                flex: 0 0 calc(100% / 3);
                text-align: center;
                padding: 10px;
                box-sizing: border-box;
                background-color: #f5f5f5;
                margin-right: 10px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.2);
            }

            .carousel__back-link {
                display: inline-block;
                margin-bottom: 20px;
            }
        </style>
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
                                    <a class="rr" href="profile.jsp"><img style="width: 40px" src="img/roll.jpg" alt="alt"/></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h2>quiz prsctice</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>



                <div id="myCarousel" class="carousel " >

                    <%
                           if(plist == null||plist.size()== 0){
                    %>
                    <div class="carousel__item">
                        <div class="carousel-item active">
                            <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="First Slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>no post</h5>
                                <p>First Slide Description</p>
                            </div>
                        </div>
                    </div>


                    <%
                        }else{
                           for(Post pl: plist){
                    %>


                    <div class="carousel__item">

                        <div class="carousel-item active">
                            <a href="post?postId=<%=post.getPostId()%>
                               &thumbnail=<%=post.getThumbnail()%>
                               &userId=<%=post.getUserId()%>
                               &categoryBlogId=<%=post.getCategoryBlogId()%>
                               &content=<%=post.getContent()%>
                               &created_date=<%=post.getCreated_date()%>
                               &edit_date=<%=post.getEdit_date()%>
                               &status=<%=post.getStatus()%>
                               &brifInfor=<%=post.getBrifInfor()%>
                               &title=<%=post.getTitle()%>
                               &postFileId=<%=post.getPostFileId()%>"

                         <img style="width: 100%" src="<%=pl.getThumbnail()%>" alt="First Slide">
                                <div class="carousel-caption d-none d-md-block">
                                    <h5>name: <%=pl.getTitle()%></h5>
                                    <p>brief: <%=pl.getBrifInfor()%></p>
                                </div>
                            </a>

                        </div>

                    </div>



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

    </div>
    <div class="footer" >
        <%@include file="Components/footer.jsp" %>
    </div>
    <script>
        const carousel = document.querySelector('.carousel');
        const items = carousel.querySelectorAll('.carousel__item');
        const prevBtn = document.createElement('button');
        prevBtn.innerHTML = '&lt;';
        prevBtn.className = 'carousel__btn carousel__btn--prev';
        const nextBtn = document.createElement('button');
        nextBtn.innerHTML = '&gt;';
        nextBtn.className = 'carousel__btn carousel__btn--next';
        carousel.parentNode.insertBefore(prevBtn, carousel);
        carousel.parentNode.insertBefore(nextBtn, carousel.nextSibling);

        let scrollPosition = 0;
        const itemWidth = items[0].offsetWidth + parseInt(window.getComputedStyle(items[0]).marginRight);

        function handlePrevClick() {
            if (scrollPosition > 0) {
                scrollPosition -= itemWidth;
                carousel.scroll({
                    left: scrollPosition,
                    behavior: 'smooth'
                });
            }
        }

        function handleNextClick() {
            if (scrollPosition < (carousel.scrollWidth - carousel.offsetWidth)) {
                scrollPosition += itemWidth;
                carousel.scroll({
                    left: scrollPosition,
                    behavior: 'smooth'
                });
            }
        }

        prevBtn.addEventListener('click', handlePrevClick);
        nextBtn.addEventListener('click', handleNextClick);
    </script>
</body>
</html>

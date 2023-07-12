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
    
       subjectListDAO sd;
        sd = new subjectListDAO();
        List<subject> slist = sd.getAllSubject();
        request.setAttribute("slist", slist);
        
        
        
        SliderDAO sld = new SliderDAO();
      
        List<slider> sllist = sld.getAllSlider();
        request.setAttribute("sllist", sllist);
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

            .avatar {
                width: 50px; /* Điều chỉnh kích thước theo ý muốn */
                height: 50px; /* Điều chỉnh kích thước theo ý muốn */
                border-radius: 50%;
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



                <%@include file="Components/header.jsp" %>
                <h2>quiz practice</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt
                    ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco 
                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                    velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt
                    in culpa qui officia deserunt mollit anim id est laborum.</p>






                <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
                    <ol class="carousel-indicators">
                        <% for (int i = 0; i < sllist.size(); i++) { %>
                        <li data-target="#myCarousel" data-slide-to="<%= i %>" <%= i == 0 ? "class=\"active\"" : "" %>></li>
                            <% } %>
                    </ol>

                    <div class="carousel-inner">
                        <% for (int i = 0; i < sllist.size(); i++) {
                              slider sl = sllist.get(i);
                              String activeClass = i == 0 ? "active" : ""; %>
                        <div class="carousel-item <%= activeClass %>">
                            <img class="d-block w-100" src="<%=sl.getSliderUrl()%>" alt="no pic">
                            <div class="carousel-caption d-none d-md-block">


                            </div>
                        </div>
                        <% } %>
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


                <h2>Hot Post: </h2>
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
                           for(Post p: plist){
                    %>


                    <div class="carousel__item">

                        <div class="carousel-item active">
                            <a href="postServlet?id=<%=p.getPostId()%>">

                                <img src="<%=p.getThumbnail()%>" style="width: 100%"  alt="First Slide">
                                <div class="">
                                    <h5> <%=p.getTitle()%></h5>
                                    <h5><%=p.getCreated_date()%><h5>
                                            </div>
                                            </a>

                                            </div>

                                            </div>



                                            <%
                                                   }
                                                }
                                            %>


                                            </div>
                                            <h2>Subject: </h2>
                                            <div id="myCarousel" class="carousel " >

                                                <%
                                                       if(slist == null||slist.size()== 0){
                                                %>
                                                <div class="carousel__item">
                                                    <div class="carousel-item active">
                                                        <img src="https://www.ncertbooks.guru/wp-content/uploads/2022/05/Course-details.png" alt="First Slide">
                                                        <div class="carousel-caption d-none d-md-block">
                                                            <h5>no subject</h5>
                                                            <p>First Slide Description</p>
                                                        </div>
                                                    </div>
                                                </div>


                                                <%
                                                    }else{
                                                       for(subject s: slist){
                                                %>


                                                <div class="carousel__item">

                                                    <div class="carousel-item active">
                                                        <a href="subject-detail?id=<%=s.getSubjectId()%>">

                                                            <img style="width: 100%" src="<%=s.getThumbnail()%>" alt="First Slide">
                                                            <div class="carousel-caption d-none d-md-block">
                                                                <br>  <br>  <br>  <br>
                                                                <h5 style="color: black; background-color: whitesmoke"><%=s.getTitle()%></h5>

                                                            </div>
                                                        </a>

                                                    </div>

                                                </div>



                                                <%
                                                       }
                                                    }
                                                %>


                                            </div>

                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                            </div>
                                            </div>


         <div class="footer" >
          <%@include file="Components/footer.jsp" %>
         </div>
                                            <script>
                                                const carousel = document.querySelector('.carousel');
                                                const items = carousel.querySelectorAll('.carousel__item');


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

<%-- 
    Document   : BlogList
    Created on : May 22, 2023, 10:25:31 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="css/dashboard.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <!--        <script src="js/scripts.js"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <!-- MDB -->
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            />
        <!-- Google Fonts Roboto -->
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"
            />
        <!-- MDB -->
        <link rel="stylesheet" href="css/dashboard.css" />
        <link rel="stylesheet" href="css/mdb.min.css" />
        <!-- MDB -->
        <script type="text/javascript" src="js/navbarCategory.js"></script>
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript"></script>
    </head>
    
    <body class="sb-sidenav-toggled">
        <body>
            <section class="py-5">
                <div id="header">
                    <jsp:include page="Components/nav.jsp"></jsp:include>
                </div>
            </section>
            <!-- Page content-->
            <div class="container mt-5">
                <h2 class="fw-bolder fs-5 mb-4">Blog List</h2>
                <div class="row">
                    <!-- Blog entries-->
                    <div class="col-lg-8">
                        <!-- Featured blog post-->

                        <!-- Nested row for non-featured blog posts-->
                        <div class="row">
                            <c:forEach items="${bl}" var="o">
                                <div class="col-lg-6 mb-3">
                                    <!-- Blog post-->
                                    <div class="card h-100 shadow border-0">
                                        <img class="card-img-top" id="card-img-blog" src=${o.getImage()} alt="..." />
                                        <div class="card-body p-4">
                                            <div class="badge bg-primary bg-gradient rounded-pill mb-2">${o.getType()}</div>
                                            <a class="text-decoration-none link-dark stretched-link" href="BlogDetail?bid=${o.getId()}">
                                                <div class="h5 card-title mb-3">${o.getTitle()}</div>
                                            </a>
                                            <p class="card-text mb-0">${o.getDescription()}</p>
                                        </div>
                                        <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                                            <div class="d-flex align-items-end justify-content-between">
                                                <div class="d-flex align-items-center">
                                                    <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                                                    <div class="small">
                                                        <div class="fw-bold">${o.getAuthor()}</div>
                                                        <div class="text-muted">${o.getDate()}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
</html>

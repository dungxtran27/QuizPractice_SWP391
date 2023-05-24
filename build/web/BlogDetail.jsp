<%-- 
    Document   : BlogDetail
    Created on : May 22, 2023, 10:25:50 PM
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

        <div id="layoutSidenav">
                    <!-- Call to Action-->
                    <div class="card text-white bg-secondary my-5 py-4 text-center">
                        <div class="card-body"><p class="text-white m-0">Cards</p></div>
                    </div>
                    <!-- Content Row-->
                    <div class="row gx-4 gx-lg-5">
                        <div class="col-md-4 mb-5">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h2 class="card-title">Card One</h2>
                                    <p class="card-text">${blog.BlogId}</p>
                                    <p class="card-text">${blog.BlogName}</p>
                                    <p class="card-text">${blog.SubId}</p>
                                </div>
                                <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">More Info</a></div>
                            </div>
                        </div>
                        <div class="col-md-4 mb-5">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h2 class="card-title">Card Two</h2>
                                    <p class="card-text">${blog.BlogId}</p>
                                    <p class="card-text">${blog.BlogName}</p>
                                    <p class="card-text">${blog.SubId}</p>
                                </div>
                                <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">More Info</a></div>
                            </div>
                        </div>
                        <div class="col-md-4 mb-5">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h2 class="card-title">Card Three</h2>
                                    <p class="card-text">${blog.BlogId}</p>
                                    <p class="card-text">${blog.BlogName}</p>
                                    <p class="card-text">${blog.SubId}</p>
                                </div>
                                <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">More Info</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

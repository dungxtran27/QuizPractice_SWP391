<%-- 
    Document   : SignIn
    Created on : May 22, 2023, 12:04:45 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Components/AllAccess.jsp"%>
        <title>Sign In</title>
    </head>
    <body>
        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">

                    </div>
                    <div id="Login">
                        <div  class="">
                            <div class="loginHeader align-items-center my-4">
                                <h1 class="text-center ">QPS04</h1>
                            </div>
                            <form>

                                <!-- Username input -->
                                <div class="form-outline mb-4">
                                    <input type="text" id="user" class="form-control form-control-lg"
                                           placeholder="Username" />
                                </div>

                                <!-- Password input -->
                                <div id="enterbox" class="form-outline mb-3">
                                    <input type="password" id="pass" class="form-control form-control-lg"
                                           placeholder="Password" />
                                </div>

                                <div id="enterbox" class="d-flex justify-content-between align-items-center">
                                    <!-- Checkbox -->
                                    <div class="form-check mb-0">

                                    </div>
                                    <a href="#!" class="text-body">Forgot password?</a>
                                </div>

                                <div class="text-center text-lg-start mt-4 pt-2">
                                    <button id="buttonLogin" type="button" class="btn btn-primary btn-l">Login</button>
                                    <p  class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? 
                                        <a href="#!" class="link-danger">Register</a></p>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </section>
    </body>
</html>

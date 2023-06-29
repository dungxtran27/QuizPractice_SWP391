<%-- 
    Document   : SignUp
    Created on : May 24, 2023, 7:52:06 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="Components/AllAccess.jsp"%>
        <title>Sign Up</title>
    </head>
    <body>
        <section class="vh-100">
            <div class="container-fluid ">
                <div class="row d-flex justify-content-center align-items-center">
                    <div id="SignUp">
                        <div  class="">
                            <div class="loginHeader align-items-center my-4">
                                <h1 class="text-center ">Sign Up</h1>
                                <c: if test="${not empty status}">
                                    <p class="text-center text text-fails">${status}</p>
                                    <p></p>
                                </c:>
                            </div>
                            <form action="signUp" method="post">
                                <div class="row">
                                    <div class="col-md-6">

                                        <div class="form-outline mb-4">
                                            <input type="text" id="fullname" name="fullname" class="form-control form-control-lg"
                                                   value="" placeholder="Fullname" required="required"/>
                                        </div>

                                        <div class="form-outline mb-4 px-4" >
                                            <h6 class="mb-2 pb-1">Gender: </h6>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                                       value="0" checked />
                                                <label class="form-check-label" for="femaleGender">Female</label>
                                            </div>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                                       value="1" />
                                                <label class="form-check-label" for="maleGender">Male</label>
                                            </div>

                                        </div>



                                        <div class="form-outline mb-4" data-validate="phoneNumber is required!">
                                            <input type="text" id="phone" name="phone" class="form-control form-control-lg"
                                                   value="" placeholder="Phone number" required="required"/>
                                        </div>   

                                        <div id="enterbox" class="d-flex justify-content-between align-items-center">
                                            <!-- Checkbox -->
                                            <div class="form-check mb-0">

                                            </div>

                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <!--                                        <div class="form-outline mb-4" data-validate="Username is required!">
                                                                                    <input type="text" id="username" name="username" class="form-control form-control-lg"
                                                                                           value="" placeholder="Username" required="required"/>
                                                                                </div>    -->
                                        <div class="form-outline mb-4" data-validate="Email is required!">
                                            <input type="email" id="email" name="email" class="form-control form-control-lg"
                                                   value="" placeholder="Email" required="required"/>
                                        </div>
                                        <!-- Password input -->
                                        <div id="enterbox" class="form-outline mb-3" data-validate="Password is required!">
                                            <input type="password" id="password"name="password" class="form-control form-control-lg"
                                                   value="" placeholder="Password" required="required"/>
                                        </div>

                                        <!-- Re-password input -->
                                        <div id="enterbox" class="form-outline mb-3" data-validate="RePassword is required!">
                                            <input type="password" id="repassword"name="repassword" class="form-control form-control-lg"
                                                   value="" placeholder="Re-password" required="required"/>
                                        </div> 
                                    </div>


                                </div>
                                <div class="text-center text-lg-start mt-4 pt-2" >
                                    <button id="buttonLogin" type="submit" class="btn btn-primary btn-l">Register</button>

                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </section>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="no-js"
      xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://thymeleaf.org"
      xmlns:sec="http://thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <title th:text="#{app.title}">-Enquiries-</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" th:href="@{/css/enquiries.css}"/>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script th:src="@{js/jquery.sticky-kit.js}"></script>

</head>

<!-- Displayed after successful activation (when followed activation link) -->
<body>

    <div class="jumbotron text-center" style="margin-bottom:0; padding:0">
        <div class="fakeimg">
            <img src="/images/header.jpg" style="height: 200px; width:100%"></img>
        </div>
    </div>

    <nav class="navbar navbar-expand-sm  py-0 bg-light navbar-light sticky-top">

        <ul class="navbar-nav">
            <li class="nav-item">
                <h4> Contact Us</h4>
            </li>
            <li class="nav-item">
                <i class="material-icons  py-0"
                   style="font-size:32px;color:red; padding: 0px 10px 0px 10px;">mail_outline</i>
            </li>
        </ul>

        <button class="navbar-toggler  py-0" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
            <div style="margin-top: 15px">
         <span id="error-message" style="color:red !important"
               th:if="${session[SPRING_SECURITY_LAST_EXCEPTION] != null and session[SPRING_SECURITY_LAST_EXCEPTION].message != null}"
               th:text="${session[SPRING_SECURITY_LAST_EXCEPTION].message}">Login failed
         </span>

                <form action="#" th:action="@{/enquiry/login}" method="post">
                    <div class="input-group mb-2  py-0">
                        <input style="height:30px" type="text" class="form-control form-control-sm mr-2  py-0"
                               placeholder="Enter email" th:name="username"/>
                        <input style="height:30px" type="password" class="form-control form-control-sm mr-2  py-0"
                               placeholder="Enter password" th:name="password"/>
                        <div class="custom-control custom-checkbox mr-2">
                            <input type="checkbox" class="custom-control-input" id="check" th:name="remember-me"/>
                            <label class="custom-control-label" for="check">Remember me</label>
                        </div>
                        <div class="input-group-append">
                            <button style="height:30px" type="submit" class="btn btn-sm btn btn-outline-info  py-0">Sign
                                in
                            </button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </nav>

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-2 mt-1">

                <p style="margin-bottom: 0px">You can email us directly at:</p>
                <a href="mailto:namdevtest@gmail.com?Subject=Map%20enquiry" target="_top">sales@mapcenter.com</a>

                <p style="padding: 20px 0px 0px 0px; margin-bottom: 0px">or give us a call on:</p>
                <span style="color: red">+ 44 207 45673 3454</span>

                <p style="padding: 20px 0px 0px 0px; margin-bottom: 0px">You can also visit us here:</p>
                <p style="color: #808080; margin-bottom: 0px">10 Long Acre</p>
                <p style="color: #808080; margin-bottom: 0px">WC2E 8LP</p>
                <p style="color: #808080; margin-bottom: 0px">London</p>
                <p style="color: #808080; margin-bottom: 0px">United Kingdom</p>

                <p style="padding: 20px 0px 0px 0px; margin-bottom: 0px">Opening hours:</p>
                <p style="color: #808080; margin-bottom: 0px">Monday 9am - 8pm</p>
                <p style="color: #808080; margin-bottom: 0px">Tuesday 9am - 8pm</p>
                <p style="color: #808080; margin-bottom: 0px">Wednesday 9am - 8pm</p>
                <p style="color: #808080; margin-bottom: 0px">Thursday 9am - 8pm</p>
                <p style="color: #808080; margin-bottom: 0px">Friday 9am - 8pm</p>
                <p style="color: #808080; margin-bottom: 0px">Saturday 9am - 8pm</p>
                <p style="color: #808080; margin-bottom: 10px">Sunday 11.30am - 6pm</p>
                <p style="color: #808080; margin-bottom: 0px">Bank Holidays 11am - 7pm</p>

            </div>


            <div class="col-sm-10 border border-default border-top-0 border-right-0 border-bottom-0">

                <div class="mt-2" th:if="${invalidToken != null}">
                    <div class="alert alert-danger mb-3" style="text-align:center">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>The activation link is either incorrect or expired.</span>
                    </div>
                    <div class="alert alert-warning mb-3" style="text-align:center">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>Please ask System Admin to re-send the activation link.</span>
                    </div>
                </div>

                <div class="mt-2" th:if="${invalidToken == null}">
                    <div class="alert alert-primary mb-3" style="text-align:center">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>Your account has been activated!</span>
                    </div>
                    <div class="alert alert-primary mb-3" style="text-align:center">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>You can log in now.</span>
                    </div>
                </div>

                <a th:href="@{/}" class="btn btn-outline-info btn-block mt-4" role="button">Go To Enquiry Form</a>

            </div>

            <div class="mt-0 invisible" style="background-color: white">.</div>
        </div>
    </div>

    <div class="mt-0"></div>
    <footer class="bg-dark text-white m-0 p-0">
        <div class="container-fluid m-0 p-0">
            <div class="row">
                <div class="col-md-12">
                    <div class="jumbotron jumbotron-fluid text-center" style="margin-top:0; margin-bottom:0 ; padding:0">
                        <div class="fakeimg2">
                            <img src="/images/worldmap_1b30.png" style="height: 100px; width:100%"></img>
                            <div id="title3" class="centered3">Visit as online at www.mapasdelmundo.net or in person in our
                                London map kingdom!
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

   
</body>
</html>















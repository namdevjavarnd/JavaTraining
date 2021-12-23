<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--suppress ThymeleafVariablesResolveInspection, XmlDuplicatedId -->
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
    <script type="text/javascript" th:src="@{/js/resetfollowup.js}"></script>
    <style>
        #color-palette {
            clear: both;
        }

        .color-button {
            width: 18px;
            height: 18px;
            font-size: 0;
            margin: 0px;
            float: right;
            cursor: pointer;
            margin-top: 8px
        }
    </style>
</head>

<!-- Page returned when a user forgets their password and submits email address -->
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
               th:text="${session[SPRING_SECURITY_LAST_EXCEPTION].message}">---bad credentials---
         </span>

                <span class="pr-2" style="font-size: 14px">
              <a data-toggle="modal" href="#forgot-modal">Forgot Password?</a>
        </span>

                <div style="display: inline-block">
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

        </div>
    </nav>

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-2 mt-1">

                <p style="margin-bottom: 0px">You can email us directly at:</p>
                <a href="mailto:latidude99test@gmail.com?Subject=Map%20enquiry" target="_top">sales@mapcenter.com</a>

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

                <div id="spinner" class="spinner"
                     style="display:none;position: fixed; top: 50%; left: 50%; margin-left: -50px; margin-top: -50px;
                                text-align:center; z-index:1234; overflow: auto; width: 100px; height: 102px;">
                    <img id="img-spinner" src="/images/loader.gif" alt="Loading"/>
                </div>

                <div th:if="${forgotOK != null}">
                    <div id="table-cell" class="alert alert-primary alert-dismiss mb-3">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>A password reset link has been sent to </span>
                        <strong th:text="${forgotOK}">--demo@demo.com--</strong>
                    </div>
                </div>

                <div th:if="${forgotEmail != null}">
                    <div id="table-cell" class="alert alert-warning alert-dismiss mb-3">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>There is no user registered with the email addres: </span>
                        <strong th:text="${forgotEmail}">--demo@demo.com--</strong>
                    </div>
                </div>

                <div th:if="${forgotError != null}" class="mb-5">
                    <div id="table-cell" class="alert alert-danger alert-dismiss mb-3">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span th:text="${forgotError}">--forgot error--</span>
                    </div>
                </div>

                <!-- The Modal -->
                <div class="modal fade" id="forgot-modal">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h5 class="modal-title">Please type in your registered email address:</h5>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">

                                <form action="#" th:action="@{/user/forgot}" method="post" th:object="${user}">
                                    <input type="text" class="form-control form-control-md mr-2 mb-2"
                                           placeholder="Enter email" th:field="*{email}"/>
                                    <input type="hidden" th:value="*{name}" name="name"/>
                                    <input type="hidden" th:value="*{password}" name="password"/>
                                    <button id="forgot" type="submit" class="btn btn-primary btn-block mt-3">
                                        Send Reset Link
                                    </button>
                                </form>

                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer p-1">
                                <button type="button" class="btn btn-sm btn-outline-secondary" data-dismiss="modal">Close
                                </button>
                            </div>

                        </div>
                    </div>
                </div>

                <a th:href="@{/}" class="btn btn-outline-info btn-block mt-6" role="button">Go To Enquiry Form</a>
            </div>

            <div class="mt-0 invisible" style="background-color: white">.</div>
        </div>
    </div>
    <footer class="bg-dark text-white mt-4">
        <div class="container-fluid py-3">
            <div class="row">
                <div class="col-md-12">
                    <div class="jumbotron jumbotron-fluid text-center"
                         style="margin-top:0; margin-bottom:0 ; padding:0">
                        <div class="fakeimg2">
                            <img src="/images/worldmap_1b30.png" style="height: 100px; width:100%"></img>
                            <div id="title3" class="centered3">Visit as online at www.mapasdelmundo.net or in person
                                in our London map kingdom!
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>




</body>
</html>















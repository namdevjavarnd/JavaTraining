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
    <script type="text/javascript" th:src="@{js/jquery.sticky-kit.js}"></script>
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

<!-- Displayed after successful activation (following an activation link) -->
<body>
    <nav class="navbar navbar-expand-sm bg-light navbar-light sticky-top">

        <ul class="navbar-nav">
            <li class="nav-item">
                <h4> Registration Confirmation</h4>
            </li>
        </ul>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar"></div>

        <div style="margin-top: 5px; padding: 0px 0px 0px 0px;"></div>


    </nav>

    <div class="container" style="margin-top:30px">
        <div class="row">
            <div class="col-sm-2">

                <div style="font-size:14px" class="mt-2">
                    <p style="margin-bottom: 0px; text-align: center;">Account activated on:</p>
                    <p style="color: brown; text-align: center;">14.02.2017 10.56</p>


                </div>

            </div>

            <div class="col-md-10 border border-default border-top-0 border-right-0 border-bottom-0">

                <div class="container mb-3">


                    <h4 style="text-align:center;">Excellent!</h4>
                    <h4 style="text-align:center;">Your account has been activated.</h4>
                    <h4 style="text-align:center;">You can Sign In now.</h4>

                    <div class="mt-5">
                        <form action="/action_page.php">
                            <div class="form-group">
                                <label for="email"></label>
                                <input type="email" class="form-control" id="email" placeholder="Email">
                            </div>
                            <div class="form-group">
                                <label for="pwd"></label>
                                <input type="password" class="form-control" id="pwd" placeholder="Password">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox"> Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-outline-primary btn-block mt-3">Sign In</button>
                        </form>
                    </div>

                    <button type="button" class="btn btn-outline-info btn-block mt-5">Go to Enquiry Form</button>

                </div>

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
                            <div id="title3" class="centered3">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

   

</body>
</html>















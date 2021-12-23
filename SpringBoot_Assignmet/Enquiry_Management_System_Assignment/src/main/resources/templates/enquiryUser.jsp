<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--suppress XmlDuplicatedId -->
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

<!-- User details page (password change form) -->
<body>
    <nav class="navbar navbar-expand-sm sticky-top">

        <ul class="navbar-nav">
            <li class="nav-item">
                <h4> User Page</h4>
            </li>
        </ul>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">

            <div style="margin-top: 5px; padding: 0px 0px 0px 0px;">

                <div class="float-left pr-2 pb-0 mt-2 flex-fill">
                    <div class="float-left form-group flex-fill">
                        <span style="color: grey" class="mr-sm-2">You are logged in as:</span>
                    </div>
                    <div class="float-left form-group flex-fill">
                        <span style="color: brown" class="mr-sm-0" th:text="${currentUser.email}">-demo@demo.com-</span>
                    </div>
                    <div class="float-left form-group flex-fill">
                        <span style="color: grey" class="mr-sm-2">,  privileges: </span>
                    </div>
                    <div class="float-left form-group flex-fill">
                        <div sec:authorize="hasRole('ROLE_USER')">
                            <span style="color: brown" class="mr-sm-2">User</span>
                        </div>
                    </div>
                    <div class="float-left form-group flex-fill">
                        <div sec:authorize="hasRole('ROLE_ADMIN')">
                            <span style="color: orange" class="mr-sm-2">Admin</span>
                        </div>
                    </div>
                    <div class="float-left form-group flex-fill">
                        <div sec:authorize="hasRole('ROLE_APPADMIN')">
                            <span style="color: red">Super Admin</span>
                        </div>
                    </div>
                </div>

            </div>
            <form action="logout" th:action="@{/logout}" method="post">
                <input type="submit" id="logmeout" value="Sign off" class="btn btn-outline-success btn-sm ml-sm-2"
                       role="button"/>
            </form>
            <a href="/admin" class="btn btn-outline-info btn-sm ml-sm-2" role="button">Admin Page</a>

        </div>
    </nav>
    <div sec:authorize="hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_APPADMIN')">

        <div class="container pb-5">
            <div class="row">

                <div class="col-sm-2 align-self-start" style="background-color: white;">

                    <div class="form-group flex-fill mt-3">
                        <a th:href="@{/enquiry/list}" class="btn btn-info btn-sm btn-block" role="button">Back to Enquiry
                            List</a>
                    </div>

                    <div style="font-size:14px" class="mt-2">
                        <p style="margin-bottom: 0px; text-align: center;">Account registered on :</p>
                        <p style="color: brown; text-align: center;"
                           th:text="${#temporals.format(currentUser.registered, 'dd.MM.yyyy HH:mm')}">-14.02.2017 10.56-</p>
                    </div>
                </div>


                <div class="col-md-10 border border-default border-top-0 border-right-0 border-bottom-0">
                    <div class="container mb-3">

                        <div class="mt-2" th:if="${uploadFail != null}">
                            <div class="alert alert-primary mb-3" style="text-align:center">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <span>Your password has been succesfully changed!</span>
                            </div>
                        </div>

                        <form action="#" th:action="@{/user/update}" method="post" th:object="${currentUser}">


                            <div class="form-group">
                                <label for="name" style="color: grey">Name</label>
                                <input type="text" class="form-control" id="name" th:field="*{name}"
                                       th:placeholder="*{name}" readonly="readonly"
                                       style="background-color: #e6e6e6; color: grey;"/>
                            </div>

                            <div class="form-group">
                                <label for="email" style="color: grey">Email</label>
                                <input type="text" class="form-control" id="email" th:field="*{email}"
                                       th:placeholder="*{email}" readonly="readonly"
                                       style="background-color: #e6e6e6; color: grey;"/>
                            </div>

                            <div class="form-group">
                                <label for="pwd" style="color: grey">Password</label>
                                <input type="password" class="form-control" id="pwd" placeholder="****************"
                                       readonly="readonly" style="background-color: #e6e6e6; color: grey;"/>
                            </div>

                            <div class="form-group">
                                <label for="pwd">Enter Current Password</label>
                                <span class="pl-5" id="form-errors" th:if="${passwordOldNoMatch != null}">The password entered does not match your current password!</span>
                                <input type="password" class="form-control" id="pwd" th:field="*{password}" placeholder=""/>

                            </div>
                            <div class="form-group">
                                <label for="password">New Password</label>
                                <span class="ml-5" id="form-errors" th:if="${#fields.hasErrors('passwordNew')}"
                                      th:errors="*{passwordNew}">-name errors-</span>
                                <input type="password" class="form-control" id="password" th:field="*{passwordNew}">
                            </div>
                            <div class="form-group">
                                <label for="confirm_password">Repeat New Password</label>
                                <input type="password" class="form-control" id="confirm_password">
                            </div>

                            <button type="submit" class="btn btn-primary btn-block mb-3">Change Password</button>
                        </form>

                        <a th:href="@{/enquiry/list}" class="btn btn-outline-info btn-block mt-4 mb-6" role="button">Back to
                            Enquiry List</a>

                    </div>

                </div>
            </div>

            <div class="mt-0 invisible" style="background-color: white">.</div>
        </div>
    </div> <!-- end of security USER, ADMIN -->

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

    <script type="text/javascript" th:src="@{js/password.js}"></script>

   

</body>
</html>















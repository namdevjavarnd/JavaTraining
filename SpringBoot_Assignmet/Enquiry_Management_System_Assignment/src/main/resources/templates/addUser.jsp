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
    <script th:src="@{js/jquery.sticky-kit.js}"></script>

</head>

<!-- Admin sub-page for adding users or other admins -->
<body>
    <nav class="navbar navbar-expand-sm sticky-top">

        <ul class="navbar-nav">
            <li class="nav-item">
                <h4> Admin Page</h4>
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
            <a th:href="@{/admin}" class="btn btn-outline-info btn-sm ml-sm-2" role="button">Admin Page</a>

        </div>
    </nav>

    <div class="container pb-5">
        <div class="row">

            <div class="col-sm-2 align-self-start" style="background-color: white;">

                <div class="form-group flex-fill mt-2">
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

                <div sec:authorize="hasAnyRole('ROLE_USER')">
                    <div class="alert alert-warning mb-3 mt-10" style="text-align:center">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span>You are logged in as USER, log in as ADMIN to access this page.</span>
                    </div>
                </div>


                <div sec:authorize="hasAnyRole('ROLE_ADMIN', 'ROLE_APPADMIN')">

                    <div th:if="${addError != null}">
                        <div class="alert alert-danger mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>Adding a new user failed. Please check your connection and try again.</span>
                        </div>
                    </div>

                    <div th:if="${nameTaken != null}">
                        <div class="alert alert-warning mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>The name: </span>
                            <strong th:text="${nameTaken}">--name taken--</strong>
                            <span> has been registered already.</span>
                        </div>
                        <div class="alert alert-warning mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>Try again with a different name, perhaps with the first letter from the last name.</span>
                        </div>
                    </div>

                    <div th:if="${emailTaken != null}">
                        <div class="alert alert-warning mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>The email: </span>
                            <strong th:text="${emailTaken}">--email taken--</strong>
                            <span> has been registered already.</span>
                        </div>
                        <div class="alert alert-warning mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>Try again with a different email address.</span>
                        </div>
                    </div>

                    <div th:if="${addDefaultOK != null}">
                        <div class="alert alert-primary mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>You have successfully added a new user with <strong>USER</strong> rights.</span>
                        </div>
                        <div class="alert alert-primary mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>An activation link has been sent to: </span>
                            <span th:text="${addDefaultOK.email}">--demo@gmail.com---</span>
                        </div>
                    </div>

                    <div th:if="${addAdminOK != null}">
                        <div class="alert alert-primary mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>You have successfully added a new user with <strong>ADMIN</strong> rights.</span>
                        </div>
                        <div class="alert alert-primary mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>An activation link has been sent to: </span>
                            <span th:text="${addAdminOK.email}">--demo@gmail.com---</span>
                        </div>
                    </div>


                    <div id="spinner" class="spinner"
                         style="display:none;position: fixed; top: 50%; left: 60%; margin-left: -50px; margin-top: -50px;
                                text-align:center; z-index:1234; overflow: auto; width: 100px; height: 102px;">
                        <img id="img-spinner" src="/images/loader.gif" alt="Loading"/>
                    </div>

                    <h5 class="mt-2">Add New User:</h5>
                    <form action="#" th:action="@{/user/add/defaultRole}" method="post" th:object="${userNew}">
                        <div class="form-group">

                            <input type="hidden" th:value="*{password}" name="password"/>

                            <label for="name" style="color: grey">Name</label>
                            <span class="ml-5" id="form-errors" th:if="${#fields.hasErrors('name')}" th:errors="*{name}">-name errors-</span>
                            <input type="text" class="form-control" id="name" th:field="*{name}" th:placeholder="*{name}"/>
                        </div>

                        <div class="form-group">
                            <label for="email" style="color: grey">Email</label>
                            <span class="ml-5" id="form-errors" th:if="${#fields.hasErrors('email')}" th:errors="*{email}">-email errors-</span>
                            <input type="text" class="form-control" id="email" th:field="*{email}"
                                   th:placeholder="*{email}"/>
                        </div>

                        <button type="submit" class="btn btn-primary btn-block mb-5" id="addDefault">Add New User</button>
                    </form>

                    <h5>Add New Admin:</h5>
                    <form action="#" th:action="@{/user/add/adminRole}" method="post" th:object="${userNew}">
                        <div class="form-group">

                            <input type="hidden" th:value="*{password}" name="password"/>

                            <label for="name" style="color: grey">Name</label>
                            <span class="ml-5" id="form-errors" th:if="${#fields.hasErrors('name')}" th:errors="*{name}">-name errors-</span>
                            <input type="text" class="form-control" id="name" th:field="*{name}" th:placeholder="*{name}"/>
                        </div>

                        <div class="form-group">
                            <label for="email" style="color: grey">Email</label>
                            <span class="ml-5" id="form-errors" th:if="${#fields.hasErrors('email')}" th:errors="*{email}">-email errors-</span>
                            <input type="text" class="form-control" id="email" th:field="*{email}"
                                   th:placeholder="*{email}"/>
                        </div>

                        <button type="submit" class="btn btn-primary btn-block mb-5" id="addAdmin">Add New User</button>
                    </form>


                </div>

                <a th:href="@{/enquiry/list}" class="btn btn-outline-info btn-block mt-3 mb-6" role="button">Back to Enquiry
                    List</a>

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


    <script type="text/javascript">
        $(document).ready(function () {
            $('#addDefault').click(function () {
                $('#spinner').show();
            });
        });

        $(document).ready(function () {
            $('#addAdmin').click(function () {
                $('#spinner').show();
            });
        });

    </script>

   

</body>
</html>















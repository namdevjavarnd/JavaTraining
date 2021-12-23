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
    <script type="text/javascript" th:src="@{/js/admin.js}"></script>

</head>

<!-- Administrator page with option to change user rights, block, activate, send password reset or activation link -->
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
            <a href="/user" class="btn btn-outline-info btn-sm ml-sm-2" role="button">User Page</a>

        </div>
    </nav>

    <div class="container pb-5">
        <div class="row">

            <div class="col-sm-2 align-self-start">

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


                    <div th:if="${emailResetOK != null}">
                        <div class="alert alert-primary mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>A password reset link has been successfully sent to: </span>
                            <span th:text="${emailResetOK.email}">--demo@gmail.com---</span>
                        </div>
                    </div>

                    <div th:if="${emailActivationOK != null}">
                        <div class="alert alert-primary mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>An activation link has been successfully sent to: </span>
                            <span th:text="${emailActivationOK.email}">--demo@gmail.com---</span>
                        </div>
                    </div>


                    <div th:if="${emailResetError == 'error'}">
                        <div class="alert alert-danger mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>Sending password reset link failed. Please check your connection and try again</span>
                        </div>
                    </div>

                    <div th:if="${emailActivationError == 'error'}">
                        <div class="alert alert-danger mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <span>Sending activation link failed. Please check your connection and try again</span>
                        </div>
                    </div>

                    <div th:if="${admin != null}">
                        <div class="alert alert-danger mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <p>The user you are trying to send an activation/password reset link to has higher privileges
                                than you.</p>
                            <p>You must be logged in as Super Admin to do that.</p>
                        </div>
                    </div>

                    <div th:if="${privileges != null}">
                        <div class="alert alert-danger mb-3 mt-10" style="text-align:center">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <p th:text="${privileges}">--insufficient privileges--</p>
                        </div>
                    </div>

                    <div id="spinner" class="spinner"
                         style="display:none;position: fixed; top: 50%; left: 60%; margin-left: -50px; margin-top: -50px;
                                text-align:center; z-index:1234; overflow: auto; width: 100px; height: 102px;">
                        <img id="img-spinner" src="/images/loader.gif" alt="Loading"/>
                    </div>

                    <div class="flex-fill bg-none pb-2 pt-0 mt-2">
                        <div class="float-left pr-2 bg-default"><h5>Users:</h5></div>
                        <div class="float-right pr-2"><a th:href="@{/user/add}"
                                                         class="btn btn-outline-primary btn-sm ml-sm-2" role="button">Add
                            user</a></div>
                    </div>

                    <div class="mt-2 invisible"><p>.</p></div>
                    <table class="table table-sm table-responsive-sm table-borderless" style="font-size: 14px;">
                        <thead style="color:grey;">
                        <tr>
                            <th id="table-cell">ID</th>
                            <th id="table-cell">Name</th>
                            <th id="table-cell">Email</th>
                            <th id="table-cell">Registered</th>
                            <th id="table-cell">Active</th>
                            <th id="table-cell">Blocked</th>
                            <th id="table-cell">Enq. In Progress</th>
                            <th id="table-cell">Enq. Closed</th>
                            <th id="table-cell">Privileges</th>
                            <th></th>
                        </tr>
                        <tr>
                            <td colspan="10"><p
                                    class="mt-0 border border-top-2 border-right-0 border-left-0 border-bottom-2"></p></td>
                        </tr>

                        </thead>
                        <tbody th:each="user : ${users}" th:object="${user}" class="mt-2">

                        <tr>
                            <td id="table-cell-users" th:text="*{id}">3</td>
                            <td id="table-cell-users" th:text="*{name}">John Doe</td>
                            <td id="table-cell-users" th:text="*{email}">john@example.com</td>
                            <td id="table-cell-users" th:text="${#temporals.format(user.registered, 'dd.MM.yyyy HH:mm')}">
                                06.11.2017 18.25
                            </td>
                            <td id="table-cell-users">
                                <span th:if="*{enabled}">Yes</span>
                                <span th:unless="*{enabled}">No</span>
                            </td>
                            <td id="table-cell-users">
                                <span th:if="*{blocked}">Yes</span>
                                <span th:unless="*{blocked}">No</span>
                            </td>
                            <td id="table-cell-users" th:text="${#lists.size(user.enquiriesProgress)}">in progress</td>
                            <td id="table-cell-users" th:text="${#lists.size(user.enquiriesClosed)}">closed</td>
                            <td id="table-cell-users">
                                <div th:if="*{roles[0].role == 'ROLE_USER'}">
                                    <strong style="color: grey">User</strong>
                                </div>
                                <div th:if="*{roles[0].role == 'ROLE_ADMIN'}">
                                    <strong style="color: orange">Admin</strong>
                                </div>
                                <div th:if="*{roles[0].role == 'ROLE_APPADMIN'}">
                                    <strong style="color: red">Super Admin</strong>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <form action="#" th:action="@{/user/activate}" method="post" role="form"
                                      th:object="${user}">
                                    <input type="hidden" th:value="*{id}" name="id"/>
                                    <button type="submit" class="btn btn-outline-info btn-sm btn-block" id="activate">
                                        Re-send Activation Link
                                    </button>
                                </form>

                            </td>

                            <td colspan="2">
                                <form action="#" th:action="@{/user/reset}" method="post" role="form" th:object="${user}">
                                    <input type="hidden" th:value="*{id}" name="id"/>
                                    <button type="submit" class="btn btn-outline-info btn-sm btn-block" id="reset">
                                        Send Password Reset Link
                                    </button>
                                </form>

                            </td>

                            <td colspan="2">
                                <form action="#" th:action="@{/user/enable}" method="post" role="form" th:object="${user}">
                                    <input type="hidden" th:value="*{id}" name="id"/>
                                    <button type="submit" class="btn btn-outline-success btn-sm btn-block">
                                        Enable / Disable
                                    </button>
                                </form>
                            </td>

                            <td colspan="2">
                                <form action="#" th:action="@{/user/block}" method="post" role="form" th:object="${user}">
                                    <input type="hidden" th:value="*{id}" name="id"/>
                                    <button type="submit" class="btn btn-outline-danger btn-sm btn-block">
                                        Block / Unblock
                                    </button>
                                </form>
                            </td>

                            <td colspan="2">
                                <form action="#" th:action="@{/user/privileges}" method="post" role="form"
                                      th:object="${user}">
                                    <input type="hidden" th:value="*{id}" name="id"/>
                                    <button type="submit" class="btn btn-outline-danger btn-sm btn-block">
                                        User / Admin
                                    </button>
                                </form>
                            </td>
                        </tr>

                        <tr>
                            <td colspan="10"><p
                                    class="mt-1 border border-top-2 border-right-0 border-left-0 border-bottom-0"></p></td>
                        </tr>

                        </tbody>

                    </table>

                </div>

                <a th:href="@{/enquiry/list}" class="btn btn-outline-info btn-block mt-4 mb-20" role="button">Back to
                    Enquiry List</a>

            </div>

            <div class="mt-0 invisible" style="background-color: white">.</div>
        </div>
    </div>


    <div class="mt-0"></div>
    <footer class="footer bg-dark text-white m-0 p-0">
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



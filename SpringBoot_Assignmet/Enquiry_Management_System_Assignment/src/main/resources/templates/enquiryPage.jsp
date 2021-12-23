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
    <!--    <script type="text/javascript" th:inline="javascript" th:src="@{/js/page.js}"></script> -->

</head>

<!-- Individual detailed enquiry page -->
<body>
    <nav class="navbar navbar-expand-sm sticky-top">

        <ul class="navbar-nav mt-0 ">
            <li class="nav-item">
                <h4>Manage Enquiry</h4>
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
            <a th:href="@{/user}" class="btn btn-outline-info btn-sm ml-sm-2" role="button">User / Admin Page</a>

        </div>
    </nav>

    <div class="container">
        <div class="row">

            <div class="col-sm-2 align-self-start" style="background-color: white;">


                <div class="form-group flex-fill">
                    <form action="#" th:action="@{/enquiry/list}" method="post" role="form" th:object="${enquiry}">
                        <input type="hidden" th:field="*{id}"/>
                        <input type="hidden" th:field="*{status}"/>
                        <button type="submit" class="btn btn-info btn-sm btn-block">
                            Back to Enquiry List
                        </button>
                    </form>
                </div>

                <div class="form-group flex-fill">
                    <form action="#" th:action="@{/enquiry/printable}" method="post" role="form" th:object="${enquiry}"
                          target="_blank">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                        </div>
                        <button type="submit" class="btn btn-sm btn-outline-warning btn-block mt-0" id="printable">Print
                            Friendly
                        </button>
                    </form>
                </div>
                <div class="form-group flex-fill">
                    <form action="#" th:action="@{/enquiry/pdf}" method="post" role="form" th:object="${enquiry}">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                        </div>
                        <button type="submit" class="btn btn-sm btn-outline-warning btn-block mt-0" id="pdf">Save as PDF
                        </button>
                    </form>
                </div>
                <div class="form-group flex-fill">
                    <form action="#" th:action="@{/enquiry/email}" method="post" role="form" th:object="${enquiry}">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                        </div>
                        <button type="submit" class="btn btn-sm btn-outline-warning btn-block mt-0" id="email">Email
                            Enquiry
                        </button>
                    </form>
                </div>

                <h6 style="text-align:center" class="mb-3 mt-4">All Enquiries</h6>
                <div class="form-group flex-fill">
                    <a th:href="@{/enquiry/list/waiting}"
                       class="btn btn-outline-danger btn-sm btn-block mw-100" role="button">
                        Waiting <span class="badge badge-light ml-2" th:text="${waiting}">4</span>
                    </a>
                </div>
                <div class="form-group flex-fill">
                    <a th:href="@{/enquiry/list/progress}"
                       class="btn btn-outline-primary btn-sm btn-block mw-100" role="button">
                        In Progress <span class="badge badge-light ml-2" th:text="${opened}">- 4 -</span>
                    </a>
                </div>
                <div class="form-group flex-fill mb-5">
                    <a th:href="@{/enquiry/list/closed}"
                       class="btn btn-outline-secondary btn-sm btn-block mw-100" role="button">
                        Closed <span class="badge badge-light ml-2" th:text="${closed}">- 4 -</span>
                    </a>
                </div>

                <h6 style="text-align:center" class="mb-3">My Enquiries</h6>
                <div class="form-group flex-fill">
                    <a th:href="@{/enquiry/list/progress/user/assigned}"
                       class="btn btn-outline-info btn-sm btn-block mw-100" role="button">
                        Assigned/Open<span class="badge badge-light ml-1" th:text="${openedByUser}">- 4 -</span>
                    </a>
                </div>
                <div class="form-group flex-fill">
                    <a th:href="@{/enquiry/list/closed/user/assigned}"
                       class="btn btn-outline-info btn-sm btn-block mw-100" role="button">
                        Assigned/Closed <span class="badge badge-light ml-1"
                                              th:text="${assignedToUserAndClosed}">- 4 -</span>
                    </a>
                </div>
                <div class="form-group flex-fill mb-5">
                    <a th:href="@{/enquiry/list/closed/user/closed}"
                       class="btn btn-outline-info btn-sm btn-block mw-100" role="button">
                        Closed by Me <span class="badge badge-light ml-1" th:text="${closedByUser}">- 4 -</span>
                    </a>
                </div>

            </div>

            <div class="col-md-10 border border-default border-top-0 border-right-0 border-bottom-0">

                <div th:if="${email != null}">
                    <div id="table-cell" class="alert alert-primary alert-dismiss mb-3">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong th:text="${email + currentUser.email}">--demo@demo.com--</strong>
                    </div>
                </div>
                <div th:if="${emailFail != null}">
                    <div id="table-cell" class="alert alert-danger alert-dismiss mb-3">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong th:text="${emailFail}">--demo@demo.com--</strong>
                    </div>
                </div>

                <div class="d-flex justify-content-start bg-default mb-1">
                    <div class="p-0 bg-default flex-fill">
                        <!--
                                       <div class="float-left pr-2 pb-0 mt-3 flex-fill">
                                      <div class="form-group flex-fill">
                                        <h5 style="text-align: center; color: darkblue;">Manage Enquiry</h5>
                                      </div>
                                    </div>
                          -->


                        <div class="float-right pr-0 flex-fill">
                            <div class="form-group flex-fill">
                                <form action="#" th:action="@{/enquiry/close}" method="post" role="form"
                                      th:object="${enquiry}">
                                    <div class="form-group m-0">
                                        <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                                    </div>
                                    <button type="submit" class="btn btn-sm btn-outline-primary btn-block">Close</button>
                                </form>
                            </div>
                        </div>

                        <div class="float-right pr-2 flex-fill">
                            <div class="form-group flex-fill">
                                <form action="#" th:action="@{/enquiry/open}" method="post" role="form"
                                      th:object="${enquiry}">
                                    <div class="form-group m-0">
                                        <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                                    </div>
                                    <button type="submit" class="btn btn-sm btn-outline-primary btn-block">Open</button>
                                </form>
                            </div>
                        </div>

                        <div class="float-right pr-2 flex-fill">
                            <div class="form-group flex-fill">
                                <form action="#" th:action="@{/enquiry/deassign}" method="post" role="form"
                                      th:object="${enquiry}">
                                    <div class="form-group m-0">
                                        <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                                    </div>
                                    <button type="submit" class="btn btn-sm btn-outline-primary btn-block">Remove
                                        Assignment
                                    </button>
                                </form>
                            </div>
                        </div>

                        <div class="float-right pr-2 flex-fill">
                            <div class="form-group flex-fill">
                                <form action="#" th:action="@{/enquiry/assign}" method="post" role="form"
                                      th:object="${enquiry}">
                                    <div class="form-group m-0">
                                        <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                                    </div>
                                    <button type="submit" class="btn btn-sm btn-outline-primary btn-block">Assign</button>
                                </form>
                            </div>
                        </div>

                        <div class="float-left pr-2 flex-fill">
                            <div class="form-group flex-fill">
                                <form action="#" th:action="@{/enquiry/page/previous}" method="post" role="form"
                                      th:object="${enquiry}">
                                    <div class="form-group m-0">
                                        <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                                      </div>
                                    <button type="submit" class="btn btn-sm btn-info btn-block px-2">Previous</button>
                                </form>
                            </div>
                        </div>
                        <div class="float-left pr-2 flex-fill">
                            <div class="form-group flex-fill">
                                <form action="#" th:action="@{/enquiry/page/next}" method="post" role="form"
                                      th:object="${enquiry}">
                                    <div class="form-group m-0">
                                        <input type="hidden" class="form-control" id="usr" th:value="*{id}" name="id"/>
                                    </div>
                                    <button type="submit" class="btn btn-sm btn-info btn-block px-4">Next</button>
                                </form>
                            </div>
                        </div>
                        <div class="float-left pr-2 flex-fill">
                            <div class="float-left pr-4 flex-fill">
                                <form class="form-inline" action="#" th:action="@{/enquiry/page/goto}"
                                      method="post" role="form" th:object="${formBean}">
                                    <button type="submit" class="btn btn-outline-info btn-sm m-0 mr-2">Go To Enquiry:
                                    </button>
                                    <input style="height:32px; width: 80px; font-size:14px;" type="number"
                                           class="form-control" th:field="*{number}">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div style="border: 1px solid lightgrey">

                    <table class="table table-sm table-borderless">
                        <tbody>
                        <!-- 1st row -->
                        <tr style="background-color:#666666;">
                            <td colspan="2">
                                <div class="d-flex justify-content-start bg-default mb-0">
                                    <div class="p-0 bg-default">
                                        <div style="color:white;" class="float-left pr-2"><strong class="pr-2">Enquiry
                                            ID:</strong>
                                            <span th:text="${enquiry.id}">1475</span></div>
                                    </div>
                                </div>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <!-- 2nd row -->
                        <tr class="mb-1" style="background-color:beige;">
                            <td colspan="2">
                                <div class="d-flex justify-content-start bg-default mb-0">
                                    <div class="p-0 bg-default">
                                        <div class="float-left pr-2"><strong class="pr-2">Customer's name:</strong>
                                            <span th:text="${enquiry.name}">Jon Doe</span></div>
                                    </div>
                                </div>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <!-- 3rd row -->
                        <tr class="mb-2 pr-0 mr-0" style="background-color:beige;">
                            <td colspan="1">
                                <div class="d-flex justify-content-start bg-default mb-0">
                                    <div class="p-0 bg-default">
                                        <div class="float-left pr-2"><strong class="pr-2">Customer's email:</strong>
                                            <span th:text="${enquiry.email}">doe@gmail.com</span></div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="d-flex justify-content-start bg-default mb-0">
                                    <div class="p-0 bg-default">
                                        <div class="float-left pr-2"><strong class="pr-2">Customer's Phone:</strong>
                                            <span th:text="${enquiry.phone}">07453 345 876</span></div>
                                    </div>
                                </div>
                            </td>
                            <td></td>
                        </tr>
                        <!-- 4th row -->
                        <tr>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Enquiry type:</strong>
                                        <span th:text="${enquiry.type}">Customised maps</span></div>
                                </div>
                            </td>
                            <td>

                            </td>
                        </tr>
                        <!-- 5th row -->
                        <tr>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">ISBN:</strong>
                                        <span th:if="${enquiry.isbn != null}"
                                              th:text="${enquiry.isbn}">978083732948424</span></div>
                                </div>
                            </td>
                            <td>

                            </td>
                        </tr>
                        <!-- 6th row -->
                        <tr>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Created:</strong>
                                        <span th:text="${#temporals.format(enquiry.createdDate, 'dd.MM.yyyy HH:mm')}">01.07.2018 15.36</span>
                                    </div>
                                </div>
                            </td>
                            <td>

                            </td>
                        </tr>
                        <!-- 7th row -->
                        <tr>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Status:</strong>
                                        <strong th:if="${enquiry.status == 'waiting'}" style="color: #ff6666"
                                                th:text="${enquiry.status}">in progress</strong>
                                        <strong th:if="${enquiry.status == 'in progress'}" style="color: #3399ff"
                                                th:text="${enquiry.status}">in progress</strong>
                                        <strong th:if="${enquiry.status == 'closed'}" style="color: grey"
                                                th:text="${enquiry.status}">in progress</strong>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Assigned to:</strong>

                                        <div class="float-right pr-0" th:if="${enquiry.status == 'waiting'}">
                                            <span></span></div>
                                    </div>
                                    <div class="float-left pr-0" th:if="${enquiry.status != 'waiting'}">
                                        <ul th:if="${enquiry.sortedProgressUsersWithDate != null}"
                                            th:each="item : ${enquiry.sortedProgressUsersWithDate}">
                                            <li th:text="${item}">Piotr (piotr@gmail.com)</li>
                                            <li th:remove="all">Martin (martin@gmail.com)</li>
                                            <li th:remove="all">Demo (demo@gmail.com)</li>
                                        </ul>
                                        <div th:unless="${enquiry.sortedProgressUsersWithDate != null}">
                                            <span></span>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr style="background-color:beige;">
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Closed by:</strong>
                                        <span th:unless="${enquiry.status == 'closed'}"></span>
                                        <span th:if="${enquiry.status == 'closed'}" th:text="${enquiry.closingUser.name}">25.01.2018</span>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Closing date:</strong>
                                        <span th:if="${enquiry.status == 'closed'}"
                                              th:text="${#temporals.format(enquiry.closedDate, 'dd.MM.yyyy HH:mm')}">25.01.2018</span>
                                        <span th:unless="${enquiry.status == 'closed'}"></span></div>
                                </div>
                            </td>
                            <td></td>
                        </tr>
                        <!-- the end -->
                    </table>
                </div>

                <div id="spinner" class="spinner"
                     style="display:none;position: fixed; top: 50%; left: 60%; margin-left: -50px; margin-top: -50px;
                                text-align:center; z-index:1234; overflow: auto; width: 100px; height: 102px;">
                    <img id="img-spinner" src="/images/loader.gif" alt="Loading"/>
                </div>

                <div class="mt-5 mb-3">
                    <div class="d-flex justify-content-start bg-default mb-1">
                        <div class="p-0 bg-default">
                            <strong class="pr-2">Query:</strong>
                        </div>
                    </div>

                    <div class="d-flex justify-content-start bg-default mb-1">
                        <div class="p-2 bg-default">
           <span th:text="${enquiry.message}">
           Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius.
           </span></div>
                    </div>
                </div>

                <div class="mb-4">
                    <div class="d-flex justify-content-start bg-default mb-1">
                        <div class="p-0 bg-default">
                            <strong class="pr-2">Area of interest:</strong>
                        </div>
                    </div>
                    <!--
                        <img th:src="${imageDbUrl}" alt="no polygon" style="; display: block; margin-left: auto; margin-right: auto; width: 100%;"/>
                     -->
                    <div th:if="${enquiry.polygon != null}">

                        <div id="map-out" class="mt-1" style="width:100%;height:600px;">
                            <div id="map-canvas"></div>
                            <div id="polygon" th:text="${enquiry.polygon}"></div>
                        </div>

                        <a data-toggle="modal" href="#image">Display "Ready to Save" image from Database.</a>

                        <!-- The Modal -->
                        <div class="modal fade" id="image">
                            <div class="modal-dialog modal-lg" style="max-width: 80% !important;">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Polygon image , click right mouse button to "Save image
                                            as..."</h4>
                                        <button type="button" class="close" data-dismiss="modal">�</button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <img th:src="@{/image/{id}(id=${enquiry.id})}"
                                             alt="There is no saved coverage image in the database for this enquiry"
                                             style="width: 100%;"/>
                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <a th:href="${enquiry.polygonEncoded}" target="_blank" style="display:inline-block; float:right;">
                            Display "Ready to Save" generated image in a new tab</a>
                    </div>

                    <div class="mb-3">

                        <div class="col-msm-9 table-responsive">

                            <div class="d-flex justify-content-start bg-default mb-2 mt-3">
                                <div class="p-0 bg-default">
                                    <strong class="pr-2">Attachements:</strong>
                                </div>
                            </div>

                            <table class="table table-sm">
                                <thead>
                                <tr>
                                    <td id="table-cell-files">#</td>
                                    <td id="table-cell-files">Name</td>
                                    <td id="table-cell-files">Type</td>
                                    <td id="table-cell-files">Size (KB)</td>
                                    <td id="table-cell-files">Preview</td>
                                    <td id="table-cell-files">Download</td>
                                </tr>
                                </thead>
                                <tbody th:each="attachment,iterStat : ${enquiry.attachments}" th:object="${attachment}">
                                <tr>
                                    <td id="table-cell" class="pt-4" th:text="${iterStat.index} + 1">1</td>
                                    <td id="table-cell" class="pt-4" th:text="*{name}">--name--</td>
                                    <td id="table-cell" class="pt-4" th:text="*{mimetype}">--mimetype--</td>
                                    <td id="table-cell" class="pt-4" th:text="*{size}">--size--</td>
                                    <td id="table-cell">
                                        <a data-toggle="modal" th:href="'#file' + ${iterStat.index}">
                                            <img th:src="@{/attachment/{id}(id=${attachment.id})}" alt="no_preview"
                                                 style="width: 200px; height: 75px;"/>
                                        </a>
                                        <!--
                                        <button type="button" class="btn btn-primary" data-toggle="modal" th:attr="data-target='#file' + ${iterStat.index}"> Open Preview
                                        </button>
                                         -->
                                        <!-- The Modal -->
                                        <div class="modal fade" th:id="'file' + ${iterStat.index}">
                                            <div class="modal-dialog modal-lg" style="max-width: 80% !important;">
                                                <div class="modal-content">

                                                    <!-- Modal Header -->
                                                    <div class="modal-header">
                                                        <h4 class="modal-title" th:text="*{name}">--file name--</h4>
                                                        <button type="button" class="close" data-dismiss="modal">�</button>
                                                    </div>

                                                    <!-- Modal body -->
                                                    <div class="modal-body">
                                                        <img th:src="@{/attachment/{id}(id=${attachment.id})}"
                                                             alt="no_preview" style="width: 100%;"/>
                                                    </div>

                                                    <!-- Modal footer -->
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-danger" data-dismiss="modal">
                                                            Close
                                                        </button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>


                                    </td>


                                    <td class="pt-4"><a th:href="@{|/attachment/download?id=*{id}|}"
                                                        class="btn btn-outline-info btn-block" role="button">Download</a>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                            <div class="mt-3"></div>

                            <a href="#comments" data-toggle="collapse" style="text-decoration: none; font-size:16px;">
                                <button class="btn btn-outline-warning btn-block pt-2 pb-2">
                                    <span style="margin-right:10px;">Comments </span><span
                                        style="background-color: white; color: darkgrey; font-size:14px; font-weight: normal;"
                                        class="badge badge-warning" th:text="${#lists.size(enquiry.comments)}">2</span>
                                </button>
                            </a>

                            <div id="comments" class="collapse">
                                <ul th:each="comment : ${enquiry.comments}" th:object="${comment}"
                                    style="list-style: none; padding: 10px; margin-right:10px;margin-left:10px;">
                                    <li>
                                        <div class="shadow-sm p-2 mb-0 bg-white">
                                            <span th:text="*{userName} + ' wrote:'"
                                                  style="display: inline-block; float:left; color: #808080;">- Demo wrote: - </span>
                                            <span style="display: inline-block; float:right; color: darkgrey; font-style: normal;"
                                                  th:text="${#temporals.format(comment.date, 'HH:mm dd.MM.yyyy')}"> - 12:34 2018-08-09 -</span>
                                            <br>
                                            <span th:text="*{content}" style="color: darkgrey;">Content</span>
                                        </div>
                                    </li>
                                </ul>

                                <form action="#" th:action="@{/enquiry/comment}" method="post" role="form"
                                      th:object="${formBean}">
                                    <input type="hidden" th:field="*{enquiryId}" id="enquiryId"/>
                                    <input type="hidden" th:field="*{userId}" id="userId"/>
                                    <div class="form-group">
                                        <label for="content">Add comment</label>
                                        <textarea class="form-control" rows="4" th:field="*{commentContent}"
                                                  placeholder="Your comment..." name="commentContent" id="content">
                      </textarea>
                                    </div>
                                    <button type="submit" class="btn btn-outline-warning btn-block">Add Comment</button>
                                </form>

                            </div>

                        </div>
                        <div>
                            <form action="#" th:action="@{/enquiry/list}" method="post" role="form" th:object="${enquiry}">
                                <input type="hidden" th:field="*{id}"/>
                                <input type="hidden" th:field="*{status}"/>
                                <button type="submit" class="btn btn-outline-info btn-block mt-2">
                                    Back to Enquiry List
                                </button>
                            </form>
                        </div>

                    </div>


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
                            <div id="title3" class="centered3">Visit as online at www.mapasdelmundo.net or in person in our
                                London map kingdom!
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>


    <script>
        /*<![CDATA[*/
        var userId = eval([[${currentUser.id}]]);
        /*]]>*/
        /*<![CDATA[*/
        var enquiryId = eval([[${enquiry.id}]]);
        /*]]>*/

        document.getElementById('userId').value = userId;
        document.getElementById('enquiryId').value = enquiryId;
    </script>

    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=drawing&key=AIzaSyCbeTjn_d4C-OFFJoRbmkfNfvyc7QjkAoM">
    </script>
    <script type="text/javascript" th:inline="javascript">
        function initMap() {

            // Define LatLng coordinates for the polygon's path
            /*<![CDATA[*/
            var polygonCoords = eval([[${enquiry.polygon}]]);
            /*]]>*/

            // Define encoded path for the polygon
            /*<![CDATA[*/
            //   	 var polygonEncoded = eval([[${enquiry.polygonEncoded}]]);
            /*]]>*/

            console.log(polygonCoords);

            /*<![CDATA[*/
    //	   	 	var latitude = eval([[${latitude}]]);
            /*]]>*/

            /*<![CDATA[*/
    //	        var longitude = eval([[${longitude}]]);
            /*]]>*/

    //		  console.log(latitude, longitude);


            //	  var polygonDecoded = google.maps.geometry.encoding.decodePath(polygonEncoded);
            var bounds = new google.maps.LatLngBounds();
            for (var i = 0; i < polygonCoords.length; i++) {
                bounds.extend(new google.maps.LatLng(polygonCoords[i][0], polygonCoords[i][1]));
            }
            console.log(bounds);

            var map = new google.maps.Map(document.getElementById('map-out'), {
                zoom: 8,
                center: {
                    lat: polygonCoords[0][0],
                    lng: polygonCoords[0][1]
                },
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });

            map.setCenter(bounds.getCenter());
            map.fitBounds(bounds);


            var triangleCoords = [
                [25.774, -80.190],
                [18.466, -66.118],
                [32.321, -64.757],
                [25.774, -80.190]
            ];
            var points = [];
            for (var i = 0; i < polygonCoords.length; i++) {
                points.push({
                    lat: polygonCoords[i][0],
                    lng: polygonCoords[i][1]
                });
            }
            // constructs the polygon
            var polygonArea = new google.maps.Polygon({
                paths: points,
                strokeColor: 'blue',
                strokeOpacity: 0.7,
                strokeWeight: 2,
                fillColor: 'yellow',
                fillOpacity: 0.15
            });
            polygonArea.setMap(map);
        }

        google.maps.event.addDomListener(window, "load", initMap);
    </script>


    <script type="text/javascript">
        $(document).ready(function () {
            $('#pdf').click(function () {
                $('#spinner').show();
            });
        });
    </script >
    <script
        type = "text/javascript" >
            $(document).ready(function () {
                $('#printable').click(function () {
                    $('#spinner').show();
                });
            });
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#email').click(function () {
                $('#spinner').show();
            });
        });
    </script>

</body>
</html>















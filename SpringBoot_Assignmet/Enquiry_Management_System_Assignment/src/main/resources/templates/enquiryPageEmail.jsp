<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--suppress XmlDuplicatedId -->
<!-- enquiry email template -->
<html lang="en" class="no-js"
      xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <title>-Enquiries-</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <style type="text/css" media="all">
        html, body, #map-canvas {
            height: 400px;
            width: 100%;
            padding: 10px;
            font-size: 12px;
        }

        button {
            margin: 0 0 10px;
        }

        .fakeimg {
            height: 200px;
            width: 100%;
            background: #aaa;
        }

        .btn-group-xs > .btn, .btn-xs {
            padding: .5rem .5rem;
            font-size: .800rem;
            line-height: .5;
            border-radius: .2rem;
        }

        #table-cell {
            text-align: center;
        }

        #table-cell-files {
            text-align: center;
            font-size: 14px;
        }

        #table-cell-users {
            text-align: center;
            font-size: 14px;
            color: navy;
        }

        #form-errors {
            color: red;
            font-size: 15px;
        }

        #forgot {
            text-decoration: none;
        }

        .collapsing {
            -webkit-transition: all .0s ease-out;
            -o-transition: all .0s ease-out;
            transition: all .0s ease-out;
        }

        #spinner {
            position: fixed;
            top: 50%;
            left: 50%;
            margin-left: -50px;
            margin-top: -50px;
            text-align: center;
            z-index: 1234;
            overflow: auto;
            width: 100px;
            height: 102px;
        }

        .btn-link {
            color: black;
            border: none;
            text-decoration: none !important;
        }

        #map {height: 100%;}

        #panel {
            width: 100%;
            font-family: Arial, sans-serif;
            font-size: 13px;
            float: right;
            margin: 10px;
        }

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

        #delete-button { /* margin-top: 15px;*/
            float: right;
        }

        body {
            font-family: sans-serif;
            font-size: 12px;
        }


    </style>

</head>

<!-- Sets html email layout -->
<body>

 <div class="container" style="margin-top:0px">
        <div class="row">


            <div class="col-md-10">


                <div style="border: 1px solid lightgrey">

                    <table class="table table-large table-borderless" style="width:100%;">
                        <tbody>
                        <!-- 1st row -->
                        <tr style="background-color:#666666;">
                            <td colspan="2">
                                <div class="d-flex justify-content-start bg-default mb-0">
                                    <div class="p-0 bg-default">
                                        <div class="float-left pr-2" style="color: white"><strong class="pr-2">Enquiry
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
                                            <span>-------------------</span></div>
                                    </div>
                                    <div class="float-left pr-0" th:if="${enquiry.status != 'waiting'}">
                                        <ul th:if="${enquiry.sortedProgressUsersWithDate != null}"
                                            th:each="item : ${enquiry.sortedProgressUsersWithDate}">
                                            <li th:text="${item}">Piotr (piotr@gmail.com)</li>
                                            <li th:remove="all">Martin (martin@gmail.com)</li>
                                            <li th:remove="all">Demo (demo@gmail.com)</li>
                                        </ul>
                                        <div th:unless="${enquiry.sortedProgressUsersWithDate != null}">
                                            <span>-------------------</span>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr style="background-color:beige;">
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Closed by:</strong>
                                        <span th:unless="${enquiry.status == 'closed'}">-------------------</span>
                                        <span th:if="${enquiry.status == 'closed'}" th:text="${enquiry.closingUser.name}">25.01.2018</span>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="p-0 bg-info flex-fill">
                                    <div class="float-left pr-2"><strong class="pr-2">Closing date:</strong>
                                        <span th:if="${enquiry.status == 'closed'}"
                                              th:text="${#temporals.format(enquiry.closedDate, 'dd.MM.yyyy HH:mm')}">25.01.2018</span>
                                        <span th:unless="${enquiry.status == 'closed'}">-------------------</span></div>
                                </div>
                            </td>
                            <td></td>
                        </tr>
                        <!-- the end -->
                        </tbody>
                    </table>
                </div>
                <div class="mt-1 mb-2">
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

                <div th:if="${enquiry.polygon != null}">
                    <div class="mb-4">
                        <div class="d-flex justify-content-start bg-default mb-1">
                            <div class="p-0 bg-default">
                                <strong class="pr-2">Area of interest:</strong>
                            </div>
                        </div>

                        <img th:src="${imageDbUrl}" alt="no polygon in database" style="; display: block;
                     margin-left: auto; margin-right: auto; width: 100%;"/>
                    </div>

                    <div class="mb-3">


                        <div th:if="${enquiry.comments != 0}" style="width:100%;">

                            <div class="d-flex justify-content-start bg-default mb-2 mt-3">
                                <div class="p-0 bg-default">
                                    <strong class="pr-2">Comments:</strong>
                                </div>
                            </div>
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
                        </div>

                        <div th:if="${enquiry.attachments != 0}" style="width:100%;">

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


                                    </td>


                                    <td class="pt-4"><a th:href="@{|/attachment/download?id=*{id}|}"
                                                        class="btn btn-outline-info btn-block" role="button">Download</a>
                                    </td>
                                </tr>

                                </tbody>
                            </table>


                            <div class="mt-3"></div>

                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>

    

</body>
</html>














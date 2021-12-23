<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--suppress XmlDuplicatedId -->
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://thymeleaf.org"
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
    <script th:src="@{/js/list.js}"></script>

    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

</head>

<!-- Enquiries list main page after logging in -->
<body>
    <div class="contentAll">
        <nav class="navbar navbar-expand-sm sticky-top">

            <ul class="navbar-nav mt-0 ">
                <li class="nav-item">
                    <h4> Enquiry List</h4>
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
                <a th:href="@{/user}" class="btn btn-outline-info btn-sm ml-sm-2" role="button">User /Admin Page</a>

            </div>
        </nav>

        <div class="container">
            <div class="row">

                <div class="col-sm-2 align-self-start" style="background-color: white;">

                    <h6 style="text-align:center" class="mb-3 mt-2">All Enquiries</h6>
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


                    <div class="form-group flex-fill">
                        <a th:href="@{/enquiry/list100/pdf}" target="_blank"
                           class="btn btn-outline-warning btn-sm btn-block mw-100" role="button">
                            Save List as PDF</a>
                    </div>


                </div>


                <div class="col-sm-10 border border-default border-top-0 border-right-0 border-bottom-0">

                    <div class="d-flex justify-content-start bg-default mb-0">

                        <div class="float-left pr-2 pb-0 flex-fill mb-1">
                            <div class="form-group flex-fill pb-0 mb-0">

                                <div class="float-left pr-4 flex-fill">
                                    <form class="form-inline" action="#" th:action="@{/enquiry/list/last/custom}"
                                          method="post" role="form" th:object="${formBean}">
                                        <button type="submit" class="btn btn-outline-primary btn-sm m-0 mr-2">Load Most
                                            Recent:
                                        </button>
                                        <input style="height:32px; width: 80px; font-size:14px;" type="number"
                                               class="form-control" th:field="*{number}">
                                    </form>
                                </div>
                                <div class="float-left pr-5 flex-fill">
                                    <form class="form-inline" action="#" th:action="@{/enquiry/search/id}"
                                          method="post" role="form" th:object="${formBean}">
                                        <button type="submit" class="btn btn-outline-primary btn-sm m-0 mr-2">Load By ID:
                                        </button>
                                        <input style="height:32px; width: 250px; font-size:14px;" type="text"
                                               class="form-control" th:field="*{numbersAsString}">
                                        <a href="#" data-toggle="searchId" title="Load Enquiries By ID"
                                           data-placement="top"
                                           data-html="true"
                                           data-trigger="focus"
                                           data-content="You can:
                                            <ul>
                                                <li>an individual enquiry: <strong>34</strong></li>
                                                <li>a few enquires (coma separated):</br> <strong>34, 65, 2, 44</strong></li>
                                                <li>a range of enquiries: <strong>34-45</strong></li>
                                                <li>a combination of all the above: <strong>34, 23, 42-45, 67, 98</strong></li>
                                            </ul>">
                                            <i class="material-icons ml-3"
                                               style="font-size:20px;color:#a6a6a6">help_outline</i></a>
                                    </form>
                                </div>

                                <!--
                                    <form class="form-inline" action="#" th:action="@{/enquiry/list/last/user}" method="post" role="form" th:object="${formBean}">
                                           <div class="input-group-append">
                                            <button class="btn btn-outline-primary btn-xs btn-block pr-2 pl-2" type="submit">
                                                Load Last:
                                            </button>
                                        </div>
                                           <div class="input-group-append mb-0 mt-0 pt-0">
                                               <input style="height:25px; width: 100px; padding: 0px; margin:0px;" type="number" class="form-control form-control-sm mr-2 mt-0 pt-0" th:field="*{number}"/>
                                           </div>
                                    </form>
                                -->
                            </div>
                        </div>
                        <!--
                                 <div class="float-left pr-2 pb-0  flex-fill mb-1">
                                  <div class="form-group flex-fill pb-0 mb-0">
                                    <a th:href="@{/enquiry/list/waiting}" class="btn btn-outline-primary btn-xs btn-block" role="button">
                                    Only Waiting</a>
                                  </div>
                                </div>
                               <div class="float-left pr-2 pb-0  flex-fill mb-1">
                                  <div class="form-group flex-fill pb-0 mb-0">
                                    <a th:href="@{/enquiry/list/progress}" class="btn btn-outline-primary btn-xs btn-block" role="button">
                                    Only In Progress</a>
                                  </div>
                                </div>
                                <div class="float-left pr-2 pb-0  flex-fill mr-10 mb-1">
                                  <div class="form-group flex-fill pb-0 mb-0">
                                    <a th:href="@{/enquiry/list/closed}" class="btn btn-outline-primary btn-xs btn-block" role="button">
                                    Only Closed</a>
                                  </div>
                                </div>
                     -->
                        <div class="float-right pr-2 pb-0  flex-fill mb-1">
                            <div class="form-group flex-fill pb-0 mb-0">
                                <a th:href="@{/enquiry/list/clear}" class="btn btn-danger btn-sm btn-block" role="button">Clear
                                    Selection</a>
                            </div>
                        </div>
                        <div class="float-right pr-0 pb-0  flex-fill mb-1">
                            <div class="form-group flex-fill pb-0 mb-0">
                                <a href="#search" class="btn btn-primary btn-sm btn-block" data-toggle="collapse">Search
                                    Enquiries</a>
                            </div>
                        </div>

                    </div>

                    <!--
                       <div class="d-flex bg-default mb-0">

                                    <div class="form-group pr-2 flex-fill mb-0">
                                      <a th:href="@{/enquiry/list/progress/user/assigned}" class="btn btn-outline-info btn-xs btn-block" role="button">
                                      Assigned to Me (open)</a>
                                    </div>
                                    <div class="form-group pr-2 flex-fill mb-0">
                                      <a th:href="@{/enquiry/list/closed/user/assigned}" class="btn btn-outline-info btn-xs btn-block" role="button">
                                      Assigned to Me (closed)</a>
                                    </div>
                                    <div class="form-group flex-fill mb-0">
                                      <a th:href="@{/enquiry/list/closed/user/closed}" class="btn btn-outline-info btn-xs btn-block" role="button">
                                      Closed By Me</a>
                                    </div>

                      </div>
                    -->
                    <!-- start of the search module -->
                    <div id="search" class="collapse">

                        <div style="font-size:13px" class="mb-4 mt-4">


                            <form action="#" th:action="@{/enquiry/search/regular}" th:object="${searchWrapper}"
                                  th:method="post">
                                <div class="d-flex justify-content-start bg-default mb-1">
                                    <div class="float-left pr-2 flex-fill">
                                        <span style="font-size:17px">Basic custom search:</span>
                                        <a href="#" data-toggle="regularSearchPopover"
                                           title="Regular Criteria Based Search."
                                           data-placement="top"
                                           data-html="true"
                                           data-trigger="focus"
                                           data-content="Basic search based on selected criteria.
                              You can search for the exact match of a word (recommended) or a phrase.
                              If you add <strong>*</strong> at the end it will work as a wildcard
                              and the search will return  all records containing the group of characters
                               before the <strong>*</strong> symbol.</br>
                              For example if you search for:</br></br>
                              <ul>
                                <li><cite>rable*</cite></li>
                              </ul>
                              the result might include records with:</br>
                              <ul>
                                <li><cite>a world map, prefe<strong>rable</strong> physical</cite></li>
                                <li><cite>John T<strong>rable</strong>some</cite></li>
                                <li><cite>t<strong>rable</strong>some.john@gmail.com</cite></li>
                                <li>etc.</li>
                              </ul>
                              " style="font-size:12px; text-decoration:none; padding-left:10px;">What is this?</a>

                                        <input th:field="*{searchFor}"
                                               style="height: 25px;font-size:13px; padding:0px 5px 0px 10px;"
                                               type="text" class="form-control" placeholder="enter your search term here">
                                    </div>

                                    <div class="float-left mt-1 pr-2 flex-fill mt-2">
                                        <span>in:</span>
                                        <select th:field="*{searchIn}"
                                                style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                class="custom-select mb-1">
                                            <option selected th:field="*{searchIn}" value="all">in all fields</option>
                                            <option th:field="*{searchIn}" value="in customer names">in customer names
                                            </option>
                                            <option th:field="*{searchIn}" value="in customer emails">in customer emails
                                            </option>
                                            <option th:field="*{searchIn}" value="in customer phone numbers">in customer
                                                phone numbers
                                            </option>
                                            <option th:field="*{searchIn}" value="in enquiry messages">in enquiry
                                                messages
                                            </option>
                                            <option th:field="*{searchIn}" value="in enquiry messages">in product isbn
                                            </option>
                                        </select>
                                    </div>

                                    <div class="float-left mt-1 pr-0 flex-fill mt-2">
                                        <span>limit results to (leave '0' for no limit):</span>
                                        <input th:field="*{limit}"
                                               style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                               type="number" class="form-control" placeholder="leave empty for no limit">
                                    </div>
                                </div>

                                <div class="d-flex justify-content-start bg-default mb-2">

                                    <div class="float-left pr-2 flex-fill">
                                        <span>date range:</span>
                                        <input th:field="*{dateRange}"
                                               style="height: 25px; font-size:13px; padding:0px 5px 0px 10px; background-color: white;"
                                               type="text" class="form-control" name="dateRange" value=""
                                               placeholder="leave empty for no limit" readonly="readonly"/>
                                    </div>

                                    <div class="float-left pr-2 flex-fill">
                                        <span>assigned to:</span>
                                        <div th:if="${searchWrapper.userList != null and not #lists.isEmpty(searchWrapper.userList)}">
                                            <select th:id="assignedUser" th:name="assignedUser"
                                                    style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                    class="custom-select mb-0">
                                                <option th:each="userString : *{userList}"
                                                        th:value="${userString}"
                                                        th:text="${userString}"
                                                        th:selected="#{any user}">
                                                </option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="float-left pr-0 flex-fill">
                                        <span>closed by:</span>
                                        <div th:if="${searchWrapper.userList != null and not #lists.isEmpty(searchWrapper.userList)}">
                                            <select th:id="closingUser" th:name="closingUser"
                                                    style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                    class="custom-select mb-0">
                                                <option th:each="userString : *{userList}"
                                                        th:value="${userString}"
                                                        th:text="${userString}"
                                                        th:selected="#{any user}">
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="d-flex justify-content-start bg-default mb-3">

                                    <div class="float-left pr-2 flex-fill">
                                        <span>status:</span>
                                        <select th:field="*{status}"
                                                style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                class="custom-select mb-0">
                                            <option selected th:field="*{status}" value="all">all enquiries</option>
                                            <option th:field="*{status}" value="waiting">waiting</option>
                                            <option th:field="*{status}" value="in progress">in progress</option>
                                            <option th:field="*{status}" value="closed">closed</option>
                                        </select>
                                    </div>
                                    <div class="float-left pr-2 flex-fill">
                                        <span>sort by:</span>
                                        <select th:field="*{sortBy}"
                                                style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                class="custom-select mb-0">
                                            <option selected th:field="*{sortBy}" value="creation date">creation date
                                            </option>
                                            <option th:field="*{sortBy}" value="closing date">closing date</option>
                                            <option th:field="*{sortBy}" value="status">status</option>
                                            <option th:field="*{sortBy}" value="customer's name">customer's name</option>
                                            <option th:field="*{sortBy}" value="customer's email">customer's email</option>
                                            <option th:field="*{sortBy}" value="assigned user">assigned user</option>
                                            <option th:field="*{sortBy}" value="closing user">closing user</option>
                                        </select>
                                    </div>
                                    <div class="float-left pr-0 flex-fill">
                                        <span>direction:</span>
                                        <select th:field="*{direction}"
                                                style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                class="custom-select mb-0">
                                            <option selected th:field="*{direction}" value="ascending">ascending</option>
                                            <option th:field="*{direction}" value="descending">descending</option>
                                        </select>
                                    </div>

                                </div>

                                <button type="submit" class="btn btn-outline-primary btn-block mt-2">Search</button>

                            </form>
                        </div>

                        <div style="font-size:13px" class="mb-5">


                            <!-- Hibernate Search -->

                            <form action="#" th:action="@{/enquiry/search/fuzzy}" th:object="${searchWrapper}"
                                  th:method="post">
                                <div class="d-flex flex-fill justify-content-start bg-default mb-3">
                                    <div class="d-flex flex-fill justify-content-start bg-default mb-0 mr-4">
                                        <div class="float-left pr-2 flex-fill">
                                            <span style="font-size:17px">Full-text search:</span>
                                            <a href="#" data-toggle="fullTextSearchPopover" title="Full Text Search."
                                               data-placement="top"
                                               data-html="true"
                                               data-trigger="focus"
                                               data-content="Works comparably to Google search, please refer to the specific
                              options below for details."
                                               style="font-size:12px; text-decoration:none; padding-left:10px;">What is
                                                this?</a>
                                            <input th:field="*{searchFor}"
                                                   style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;"
                                                   type="text" class="form-control" id="usr" name="username"
                                                   placeholder="enter one or more words or a phrase you're looking for">
                                        </div>
                                    </div>
                                    <div class="float-right ml-10 mt-4 pr-3 ">
                                        <div class="custom-control custom-radio">
                                            <input type="radio" class="custom-control-input" id="searchRadio9"
                                                   th:field="*{selector}" value="simpleQueryString"/>
                                            <label class="custom-control-label" for="searchRadio9">
                                                Simple Query Builder
                                                <a href="#" data-toggle="simpleQueryStringPopover"
                                                   title="Simple Query Builder"
                                                   data-placement="top"
                                                   data-html="true"
                                                   data-content="SUPPORTED:
                                            <ul>
                                                <li>boolean:</br>
                                                  AND using “<strong>+</strong>”</br>
                                                  OR using “<strong>|</strong>”</br>
                                                  NOT using “<strong>-</strong>”</li>
                                                <li>prefix (prefix*)</li>
                                                <li>phrase (“some phrase”)<l/i>
                                                <li>precedence (using parentheses)</li>
                                                <li>fuzzy (fuzy~2)</li>
                                                <li>near operator for phrase queries (“some phrase”~3)</li>
                                            </ul>">
                                                    <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <table class="table table-borderless table-sm">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio1"
                                                       th:field="*{selector}" value="keywordExact"/>
                                                <label class="custom-control-label" for="searchRadio1">
                                                    Keyword, Exact Match
                                                    <a href="#" data-toggle="keywordExactPopover"
                                                       title="Keyword, Exact Match"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for the exact match of every entered word separately.
                                            The more words match the higher score. ">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio2"
                                                       th:field="*{selector}" value="keywordWildcard"/>
                                                <label class="custom-control-label" for="searchRadio2">
                                                    Keyword, Wildcard Match
                                                    <a href="#" data-toggle="keywordWildcardPopover"
                                                       title="Keyword, Wildcard Match"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for a match of one word .
                                            Wildcards allowed:
                                            <ul>
                                                <li><strong>?</strong> to replace one character</li>
                                                <li><strong>*</strong> to replace multiple characters</li>
                                            </ul> ">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio3"
                                                       th:field="*{selector}" value="keywordFuzzy1"/>
                                                <label class="custom-control-label" for="searchRadio3">
                                                    Fuzzy Match 1
                                                    <a href="#" data-toggle="keywordFuzzy1Popover"
                                                       title="Keyword, Fuzzy Match 1"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for a match of every entered word separately.
                                            Allows for one character missing or added in each word.
                                            The more words match the higher score. ">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio4"
                                                       th:field="*{selector}" value="keywordFuzzy2"/>
                                                <label class="custom-control-label" for="searchRadio4">
                                                    Fuzzy Match 2
                                                    <a href="#" data-toggle="keywordFuzzy2Popover"
                                                       title="Keyword, Fuzzy Match 2"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for a match of every entered word separately.
                                            Allows for two characters missing or added in each word.
                                            The more words match the higher score. ">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio5"
                                                       th:field="*{selector}" value="phraseExact"/>
                                                <label class="custom-control-label" for="searchRadio5">
                                                    Phrase Exact Match
                                                    <a href="#" data-toggle="phraseExactPopover" title="Phrase, Exact Match"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for the exact match of a phrase.">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio6"
                                                       th:field="*{selector}" value="phraseSlop1"/>
                                                <label class="custom-control-label" for="searchRadio6">
                                                    Phrase, Slop 1
                                                    <a href="#" data-toggle="phraseSlop1Popover"
                                                       title="Phrase, Slop 1 Match"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for for approximate sentences.
                                            The slop factor defines the number of other words permitted in the sentence.
                                            For example a search phrase:</br>
                                            <cite> I would like to buy a world wall map in another language Arabic</cite></br>
                                            finds:</br>
                                            <cite>I would like to buy a world wall map in another language</cite>
                                            <strong>, preferable</strong>
                                            <cite> Arabic</cite>">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio7"
                                                       th:field="*{selector}" value="phraseSlop2"/>
                                                <label class="custom-control-label" for="searchRadio7">
                                                    Phrase, Slop 2
                                                    <a href="#" data-toggle="phraseSlop2Popover"
                                                       title="Phrase, Slop 2 Match"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for for approximate sentences.
                                            The slop factor defines the number of other words permitted in the sentence.
                                            For example a search phrase:</br>
                                            <cite> I would like to buy a wall map in another language Arabic</cite></br>
                                            finds:</br>
                                            <cite>I would like to buy a</cite>
                                            <strong> world</strong>
                                            <cite> wall map in another language</cite>
                                            <strong>, preferable</strong>
                                            <cite> Arabic</cite>">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" class="custom-control-input" id="searchRadio8"
                                                       th:field="*{selector}" value="phraseSlop3"/>
                                                <label class="custom-control-label" for="searchRadio8">
                                                    Phrase, Slop 3
                                                    <a href="#" data-toggle="phraseSlop3Popover"
                                                       title="Phrase, Slop 3 Match"
                                                       data-html="true"
                                                       data-placement="top"
                                                       data-trigger="focus"
                                                       data-content="Searches for for approximate sentences.
                                            The slop factor defines the number of other words permitted in the sentence.
                                            For example a search phrase:</br>
                                            <cite> I would like to buy a wall  in another language Arabic</cite></br>
                                            finds:</br>
                                            <cite>I would like to buy a</cite>
                                            <strong> world</strong>
                                            <cite> wall</cite>
                                            <strong> map </strong>
                                            <cite>in another language</cite>
                                            <strong>, preferable</strong>
                                            <cite> Arabic</cite>
                                            ">
                                                        <i class="material-icons" style="font-size:16px;color:#a6a6a6">help_outline</i></a>
                                                </label>
                                            </div>
                                        </td>
                                    </tr>

                                    </tbody>
                                </table>


                                <div class="d-flex justify-content-start bg-default mb-2">
                                    <div class="float-left pr-2 flex-fill">
                                        <span>date range:</span>
                                        <input th:field="*{dateRange}"
                                               style="height: 25px; font-size:13px; padding:0px 5px 0px 10px; background-color: white;"
                                               type="text" class="form-control" name="dateRange" value=""
                                               placeholder="leave empty for no limit" readonly="readonly"/>
                                    </div>
                                    <div class="float-left pr-0 flex-fill">
                                        <span>limit results to (leave '0' for no limit):</span>
                                        <input th:field="*{limit}"
                                               style="height: 25px; font-size:13px; padding:0px 5px 0px 10px;" type="number"
                                               class="form-control" placeholder="leave empty for no limit">
                                    </div>
                                </div>
                                <!-- End of Hibernate Search -->

                                <button type="submit" class="btn btn-outline-primary btn-block mt-4">Search</button>

                            </form>
                        </div>
                    </div>
                    <!-- end of the search module -->

                    <div>
                        <h4 style="padding: 0px 0px 0px 0px;"></h4>
                        <table id="enquiries" class="table table-hover table-sm" style="font-size: 13px;">
                            <thead>
                            <tr>
                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="id"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>ID</strong><i class="material-icons"
                                                                  style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>
                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="name"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>Name</strong><i class="material-icons"
                                                                    style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>
                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="email"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>Email</strong><i class="material-icons"
                                                                     style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>
                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="type"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>Type</strong><i class="material-icons"
                                                                    style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>
                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="created"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>Created</strong><i class="material-icons"
                                                                       style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>
                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="status"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>Status</strong><i class="material-icons"
                                                                      style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>

                                <th id="table-cell">By</th>

                                <th id="table-cell">
                                    <form action="#" th:action="@{/enquiry/sort}" method="post" role="form"
                                          th:object="${enquiryListWrapper}">
                                        <input type="hidden" th:field="*{enquiryList}"/>
                                        <input type="hidden" name="sortBy" value="closed"/>
                                        <button style="color: black; text-decoration: none;"
                                                class="btn btn-link btn-xs m-0 p-0" type="submit">
                                            <strong>Closed</strong><i class="material-icons"
                                                                      style="font-size:18px;color:#b3b3b3">import_export</i>
                                        </button>
                                    </form>
                                </th>
                                <th></th>

                            </tr>
                            </thead>
                            <tbody th:each="enquiry : ${enquiryListWrapper.enquiryList}" th:object="${enquiry}">

                            <tr th:if="*{status == 'waiting'}" style="color: #333;font-style: normal;font-weight: bold;">
                                <td id="table-cell" th:text="*{id}">3</td>
                                <td id="table-cell" th:text="*{name}">John Doe</td>
                                <td id="table-cell" th:text="*{email}">john@example.com</td>
                                <td id="table-cell" th:text="*{type}">Customised maps</td>
                                <td id="table-cell" th:text="${#temporals.format(enquiry.createdDate, 'dd.MM.yyyy HH:mm')}">
                                    06.11.2017 18.25
                                </td>
                                <td id="table-cell" th:text="*{status}">waiting/in progress/closed</td>
                                <td id="table-cell" th:if="*{status == 'waiting'}">----------</td>
                                <td id="table-cell" th:if="*{status == 'in progress'}"
                                    th:text="*{sortedProgressUsersWithDate[0]}">Demo(progress)
                                </td>
                                <td id="table-cell" th:if="*{status == 'closed'}" th:text="*{closingUser.name}">-Demo-</td>
                                <td id="table-cell" th:if="*{status == 'closed'}"
                                    th:text="${#temporals.format(enquiry.closedDate, 'dd.MM.yyyy HH:mm')}">06.11.2017 18.25
                                </td>
                                <td id="table-cell" th:unless="*{status == 'closed'}">----------</td>
                                <td id="table-cell">
                                    <form action="#" th:action="@{/enquiry/page}" method="post" role="form"
                                          th:object="${enquiry}">
                                        <input type="hidden" th:value="*{id}" name="id"/>
                                        <button class="btn btn-outline-info btn-sm" type="submit"
                                                data-toggle="enquiry" th:title="*{name} + '  wrote:'"
                                                data-placement="top"
                                                data-html="true"
                                                data-trigger="hover"
                                                th:data-content="*{message}">
                                            more...
                                        </button>
                                    </form>
                                </td>
                                <td id="table-cell">
                                    <a href="#" data-toggle="tooltip" title="Coverage polygon">
                                        <span th:if="*{polygon != null}"><i class="material-icons"
                                                                            style="font-size:18px;color:#333">format_shapes</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="No coverage polygon">
                                        <span th:if="*{polygon == null}"><i class="material-icons"
                                                                            style="font-size:18px;color:lightgrey">format_shapes</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="Attachment(s)">
                                        <span th:if="*{#lists.size(attachments) != 0}"><i class="material-icons"
                                                                                          style="font-size:18px;color:#333">attach_file</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="No attachments">
                                        <span th:if="*{#lists.size(attachments) == 0}"><i class="material-icons"
                                                                                          style="font-size:18px;color:lightgrey">attach_file</i></span>
                                    </a>
                                </td>
                                <td>
                                    <div th:if="*{#lists.size(comments) != 0}">
                                        <a href="#" data-toggle="tooltip" title="Comments">
                                            <span><i class="material-icons"
                                                     style="font-size:18px;color:#333">insert_comment</i></span>
                                        </a>
                                        <span class="badge badge-warning" th:text="${#lists.size(enquiry.comments)}"
                                              style="background-color:white; color:#333;font-size: 12px;font-weight: normal;"></span>
                                    </div>
                                    <div th:if="*{#lists.size(comments) == 0}">
                                        <a href="#" data-toggle="tooltip" title="No comments">
                                            <span><i class="material-icons" style="font-size:18px;color:lightgrey">insert_comment</i></span>
                                        </a>
                                        <span class="badge badge-warning"
                                              style="background-color:white; color:lightgrey;font-size: 12px;font-weight: normal;">0</span>
                                    </div>
                                </td>
                            </tr>


                            <tr th:if="*{status == 'in progress'}"
                                style="color: black;font-style: normal;font-weight: normal;">
                                <td id="table-cell" th:text="*{id}">3</td>
                                <td id="table-cell" th:text="*{name}">John Doe</td>
                                <td id="table-cell" th:text="*{email}">john@example.com</td>
                                <td id="table-cell" th:text="*{type}">Customised maps</td>
                                <td id="table-cell" th:text="${#temporals.format(enquiry.createdDate, 'dd.MM.yyyy HH:mm')}">
                                    06.11.2017 18.25
                                </td>
                                <td id="table-cell" th:text="*{status}">waiting/in progress/closed</td>
                                <td id="table-cell" th:if="*{status == 'waiting'}">----------</td>
                                <td id="table-cell" th:if="*{status == 'in progress'}"
                                    th:text="*{sortedProgressUsersWithDate[0]}">Demo(progress)
                                </td>
                                <td id="table-cell" th:if="*{status == 'closed'}" th:text="*{closingUser.name}">-Demo-</td>
                                <td id="table-cell" th:if="*{status == 'closed'}"
                                    th:text="${#temporals.format(enquiry.closedDate, 'dd.MM.yyyy HH:mm')}">06.11.2017 18.25
                                </td>
                                <td id="table-cell" th:unless="*{status == 'closed'}">----------</td>
                                <td id="table-cell">
                                    <form action="#" th:action="@{/enquiry/page}" method="post" role="form"
                                          th:object="${enquiry}">
                                        <input type="hidden" th:value="*{id}" name="id"/>
                                        <button class="btn btn-outline-info btn-sm" type="submit"
                                                data-toggle="enquiry" th:title="*{name} + '  wrote:'"
                                                data-placement="top"
                                                data-html="true"
                                                data-trigger="hover"
                                                th:data-content="*{message}">
                                            more...
                                        </button>
                                    </form>
                                </td>
                                <td id="table-cell">
                                    <a href="#" data-toggle="tooltip" title="Coverage polygon">
                                        <span th:if="*{polygon != null}"><i class="material-icons"
                                                                            style="font-size:18px;color:#333">format_shapes</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="No coverage polygon">
                                        <span th:if="*{polygon == null}"><i class="material-icons"
                                                                            style="font-size:18px;color:lightgrey">format_shapes</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="Attachment(s)">
                                        <span th:if="*{#lists.size(attachments) != 0}"><i class="material-icons"
                                                                                          style="font-size:18px;color:#333">attach_file</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="No attachments">
                                        <span th:if="*{#lists.size(attachments) == 0}"><i class="material-icons"
                                                                                          style="font-size:18px;color:lightgrey">attach_file</i></span>
                                    </a>
                                </td>
                                <td>
                                    <div th:if="*{#lists.size(comments) != 0}">
                                        <a href="#" data-toggle="tooltip" title="Comments">
                                            <span><i class="material-icons"
                                                     style="font-size:18px;color:#333">insert_comment</i></span>
                                        </a>
                                        <span class="badge badge-warning" th:text="${#lists.size(enquiry.comments)}"
                                              style="background-color:white; color:#333;font-size: 12px;font-weight: normal;"></span>
                                    </div>
                                    <div th:if="*{#lists.size(comments) == 0}">
                                        <a href="#" data-toggle="tooltip" title="No comments">
                                            <span><i class="material-icons" style="font-size:18px;color:lightgrey">insert_comment</i></span>
                                        </a>
                                        <span class="badge badge-warning"
                                              style="background-color:white; color:lightgrey;font-size: 12px;font-weight: normal;">0</span>
                                    </div>
                                </td>
                            </tr>

                            <tr th:if="*{status == 'closed'}"
                                style="color: lightgrey;font-style: normal;font-weight: normal;">
                                <td id="table-cell" th:text="*{id}">3</td>
                                <td id="table-cell" th:text="*{name}">John Doe</td>
                                <td id="table-cell" th:text="*{email}">john@example.com</td>
                                <td id="table-cell" th:text="*{type}">Customised maps</td>
                                <td id="table-cell" th:text="${#temporals.format(enquiry.createdDate, 'dd.MM.yyyy HH:mm')}">
                                    06.11.2017 18.25
                                </td>
                                <td id="table-cell" th:text="*{status}">waiting/in progress/closed</td>
                                <td id="table-cell" th:if="*{status == 'waiting'}">----------</td>
                                <td id="table-cell" th:if="*{status == 'in progress'}"
                                    th:text="*{sortedProgressUsersWithDate[0]}">Demo(progress)
                                </td>
                                <td id="table-cell" th:if="*{status == 'closed'}" th:text="*{closingUser.name}">-Demo-</td>
                                <td id="table-cell" th:if="*{status == 'closed'}"
                                    th:text="${#temporals.format(enquiry.closedDate, 'dd.MM.yyyy HH:mm')}">06.11.2017 18.25
                                </td>
                                <td id="table-cell" th:unless="*{status == 'closed'}">----------</td>
                                <td id="table-cell">
                                    <form action="#" th:action="@{/enquiry/page}" method="post" role="form"
                                          th:object="${enquiry}">
                                        <input type="hidden" th:value="*{id}" name="id"/>
                                        <button class="btn btn-outline-info btn-sm" type="submit"
                                                style="outline-color:lightgrey !important;"
                                                data-toggle="enquiry" th:title="*{name} + '  wrote:'"
                                                data-placement="top"
                                                data-html="true"
                                                data-trigger="hover"
                                                th:data-content="*{message}">
                                            more...
                                        </button>
                                    </form>
                                </td>
                                <td id="table-cell">
                                    <a href="#" data-toggle="tooltip" title="Coverage polygon">
                                        <span th:if="*{polygon != null}"><i class="material-icons"
                                                                            style="font-size:18px;color:lightgrey">format_shapes</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="No coverage polygon">
                                        <span th:if="*{polygon == null}"><i class="material-icons"
                                                                            style="font-size:18px;color:lightgrey">format_shapes</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="Attachment(s)">
                                        <span th:if="*{#lists.size(attachments) != 0}"><i class="material-icons"
                                                                                          style="font-size:18px;color:lightgrey">attach_file</i></span>
                                    </a>
                                    <a href="#" data-toggle="tooltip" title="No attachments">
                                        <span th:if="*{#lists.size(attachments) == 0}"><i class="material-icons"
                                                                                          style="font-size:18px;color:lightgrey">attach_file</i></span>
                                    </a>
                                </td>
                                <td>
                                    <div th:if="*{#lists.size(comments) != 0}">
                                        <a href="#" data-toggle="tooltip" title="Comments">
                                            <span><i class="material-icons" style="font-size:18px;color:lightgrey">insert_comment</i></span>
                                        </a>
                                        <span class="badge badge-warning" th:text="${#lists.size(enquiry.comments)}"
                                              style="background-color:white; color:lightgrey;font-size: 12px;font-weight: normal;"></span>
                                    </div>
                                    <div th:if="*{#lists.size(comments) == 0}">
                                        <a href="#" data-toggle="tooltip" title="No comments">
                                            <span><i class="material-icons" style="font-size:18px;color:lightgrey">insert_comment</i></span>
                                        </a>
                                        <span class="badge badge-warning"
                                              style="background-color:white; color:lightgrey;font-size: 12px;font-weight: normal;">0</span>
                                    </div>
                                </td>
                            </tr>


                            </tbody>
                        </table>


                    </div>

                </div>

                <div class="mt-0 invisible" style="background-color: white">.</div>
            </div>
        </div>
        <!-- <div class="mt-0"></div> -->
    </div> <!-- end contentAll -->
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















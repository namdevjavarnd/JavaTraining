<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Error page</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        body, html {font-family: Lucida Grande, Helvetica , Geneva, Verdana, Arial, Helvetica, sans-serif;
            color: white; background-color: #333; height: 100%;}
        table td{vertical-align:top; border:solid 1px #888;	padding:10px;}
        .btn-home {font-size: 14px; padding: 5px 40px; border-radius: 8px; background-color: grey; color: black;
            border: 2px solid #555555; webkit-transition-duration: 0.2s; /* Safari */ transition-duration: 0.2s; width: 40%;
            float: left; margin-left:25px; margin-right:25px; }
        .btn-home:hover {background-color: #99b3ff; color: white;}
        .btn-error {font-size: 14px; padding: 5px 40px; border-radius: 8px; background-color: grey; color: black;
            border: 2px solid #555555; webkit-transition-duration: 0.2s; /* Safari */ transition-duration: 0.2s; width: 40%;
            float: left; margin-left:25px; margin-right:25px; }
        .btn-error:hover {background-color: #ff751a; color: white;}
        .box-error {position:absolute; top:25%; left:20px;}
    </style>
</head>
<body>
<br /><br />
<h4 style="display: block; text-align: center;">Oops, sth went wrong, try again</h4>

<br /><br />
<a href="index.html"
   th:href="@{/}"><button class="btn btn-home">Back to Enquiry Form Page</button></a>
<button  class="btn btn-error" data-toggle="collapse" data-target="#error">Show error details</button>

<div id="error" class="collapse">
    <div class="box-error">
        <h1 style="display: block;"> Error stack trace</h1>
        <table style="display: block;">
            <tr>
                <td>Date</td>
                <td th:text="${timestamp}"/>
            </tr>
            <tr>
                <td>Path</td>
                <td th:text="${path}"/>
            </tr>
            <tr>
                <td>Error</td>
                <td th:text="${error}"/>
            </tr>
            <tr>
                <td>Status</td>
                <td th:text="${status}"/>
            </tr>
            <tr>
                <td>Message</td>
                <td th:text="${message}"/>
            </tr>
            <tr>
                <td>Exception</td>
                <td th:text="${exception}"/>
            </tr>
            <tr>
                <td>Trace</td>
                <td>
                    <pre style="color: beige" th:text="${trace}"></pre>
                </td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BOOK</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>

<body>
<a href="../../index.jsp">BACK</a>
<h1>BOOK DETAILS</h1>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Description</th>
        <th width="120">Author</th>
        <th width="120">ISBN</th>
        <th width="120">Year</th>
        <th width="80">isRead</th>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.description}</td>
        <td>${book.author}</td>
        <td>${book.isbn}</td>
        <td>${book.printYear}</td>
        <td>${book.readAlready}</td>
    </tr>
</table>
</body>
</html>
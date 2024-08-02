<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: PC STUDENT
  Date: 8/2/2024
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Book list</h2>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Price</td>
        <td>Category</td>
        <td></td>
    </tr>
    <c:set var="index" value="1"/>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${index}</td>
            <td><c:out value="${book.name}"/></td>
            <td><c:out value="${book.description}"/></td>
            <td><c:out value="${book.price}"/></td>
            <td><c:out value="${book.category_id}"/></td>
            <td><a onclick="return confirm('Are you want delete?')" href="/books/delete?id=<c:out value="${book.id}"/> ">Delete</a></td>
        </tr>
        <c:set var="index" value="${index + 1}"/>
    </c:forEach>
</table>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Room List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Room List</h1>
    <form action="searchRoom" method="get" class="mb-3">
        <input type="text" name="keyword" placeholder="Search by tenant name or phone number" class="form-control">
        <button type="submit" class="btn btn-primary mt-2">Search</button>
    </form>
    <a href="createRoom.jsp" class="btn btn-success mb-3">Add New Room</a>
    <form action="Room" method="Post">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Select</th>
                <th>ID</th>
                <th>Tenant Name</th>
                <th>Phone Number</th>
                <th>Start Date</th>
                <th>Payment Method</th>
                <th>Notes</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${rooms}">
                <tr>
                    <td><input type="checkbox" name="roomId" value="${room.id}"></td>
                    <td>${room.id}</td>
                    <td>${room.tenantName}</td>
                    <td>${room.phoneNumber}</td>
                    <td>${room.startDate}</td>
                    <td>${room.paymentMethodName}</td>
                    <td>${room.notes}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="hidden" name="action" value="delete">
        <button type="submit" class="btn btn-danger">Delete Selected</button>
    </form>
</div>
</body>
</html>

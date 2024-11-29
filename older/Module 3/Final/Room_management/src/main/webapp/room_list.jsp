<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Room List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Room List</h1>
    <form action="searchRoom" method="get" class="mb-3">
        <input type="text" name="keyword" placeholder="Search by tenant name or phone number" class="form-control">
        <button type="submit" class="btn btn-primary mt-2">Search</button>
    </form>
    <a href="createRoom.jsp" class="btn btn-success mb-3">Add New Room</a>
    <form id="roomForm" action="Room" method="Post">
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
        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirmModal">Delete Selected</button>
    </form>

    <!-- Bootstrap Modal -->
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Xác nhận xóa mục này</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Bạn chắc chắn muốn xóa thông tin thuê trọ hay không.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                    <button type="button" class="btn btn-danger" id="confirmDelete">Có</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById('confirmDelete').addEventListener('click', function() {
        document.getElementById('roomForm').submit();
    });
</script>
</body>
</html>

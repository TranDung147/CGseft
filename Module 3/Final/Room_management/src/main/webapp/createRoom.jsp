<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Room</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Create New Room</h1>
    <form action="Room" method="post">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label>Tenant Name</label>
            <input type="text" name="tenantName" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Phone Number</label>
            <input type="text" name="phoneNumber" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Start Date</label>
            <input type="date" name="startDate" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Payment Method</label>
            <select name="paymentMethodId" class="form-control" required>
                <option value="1">Theo tháng</option>
                <option value="2">Theo quý</option>
                <option value="3">Theo năm</option>
            </select>
        </div>
        <div class="form-group">
            <label>Notes</label>
            <textarea name="notes" class="form-control" maxlength="200"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <a href="rooms" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>

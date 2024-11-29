<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<jsp:include page="/views/client/includes/header.jsp"/>

<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">Order</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="Home">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Pages</a></li>
        <li class="breadcrumb-item active text-white">Order</li>
    </ol>
</div>
<!-- Single Page Header End -->

<!-- Cart Page Start -->
<div class="container-fluid py-5">
    <div class="container py-5">
        <div class="table-responsive">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Products</th>
                    <th scope="col">Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <th scope="row">
                            <div class="d-flex align-items-center">
                                <img src="${pageContext.request.contextPath}/views/client${product.imageURL}"
                                     class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;"
                                     alt="">
                            </div>
                        </th>
                        <td>
                            <p class="mb-0 mt-4">${product.fullName}</p>
                        </td>
                        <td>
                            <p class="mb-0 mt-4"><fmt:formatNumber value="${product.price}" type="currency"
                                                                   currencySymbol="$" minFractionDigits="2"
                                                                   maxFractionDigits="2"/></p>
                        </td>
                        <form action="${pageContext.request.contextPath}/Order" method="post">
                            <td style="padding-top: 28px;">
                                <input type="number" name="quantity" value="${product.quantity}"
                                       min="1" max="${mapQuantity[product.productID]}" required>
                            </td>
                            <td>
                                <p class="mb-0 mt-4"><fmt:formatNumber value="${product.price * product.quantity}"
                                                                       type="currency" currencySymbol="$"
                                                                       minFractionDigits="2" maxFractionDigits="2"/></p>
                            </td>
                            <td>
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="productId" value="${product.productID}">
                                <button type="submit"
                                        class="btn btn-md rounded-circle bg-light border mt-4 confirm-btn">
                                    <i class="fa fa-check text-success"></i>
                                </button>
                        </form>
                        <form action="${pageContext.request.contextPath}/Order" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="productId" value="${product.productID}">
                            <button type="submit"
                                    class="btn btn-md rounded-circle bg-light border mt-4 delete-btn">
                                <i class="fa fa-times text-danger"></i>
                            </button>
                        </form>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row g-4 justify-content-end">
                <div class="col-8"></div>
                <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                    <div class="bg-light rounded">
                        <div class="p-4">
                            <h1 class="display-6 mb-4">Total Cost : ${totalCost} $<span class="fw-normal"></span></h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart Page End -->
<jsp:include page="/views/client/includes/footer.jsp"/>

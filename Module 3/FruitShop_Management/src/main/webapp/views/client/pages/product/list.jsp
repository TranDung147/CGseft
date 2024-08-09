<%-- 
    Document   : shop
    Created on : Jul 10, 2024, 4:34:17 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/views/client/includes/header.jsp"/>

<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">Shop</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="Home">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Pages</a></li>
        <li class="breadcrumb-item active text-white">Shop</li>
    </ol>
</div>
<!-- Single Page Header End -->

<!-- Fruits Shop Start-->
<div class="container-fluid fruite py-5">
    <div class="container py-5">
        <h1 class="mb-4">Fresh fruits shop</h1>
        <div class="row g-4">
            <div class="col-lg-12">
                <div class="row g-3">

                        <div class="row g-4 justify-content-center">
                            <c:forEach var="p" items="${result}">
                                <div class="col-md-6 col-lg-6 col-xl-3">
                                    <div class="rounded position-relative fruite-item">
                                        <a href="${pageContext.request.contextPath}/ProductDetail?id=${p.productID}">
                                            <img src="${pageContext.request.contextPath}/views/client${p.imageURL}"
                                                 class="img-fluid w-100 rounded-top" alt="">
                                        </a>

                                        <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                            <h4>${p.fullName}</h4>
                                            <p class="limited-text">${p.description}</p>
                                            <div class="d-flex justify-content-between flex-lg-wrap">
                                                <% String priceRange = request.getParameter("priceRange"); %>

                                                <p class="text-dark fs-5 fw-bold mb-0">$ ${p.price} / kg</p>
                                                <a href="${pageContext.request.contextPath}/ProductDetail?id=${p.productID}"
                                                   class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                        class="fa fa-shopping-bag me-2 text-primary"></i> Buy </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                </div>
            </div>
        </div>
    </div>
</div>


<!-- Fruits Shop End-->
<jsp:include page="/views/client/includes/footer.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/views/client/includes/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">Product Detail</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="Home">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Pages</a></li>
        <li class="breadcrumb-item active text-white">Product Detail</li>
    </ol>
</div>
<!-- Single Page Header End -->
<c:if test="${not empty sessionScope.message}">
    <div class="alert alert-info alert-dismissible fade show" role="alert">
            ${sessionScope.message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <c:remove var="message" scope="session"/>
</c:if>
<!-- Single Product Start -->
<div class="container-fluid py-5 mt-5">
    <div class="container py-5">
        <div class="row g-4 mb-5">
            <div class="col-lg-8 col-xl-9">
                <div class="row g-4">
                    <div class="col-lg-6">
                        <div class="border rounded">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/views/client${product.imageURL}"
                                     class="img-fluid rounded" alt="Image">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <form action="${pageContext.request.contextPath}/Order" method="POST">
                            <h4 class="fw-bold mb-3">${product.fullName}</h4>
                            <input type="hidden" name="action" value="add">
                            <h5 class="fw-bold mb-3">${product.price} $</h5>
                            <div class="d-flex mb-4">
                                <i class="fa fa-star text-secondary"></i>
                                <i class="fa fa-star text-secondary"></i>
                                <i class="fa fa-star text-secondary"></i>
                                <i class="fa fa-star text-secondary"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <p class="mb-4">${product.description}</p>
                            <div class="input-group quantity mb-5" style="width: 100px;">
                                <div class="input-group-btn">
                                    <input type="number" class="form-control form-control-sm text-center border-0"
                                           name="quantity" value="1"
                                           min="1" max="${mapQuantity[product.productID]}"/>
                                </div>
                            </div>
                            <p>${product.quantity} (s) remaining</p>
                            <input type="hidden" name="productId" value="${product.productID}">
                            <button type="submit"
                                    class="btn border border-seacondary text-primary rounded-pill px-4 py-3">Buy
                            </button>
                        </form>
                    </div>

                    <div class="col-lg-12">
                        <nav>
                            <div class="nav nav-tabs mb-3">
                                <button class="nav-link active border-white border-bottom-0" type="button" role="tab"
                                        id="nav-about-tab" data-bs-toggle="tab" data-bs-target="#nav-about"
                                        aria-controls="nav-about" aria-selected="true">Description
                                </button>

                            </div>
                        </nav>
                        <div class="tab-content mb-5">
                            <div class="tab-pane active" id="nav-about" role="tabpanel" aria-labelledby="nav-about-tab">
                                <p>${product.description}</p>
                                <div class="px-2">
                                    <div class="row g-4">
                                        <div class="col-6">
                                            <div class="row bg-light align-items-center text-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Weight</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">1 kg</p>
                                                </div>
                                            </div>
                                            <div class="row text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Country of Origin</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">Agro Farm</p>
                                                </div>
                                            </div>
                                            <div class="row bg-light text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Quality</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">Organic</p>
                                                </div>
                                            </div>
                                            <div class="row text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Сheck</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">Healthy</p>
                                                </div>
                                            </div>
                                            <div class="row bg-light text-center align-items-center justify-content-center py-2">
                                                <div class="col-6">
                                                    <p class="mb-0">Min Weight</p>
                                                </div>
                                                <div class="col-6">
                                                    <p class="mb-0">250 Kg</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xl-3">
                <div class="row g-4 fruite">
                    <div class="col-lg-12">
                        <div class="mb-4">
                            <ul class="list-unstyled fruite-categorie">
                                <c:forEach var="p" items="${products}" varStatus="loop">
                                    <c:if test="${loop.index < 5}">
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="${pageContext.request.contextPath}/ProductController?id=${p.productID}&action=loadProduct">
                                                    <i class="fas fa-apple-alt me-2"></i>
                                                        ${p.fullName}
                                                </a>
                                                <span>${p.quantity}</span>
                                            </div>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <h4 class="mb-4">Featured products</h4>
                        <ul class="list-unstyled fruite-categorie">
                            <c:forEach var="p" items="${features}" varStatus="loop">
                                <c:if test="${loop.index < 3}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/ProductController?id=${p.productID}&action=loadProduct">
                                            <div class="d-flex align-items-center justify-content-start">
                                                <div class="rounded me-4" style="width: 100px; height: 100px;">
                                                    <img src="${pageContext.request.contextPath}${p.imageURL}"
                                                         class="img-fluid rounded" alt="">
                                                </div>
                                                <div>
                                                    <h6 class="mb-2">${p.fullName}</h6>
                                                    <div class="d-flex mb-2">
                                                        <i class="fa fa-star text-secondary"></i>
                                                        <i class="fa fa-star text-secondary"></i>
                                                        <i class="fa fa-star text-secondary"></i>
                                                        <i class="fa fa-star text-secondary"></i>
                                                        <i class="fa fa-star"></i>
                                                    </div>

                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="position-relative">
                        <img src="${pageContext.request.contextPath}/views/client/asset/img/banner-fruits.jpg"
                             class="img-fluid w-100 rounded" alt="">
                        <div class="position-absolute" style="top: 50%; right: 10px; transform: translateY(-50%);">
                            <h3 class="text-secondary fw-bold">Fresh <br> Fruits <br> Banner</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="vesitable">

            <div class="owl-carousel vegetable-carousel justify-content-center">
                <c:forEach var="p" items="${products}">
                    <div class="border border-primary rounded position-relative vesitable-item">
                        <div class="fruite-img">
                            <a href="${pageContext.request.contextPath}/ProductController?id=${p.productID}&action=loadProduct">
                                <img src="${pageContext.request.contextPath}${p.imageURL}"
                                     class="img-fluid w-100 rounded-top" alt="">
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- Single Product End -->
<jsp:include page="/views/client/includes/footer.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="../includes/navbar.jsp"/>

<main id="content" role="main" class="main">
    <!-- Content -->
    <div class="content container-fluid">
        <!-- Page Header -->
        <div class="page-header">
            <div class="row align-items-center mb-3">
                <div class="col-sm mb-2 mb-sm-0">
                    <h1 class="page-header-title">Products <span
                            class="badge badge-soft-dark ml-2">${totalProducts}</span></h1>
                </div>
                    <div class="col-sm-auto">
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/views/admin/product/add-product.jsp">Add Product</a>
                    </div>
            </div>
            <!-- End Row -->

            <!-- Column Control -->
            <div class="mb-3">
                <label style="margin-right: 30px;"><input type="checkbox" class="column-control" data-column="2"
                                                          checked> Product Name</label>
                <label style="margin-right: 30px;"><input type="checkbox" class="column-control" data-column="3"
                                                          checked> Description</label>
                <label style="margin-right: 30px;"><input type="checkbox" class="column-control" data-column="4"
                                                          checked> Quantity</label>
                <label style="margin-right: 30px;"><input type="checkbox" class="column-control" data-column="6"
                                                          checked> Image</label>
                <label style="margin-right: 30px;"><input type="checkbox" class="column-control" data-column="8"
                                                          checked> Price</label>
            </div>
            <!-- End Column Control -->

            <!-- Nav Scroller -->
            <div class="js-nav-scroller hs-nav-scroller-horizontal">
                <span class="hs-nav-scroller-arrow-prev" style="display: none;">
                    <a class="hs-nav-scroller-arrow-link" href="javascript:;">
                        <i class="tio-chevron-left"></i>
                    </a>
                </span>

                <span class="hs-nav-scroller-arrow-next" style="display: none;">
                    <a class="hs-nav-scroller-arrow-link" href="javascript:;">
                        <i class="tio-chevron-right"></i>
                    </a>
                </span>

                <!-- Nav -->
                <ul class="nav nav-tabs page-header-tabs" id="pageHeaderTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">All Products</a>
                    </li>
                </ul>
                <!-- End Nav -->
            </div>
            <!-- End Nav Scroller -->
        </div>
        <!-- End Page Header -->

        <!-- Card -->
        <div class="card">
            <!-- Table -->
            <div class="table-responsive datatable-custom">
                <table id="datatable"
                       class="table table-borderless table-thead-bordered table-nowrap table-align-middle card-table">
                    <thead>
                    <tr>
                        <th scope="col" class="table-column-pr-0"></th>
                        <th>ID</th>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Image</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td class="table-column-pr-0"></td>
                            <td>${product.productID}</td>
                            <td>${product.fullName}</td>
                            <td>${product.description}</td>
                            <td>${product.quantity}</td>
                            <td>
                                <img class="avatar avatar-lg"
                                     src="${pageContext.request.contextPath}/views/client${product.imageURL}"
                                     alt="${product.fullName}">
                            </td>

                            <td>$${product.price}</td>

                            <td>
                                <div class="btn-group" role="group">

                                    <form action="${pageContext.request.contextPath}/Admin" method="GET"
                                          style="display: inline;">
                                        <input type="hidden" name="action" value="edit">
                                        <input type="hidden" name="id" value="${product.productID}">
                                        <button type="submit" class="btn btn-sm btn-warning" style="margin-right: 5px;">
                                            <i class="tio-edit"></i> Edit
                                        </button>
                                    </form>

                                    <form action="${pageContext.request.contextPath}/Admin" method="GET"
                                          style="display: inline;">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="id" value="${product.productID}">
                                        <button type="submit" class="btn btn-sm btn-danger">
                                            <i class="tio-delete"></i> Delete
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- End Table -->


        </div>
        <!-- End Card -->
    </div>
    <!-- End Content -->

    <jsp:include page="../includes/footer.jsp"/>
</main>
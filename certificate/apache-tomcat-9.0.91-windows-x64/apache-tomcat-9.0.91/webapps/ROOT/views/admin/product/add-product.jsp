<jsp:include page="../includes/navbar.jsp"/>

<main id="content" role="main" class="main">

    <div class="content container-fluid">

        <div class="page-header">
            <div class="row align-items-center">
                <div class="col-sm mb-2 mb-sm-0">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb breadcrumb-no-gutter">
                            <li class="breadcrumb-item"><a class="breadcrumb-link" href="ecommerce-products.html">Products</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Add product</li>
                        </ol>
                    </nav>

                    <h1 class="page-header-title">Create new product</h1>
                </div>
            </div>
            <!-- End Row -->
        </div>

        <form method="POST" action="${pageContext.request.contextPath}/AdminCRUD">
            <input type="hidden" name="action" value="add"/>
            <div class="form-group">
                <label>Full Name:</label>
                <input type="text" class="form-control" name="fullName" required>
                <div class="invalid-feedback">
                    Please provide a valid full name.
                </div>
            </div>
            <div class="form-group">
                <label>Description:</label>
                <textarea class="form-control" name="description" rows="3"></textarea>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Quantity:</label>
                    <input type="number" class="form-control" name="quantity" required>
                    <div class="invalid-feedback">
                        Please provide a valid quantity.
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>Price:</label>
                <input type="number" step="0.01" class="form-control" name="price" required>
                <div class="invalid-feedback">
                    Please provide a valid price.
                </div>
            </div>

            <div class="form-group">
                <label for="imgFile">Image File:</label>
                <input type="file" class="form-control-file" id="imgFile" name="imgFile" accept="image/*"
                       onchange="previewImage(event)">
            </div>
            <div class="form-group text-center">
                <img id="imgPreview" src="" alt="Image Preview" class=" mx-auto"
                     style="max-width: 50%; height: 50%; display: none">
            </div>
            <button type="submit" class="btn btn-primary">Create Product</button>
        </form>
    </div>
</main>

<jsp:include page="../includes/footer.jsp"/>


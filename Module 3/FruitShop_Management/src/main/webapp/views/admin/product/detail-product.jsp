<jsp:include page="../includes/navbar.jsp"/>

<main id="content" role="main" class="main">

    <div class="content container-fluid">

        <div class="page-header">
            <div class="row align-items-center">
                <div class="col-sm mb-2 mb-sm-0">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb breadcrumb-no-gutter">
                            <li class="breadcrumb-item"><a class="breadcrumb-link"
                                                           href="${pageContext.request.contextPath}/products">Products</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Product Detail</li>
                        </ol>
                    </nav>
                    <h1 class="page-header-title text-center blinking">Product Detail</h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="product-details">
                    <div class="container mt-4">
                        <h1>Edit Product</h1>
                        <form action="${pageContext.request.contextPath}/AdminCRUD" method="POST" class="needs-validation" novalidate>
                            <input type="hidden" name="productID" value="${product.productID}">
                            <input type="hidden" name="action" value="update"/>
                            <div class="form-group">
                                <label>Full Name:</label>
                                <input type="text" class="form-control" name="fullName" value="${product.fullName}"
                                       required>
                                <div class="invalid-feedback">
                                    Please provide a valid full name.
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Description:</label>
                                <textarea class="form-control" name="description"
                                          rows="3">${product.description}</textarea>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Quantity:</label>
                                    <input type="number" class="form-control" name="quantity"
                                           value="${product.quantity}" required>
                                    <div class="invalid-feedback">
                                        Please provide a valid quantity.
                                    </div>
                                </div>

                            </div>

                            <div class="form-row">

                                <div class="form-group col-md-6">
                                    <label>Price:</label>
                                    <input type="number" step="0.01" class="form-control" name="price"
                                           value="${product.price}" required>
                                    <div class="invalid-feedback">
                                        Please provide a valid price.
                                    </div>
                                </div>
                            </div>

                            <div class="form-group text-center">
                                <label>Current Image:</label><br>
                                <img src="${pageContext.request.contextPath}/views/client${product.imageURL}"
                                     alt="Current Image" style="
                                     width: 200px;
                                     height: 200px;
                                     object-fit: cover;
                                     " class="img-preview">
                            </div>

                            <div class="form-group">
                                <label for="imgFile">Image File:</label>
                                <input type="file" class="form-control-file" id="imgFile" name="imgFile"
                                       accept="image/*" required onchange="previewImage(event)">
                            </div>
                            <div class="form-group text-center">
                                <img id="imgPreview" src="" alt="Image Preview" class=" mx-auto"
                                     style="max-width: 50%; height: 50%; display: none">
                            </div>
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>


<jsp:include page="../includes/footer.jsp"/>

<script>
    function previewImage(event) {
        let reader = new FileReader();
        reader.onload = function () {
            let imgPreview = document.getElementById('imgPreview');
            imgPreview.src = reader.result;
            imgPreview.style.display = 'block';
        };
        let fileInput = event.target;
        if (fileInput.files && fileInput.files[0]) {
            reader.readAsDataURL(fileInput.files[0]);
        }
    }
</script>
<style>
    @keyframes blink {
        0% {
            opacity: 1;
        }
        50% {
            opacity: 0.8;
        }
        100% {
            opacity: 1;
        }
    }

    .blinking {
        animation: blink 1s infinite;
        color: #009aa8; /* Màu n?i b?t */
    }
</style>

package Entity;

public class Product {
    private int productID;
    private String fullName;
    private String description;
    private int quantity;
    private String imageURL;
    private float price;

    public Product() {
    }

    public Product(int productID, String fullName, String description, int quantity, String imageURL, float price) {
        this.productID = productID;
        this.fullName = fullName;
        this.description = description;
        this.quantity = quantity;
        this.imageURL = imageURL;
        this.price = price;
    }

    public Product(String fullName, String description, int quantity, String imageURL, int price) {
        this.fullName = fullName;
        this.description = description;
        this.quantity = quantity;
        this.imageURL = imageURL;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", imageURL='" + imageURL + '\'' +
                ", price=" + price +
                '}';
    }
}

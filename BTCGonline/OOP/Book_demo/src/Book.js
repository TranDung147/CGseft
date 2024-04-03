class Book{
    title;
    price;
    author;
    status;
    image;
    constructor(title, price, author, status, image) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.status = status;
        this.image = image;
    }

    updateName(newName) {
        this.name = newName;
    }
    updatePrice(newPrice){
        this.price = newPrice;
    }
}

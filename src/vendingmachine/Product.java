package vendingmachine;

public class Product {

    String name;
    Float  price;

    Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

}

package strategy;

public class Product implements Priced {

    private double price;
    private String id;

    public Product(String id, double price) {
        this.price = price;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

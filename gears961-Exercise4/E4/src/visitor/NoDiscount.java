package visitor;

public class NoDiscount implements Discount{

    @Override
    public double getDiscountedPrice(double price) {
        return price;
    }
}
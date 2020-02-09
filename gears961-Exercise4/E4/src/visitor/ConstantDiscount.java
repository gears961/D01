package visitor;

public class ConstantDiscount implements Discount{

    private double amount;

    public ConstantDiscount(double amount) {
        this.amount = amount;
    }


    @Override
    public double getDiscountedPrice(double price) {
        return price - amount;
    }
}
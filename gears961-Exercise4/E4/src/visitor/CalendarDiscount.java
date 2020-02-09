package visitor;

public abstract class CalendarDiscount implements Discount{

    private double discountRate;

    public CalendarDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    public abstract boolean isApplicableToday();


    @Override
    public double getDiscountedPrice(double price) {
        if (isApplicableToday()) {
            return (1 - discountRate) * price;
        } else {
            return price;
        }
    }
}
package strategy;

public abstract class CalendarDiscount implements Discount {

    private double discountRate;

    public CalendarDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscountedPrice(double price) {
        if (isApplicableToday()) {
            return (1 - discountRate) * price;
        } else {
            return price;
        }
    }

    public abstract boolean isApplicableToday();
}

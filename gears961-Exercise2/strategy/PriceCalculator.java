package strategy;

public class PriceCalculator {

    private Discount discount;

    public PriceCalculator(Discount discount) {
        this.discount = discount;
    }

    public double getTotalPrice(java.util.Collection<Priced> items) {
        int total = 0;
        for (Priced item: items) {
            total += discount.getDiscountedPrice(item.getPrice());
        }
        return total;
    }
}

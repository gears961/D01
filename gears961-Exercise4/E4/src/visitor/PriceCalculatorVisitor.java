package visitor;

public class PriceCalculatorVisitor extends ItemVisitor{

    private Discount perItemDiscount;
    private Discount overallDiscount;
    private double total;


    public PriceCalculatorVisitor(Discount perItemDiscount, Discount overallDiscount) {
        this.perItemDiscount = perItemDiscount;
        this.overallDiscount = overallDiscount;
        this.total = 0;
    }

    @Override
    public void visitBulkItem(BulkItem item) {
        total += perItemDiscount.getDiscountedPrice(item.getPricePerLb() * item.getWeight());
    }

    @Override
    public void visitPackagedItem(PackagedItem item) {
        total += perItemDiscount.getDiscountedPrice(item.getPrice());
    }

    public double getTotal() {
        return overallDiscount.getDiscountedPrice(total);
    }
}
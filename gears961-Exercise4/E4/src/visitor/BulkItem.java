package visitor;

public class BulkItem extends Item {

    private double weight;
    private double pricePerLb;

    public BulkItem(String name, double pricePerLb, double weight) {
        super(name);
        this.weight = weight;
        this.pricePerLb = pricePerLb;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerLb() {
        return pricePerLb;
    }

    @Override
    public void accept(ItemVisitor v) {
        v.visitBulkItem(this);
    }

    @Override
    public String toString() {
        return String.format("%-8s %.2flb @ $%.2f/lb", this.getName(), this.getWeight(), this.getPricePerLb());
    }
}

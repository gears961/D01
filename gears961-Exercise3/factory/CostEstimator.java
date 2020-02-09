package factory;

public abstract class CostEstimator {

    public abstract TaxEstimator getTaxEstimator();

    public double estimateSupplyCost(int quantity, double price) {
        return quantity * price * (1 + this.getTaxEstimator().getSalesTax());
    }

}

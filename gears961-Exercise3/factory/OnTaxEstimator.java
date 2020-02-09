package factory;

public class OnTaxEstimator implements TaxEstimator{

  private final double HST = 0.14;

  @Override
  public double getSalesTax() {
    return HST;
  }
}

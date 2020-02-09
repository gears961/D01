package factory;

public class QcTaxEstimator implements TaxEstimator {

  private final double GST = 0.05;
  private final double PST = 0.09975;


  @Override
  public double getSalesTax() {
    return GST+PST;
  }
}

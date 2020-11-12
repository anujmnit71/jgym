package io.jgym.warmups.day05;

public class TrustTaxStrategy implements TaxStrategy {
  public double calculateTax(double income) {
    return income * 0.45;
  }
}

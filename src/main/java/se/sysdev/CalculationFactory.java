package se.sysdev;

public interface CalculationFactory {

  Calculation getCalculation(String type);
}

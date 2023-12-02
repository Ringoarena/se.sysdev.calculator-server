package se.sysdev.calculator.domain;

public interface CalculationFactory {
  Calculation getCalculation(String type);
}

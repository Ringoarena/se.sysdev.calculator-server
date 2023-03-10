package se.sysdev;

public class DefaultCalculationFactory implements CalculationFactory {

  @Override
  public Calculation getCalculation(String type) {
    switch (type) {
      case "addition":
        return new AdditionCalculation();
      case "multiplication":
        return new MultiplicationCalculation();
      default:
        System.out.println("Error: Operation type " + type + " not supported.");
        throw new UnsupportedOperationException("Operation type " + type + " not supported.");
    }
  }
}

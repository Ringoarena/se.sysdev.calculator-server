package se.sysdev;

public class DefaultCalculatorService implements CalculatorService {
  private CalculationFactory calculatorFactory;

  public DefaultCalculatorService(CalculationFactory calculatorFactory) {
    this.calculatorFactory = calculatorFactory;
  }

  @Override
  public long calculate(String type, Integer[] operands) {
    Calculation c = this.calculatorFactory.getCalculation(type);
    return c.calculate(operands);
  }
}

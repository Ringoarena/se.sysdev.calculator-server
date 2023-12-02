package se.sysdev.calculator.domain.calculations;

import se.sysdev.calculator.domain.Calculation;

public class MultiplicationCalculation implements Calculation {

  @Override
  public long calculate(long[] operands) {
    long operand1 = operands[0];
    long operand2 = operands[1];
    return (long) operand1 * operand2;
  }
}
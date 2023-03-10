package se.sysdev;

public class MultiplicationCalculation implements Calculation {

  @Override
  public long calculate(Integer[] operands) {
    int operand1 = operands[0];
    int operand2 = operands[1];
    return (long) operand1 * operand2;
  }
}

package se.sysdev.calculator.domain.dto;

public class CalculationPayload {
  public String operation;
  public long[] operands;

  public CalculationPayload() {
  }

  public CalculationPayload(String operation, long[] operands) {
    this.operation = operation;
    this.operands = operands;
  }
}

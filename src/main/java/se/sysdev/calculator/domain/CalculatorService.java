package se.sysdev.calculator.domain;

import se.sysdev.calculator.domain.dto.CalculationPayload;

public interface CalculatorService {

  String[] getAvailableOperations();

  long calculate(CalculationPayload payload);
}

package se.sysdev.calculator.domain;

import se.sysdev.calculator.domain.dto.CalculationPayload;

public interface CalculatorService {

  long calculate(CalculationPayload payload);
}

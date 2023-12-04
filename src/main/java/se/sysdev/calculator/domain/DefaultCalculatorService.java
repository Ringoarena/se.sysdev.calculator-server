package se.sysdev.calculator.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sysdev.calculator.domain.dto.CalculationPayload;

@Service
public class DefaultCalculatorService implements CalculatorService {
  @Autowired
  private CalculationFactory calculationFactory;
  private String[] availableOperations = new String[]{"addition", "multiplication"};

  @Override
  public String[] getAvailableOperations() {
    return availableOperations;
  }

  @Override
  public long calculate(CalculationPayload payload) {
    Calculation c = this.calculationFactory.getCalculation(payload.operation);
    return c.calculate(payload.operands);
  }
}
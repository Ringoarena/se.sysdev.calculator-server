package se.sysdev.calculator.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sysdev.calculator.domain.dto.CalculationPayload;

@Service
public class DefaultCalculatorService implements CalculatorService {

  @Autowired
  private CalculationFactory calculationFactory;

  @Override
  public long calculate(CalculationPayload payload) {
    Calculation c = this.calculationFactory.getCalculation(payload.operation);
    return c.calculate(payload.operands);
  }
}
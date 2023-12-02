package se.sysdev.calculator.domain;

import org.springframework.stereotype.Service;
import se.sysdev.calculator.domain.calculations.AdditionCalculation;
import se.sysdev.calculator.domain.calculations.MultiplicationCalculation;

@Service
public class DefaultCalculationFactory implements CalculationFactory {

  @Override
  public Calculation getCalculation(String type) {
    switch (type) {
      case "addition":
        return new AdditionCalculation();
      case "multiplication":
        return new MultiplicationCalculation();
      default:
        String errorMessage = "Operation '" + type + "' not supported.";
        System.out.println(errorMessage);
        throw new UnsupportedOperationException(errorMessage);
    }
  }
}
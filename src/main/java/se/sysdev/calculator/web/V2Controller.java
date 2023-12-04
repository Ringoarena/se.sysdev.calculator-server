package se.sysdev.calculator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sysdev.calculator.domain.dto.OperationsResponse;
import se.sysdev.calculator.domain.dto.CalculationPayload;
import se.sysdev.calculator.domain.dto.CalculationResponse;
import se.sysdev.calculator.domain.CalculatorService;

@RestController
@RequestMapping("v2")
public class V2Controller {
  @Autowired
  private CalculatorService service;

  @GetMapping("/operations")
  public OperationsResponse getAvailableOperations() {
    String[] availableOperations = this.service.getAvailableOperations();
    return new OperationsResponse(availableOperations);
  }

  @PostMapping("/calculation")
  public CalculationResponse calculate(@RequestBody CalculationPayload payload) {
    long result = this.service.calculate(payload);
    return new CalculationResponse(result);
  }
}

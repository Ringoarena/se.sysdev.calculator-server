package se.sysdev.calculator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.sysdev.calculator.domain.dto.CalculationPayload;
import se.sysdev.calculator.domain.dto.CalculationResult;
import se.sysdev.calculator.domain.CalculatorService;

@RestController
@RequestMapping("v2")
public class V2Controller {

  @Autowired
  private CalculatorService service;

  @PostMapping("/calculation")
  public CalculationResult calculate(@RequestBody CalculationPayload payload) {
    long result = this.service.calculate(payload);
    return new CalculationResult(result);
  }
}

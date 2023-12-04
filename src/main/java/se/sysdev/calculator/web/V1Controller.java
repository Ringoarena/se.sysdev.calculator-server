package se.sysdev.calculator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.sysdev.calculator.domain.dto.CalculationPayload;
import se.sysdev.calculator.domain.dto.CalculationResponse;
import se.sysdev.calculator.domain.CalculatorService;

@RestController
@RequestMapping("/v1")
public class V1Controller {

  @Autowired
  private CalculatorService service;

  @GetMapping("/calculation")
  public CalculationResponse calculate(
          @RequestParam String operation,
          @RequestParam String oa,
          @RequestParam String ob
  ){
    long[] operands = {Long.parseLong(oa), Long.parseLong(ob)};
    CalculationPayload payload = new CalculationPayload(operation, operands);
    long result = this.service.calculate(payload);
    return new CalculationResponse(result);
  }
}

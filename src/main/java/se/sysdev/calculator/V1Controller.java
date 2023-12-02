package se.sysdev.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class V1Controller {

  @GetMapping("/calculation")
  public CalculationResult calculate(
          @RequestParam String operation,
          @RequestParam String oa,
          @RequestParam String ob
  ){
    Long operandA = Long.parseLong(oa);
    Long operandB = Long.parseLong(ob);
    switch (operation) {
      case "addition":
        return new CalculationResult(operandA + operandB);
      case "multiplication":
        return new CalculationResult(operandA * operandB);
    }
    return new CalculationResult(10);
  }

}

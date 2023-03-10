package se.sysdev;

import se.sysdev.webserver.CalculatorHandler;
import se.sysdev.webserver.CalculatorServer;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    CalculationFactory calculationFactory = new DefaultCalculationFactory();
    CalculatorService calculatorService = new DefaultCalculatorService(calculationFactory);
    CalculatorHandler calculatorHandler = new CalculatorHandler(calculatorService);
    CalculatorServer server = new CalculatorServer(calculatorHandler, 8080);
    server.start();
  }
}
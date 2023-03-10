package se.sysdev.webserver;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import se.sysdev.CalculatorService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class CalculatorHandler implements HttpHandler {
  private CalculatorService calculatorService;

  public CalculatorHandler(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
    String operation = params.get("operation");
    Integer o1 = Integer.valueOf(params.get("oa"));
    Integer o2 = Integer.valueOf(params.get("ob"));
    Integer[] aa = {o1, o2};
    System.out.printf("Incoming %s request, params: %s + %s%n", operation, o1, o2);
    long result = this.calculatorService.calculate(operation, aa);
    String response = "Result is: " + result;
    System.out.println(response);
    Headers h = exchange.getRequestHeaders();
    exchange.sendResponseHeaders(200, response.getBytes().length);
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }

  private Map<String, String> queryToMap(String query) {
    Map<String, String> result = new HashMap<>();
    for (String param : query.split("&")) {
      String pair[] = param.split("=");
      if (pair.length > 1) {
        result.put(pair[0], pair[1]);
      } else {
        result.put(pair[0], "");
      }
    }
    return result;
  }
}

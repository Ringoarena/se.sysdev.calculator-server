package se.sysdev.webserver;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class CalculatorServer {
  private final HttpServer httpServer;
  private final HttpHandler handler;
  private final int port;

  public CalculatorServer(HttpHandler handler, int port) throws IOException {
    this.handler = handler;
    this.port = port;
    this.httpServer = HttpServer.create(new InetSocketAddress(this.port), 1);
    this.httpServer.createContext("/v1/calculation", this.handler);
    this.httpServer.setExecutor(null);
  }

  public void start() {
    this.httpServer.start();
    System.out.println("Server listening on port: " + port);
  }
}

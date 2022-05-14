package org.wyk.tfrequency.web;

import com.sun.net.httpserver.HttpExchange;
import org.wyk.tfrequency.model.Analyzer;

import java.io.IOException;

public abstract class AbstractHandler {

    private Analyzer analyzer = new Analyzer();

    public void handle(HttpExchange exchange) throws IOException {
        if("GET".equals(exchange.getRequestMethod())){
            try {
                handleGet(exchange);
            }catch(Throwable e){
                String out = "Server error: '" + e.getMessage() + "'";
                exchange.sendResponseHeaders(500, out.length());
                exchange.getResponseBody().write(out.getBytes());
                exchange.getResponseBody().flush();
                exchange.getResponseBody().close();
            }
        }else {
            String out = "Path with Method not found";
            exchange.sendResponseHeaders(404, out.length());
            exchange.getResponseBody().write(out.getBytes());
            exchange.getResponseBody().flush();
            exchange.getResponseBody().close();
        }
    }

    protected Analyzer getAnalyzer(){
        return analyzer;
    }

    public abstract void handleGet(HttpExchange exchange) throws IOException;
}

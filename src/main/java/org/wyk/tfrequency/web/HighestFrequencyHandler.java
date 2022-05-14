package org.wyk.tfrequency.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.wyk.tfrequency.model.Analyzer;

import java.io.IOException;

public class HighestFrequencyHandler extends  AbstractHandler implements HttpHandler {



    @Override
    public void handle(HttpExchange exchange) throws IOException {
        super.handle(exchange);
    }

    @Override
    public void handleGet(HttpExchange exchange) throws IOException {

        String params = exchange
                .getRequestURI()
                .toString()
                .split("\\?")[1];

        String val = params.split("\\=")[1];

        int r = getAnalyzer().calculateHighestFrequency(val);
        String res = String.valueOf(r);
        exchange.sendResponseHeaders(200, res.length() );
        exchange.getResponseBody().write(res.getBytes());
        exchange.getResponseBody().flush();
        exchange.getResponseBody().close();

    }
}

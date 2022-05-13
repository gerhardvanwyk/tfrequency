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
    public void handleGet(HttpExchange exchange) {

    }
}

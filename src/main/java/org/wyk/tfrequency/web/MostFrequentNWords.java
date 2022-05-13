package org.wyk.tfrequency.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class MostFrequentNWords extends AbstractHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        super.handle(exchange);
    }

    @Override
    public void handleGet(HttpExchange exchange) {

    }
}

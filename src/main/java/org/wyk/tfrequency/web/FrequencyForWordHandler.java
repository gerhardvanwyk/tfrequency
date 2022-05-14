package org.wyk.tfrequency.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class FrequencyForWordHandler extends AbstractHandler implements HttpHandler {

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

        //word=the;text=the brown fox
        String[] vals = params.split("\\;");
        String word = vals[0].split("\\=")[1];
        String text = vals[0].split("\\=")[1];

        int r = getAnalyzer().calculateFrequencyForWord(word, text);
        String res = String.valueOf(r);
        exchange.sendResponseHeaders(200, res.length() );
        exchange.getResponseBody().write(res.getBytes());
        exchange.getResponseBody().flush();
        exchange.getResponseBody().close();
    }
}

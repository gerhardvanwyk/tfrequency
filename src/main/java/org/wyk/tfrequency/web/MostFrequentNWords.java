package org.wyk.tfrequency.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.wyk.tfrequency.model.WordFrequency;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;

public class MostFrequentNWords extends AbstractHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        super.handle(exchange);
    }

    @Override
    public void handleGet(HttpExchange exchange) throws IOException {

        String uri = exchange
                .getRequestURI()
                .toString();
        String[] params = uri.split("\\?");

        //word=the&text=the brown fox
        String[] vals = URLDecoder.decode(params[1], Charset.defaultCharset()).split("\\&");
        String nw = vals[0].split("\\=")[1];
        String text = vals[1].split("\\=")[1];
        int n = Integer.valueOf(nw);

        List<WordFrequency> r = getAnalyzer().calculateMostFrequentNWords( text, n);
        String res = String.valueOf(r);
        exchange.sendResponseHeaders(200, res.length() );
        exchange.getResponseBody().write(res.getBytes());
        exchange.getResponseBody().flush();
        exchange.getResponseBody().close();
    }
}

package org.wyk.tfrequency;

import com.sun.net.httpserver.HttpServer;
import org.wyk.tfrequency.web.FrequencyForWordHandler;
import org.wyk.tfrequency.web.HighestFrequencyHandler;
import org.wyk.tfrequency.web.MostFrequentNWords;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Application {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/hf", new HighestFrequencyHandler());
        server.createContext("/ffw", new FrequencyForWordHandler());
        server.createContext("/mfnw", new MostFrequentNWords());

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        server.setExecutor(executor);
        server.start();
    }
}

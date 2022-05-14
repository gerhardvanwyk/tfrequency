package org.wyk.tfrequency.model;

import java.util.List;
import java.util.StringTokenizer;

public class Analyzer implements WordFrequencyAnalyzer{

    private WordFrequencyCollector collector;

    @Override
    public int calculateHighestFrequency(String text) {
        parse(text);
        List<WordFrequency> res = collector.getHighestFrequency();
        if(res.isEmpty()) {
            return 0;
        } else {
            return res.get(0).getFrequency();
        }
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        parse(text);
        WordFrequency wd = collector.getWord(word);
        return wd.getFrequency();
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        parse(text);
        return collector.getHighestN(n);
    }

    private void parse(String text){
        collector = new WordFrequencyCollector();
        StringTokenizer st = new StringTokenizer(text);
        while (st.hasMoreTokens()) {
            String ws = st.nextToken();
            ws = ws.replaceAll("[^A-Za-z0-9]", "");
            collector.addWord(ws);
        }
    }
}

package org.wyk.tfrequency;

import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Analyzer implements WordFrequencyAnalyzer{


    private static final Logger logger = Logger.getLogger(Analyzer.class.getName());

    private WordFrequencyCollector collector = new WordFrequencyCollector();

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
        StringTokenizer st = new StringTokenizer(text);
        while (st.hasMoreTokens()) {
            collector.addWord(st.nextToken());
        }
    }
}

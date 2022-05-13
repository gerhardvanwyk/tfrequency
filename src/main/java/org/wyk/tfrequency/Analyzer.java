package org.wyk.tfrequency;

import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class Analyzer implements WordFrequencyAnalyzer{


    private static final Logger logger = Logger.getLogger(Analyzer.class.getName());

    @Override
    public int calculateHighestFrequency(String text) {

        return 0;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        return 0;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        return null;
    }

    private void parse(String text){
        StringTokenizer st = new StringTokenizer(text);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

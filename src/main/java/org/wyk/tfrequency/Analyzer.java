package org.wyk.tfrequency;

import java.util.List;
import java.util.StringTokenizer;

public class Analyzer implements WordFrequencyAnalyzer{


    private static final Logger logger = LoggerFactory

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

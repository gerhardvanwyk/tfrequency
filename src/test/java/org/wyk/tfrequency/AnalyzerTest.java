package org.wyk.tfrequency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wyk.tfrequency.model.Analyzer;
import org.wyk.tfrequency.model.WordFrequency;

import java.util.List;

public class AnalyzerTest {

    @Test
    public void highest_frequency(){
        Analyzer analyzer = new Analyzer();
        int res = analyzer.calculateHighestFrequency("The brown fox, jump, over the moon that " +
                "jump, jump and jumps on brown dusky eves.");
        Assertions.assertEquals(3, res);
    }
    @Test
    public void calculate_freq_for_word(){
        Analyzer analyzer = new Analyzer();
        int res = analyzer.calculateFrequencyForWord("The brown fox, jump, over the moon that " +
                "jump, jump and jumps on brown dusky eves.", "the");
        Assertions.assertEquals(2, res);
    }

    @Test
    public void calculate_freq_for_n_word(){
        Analyzer analyzer = new Analyzer();
        List<WordFrequency> res = analyzer.calculateMostFrequentNWords("The brown fox, jump, over the moon that " +
                "jump, jump and jumps on brown dusky eves.", 3);
        Assertions.assertEquals(3, res.size());
        Assertions.assertEquals(3, res.get(0).getFrequency());
        Assertions.assertEquals("jump", res.get(0).getWord());
        Assertions.assertEquals(2, res.get(1).getFrequency());
        Assertions.assertEquals("brown", res.get(1).getWord());
        Assertions.assertEquals(2, res.get(2).getFrequency());
        Assertions.assertEquals("the", res.get(2).getWord());
    }


}

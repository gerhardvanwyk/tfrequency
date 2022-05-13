package org.wyk.tfrequency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordFrequencyCollectorTest {

    @Test
    public void add_a_word(){
        WordFrequencyCollector collector = new WordFrequencyCollector();
        collector.addWord("void");
        WordFrequency fq = collector.getWord("void");
        Assertions.assertEquals(1, fq.getFrequency());
    }

    @Test
    public void add_existing_word(){
        WordFrequencyCollector collector = new WordFrequencyCollector();
        collector.addWord("void");
        collector.addWord("void");
        WordFrequency fq = collector.getWord("void");
        Assertions.assertEquals(2, fq.getFrequency());
    }

    @Test
    public void increment_new_word(){
        WordFrequencyCollector collector = new WordFrequencyCollector();
        collector.increment("void");
        WordFrequency fq = collector.getWord("void");
        Assertions.assertEquals(1, fq.getFrequency());

    }

    @Test
    public void increment_old_word(){
        WordFrequencyCollector collector = new WordFrequencyCollector();
        collector.addWord("void");
        collector.increment("void");
        WordFrequency fq = collector.getWord("void");
        Assertions.assertEquals(2, fq.getFrequency());

    }

    @Test
    public void get_highest_word(){
        WordFrequencyCollector collector = new WordFrequencyCollector();
        collector.addWord("void");
        collector.increment("void"); collector.increment("void");
        collector.addWord("int");
        collector.addWord("long"); collector.increment("long");
        List<WordFrequency> high = collector.getHighestFrequency();
        Assertions.assertEquals(1, high.size());
        Assertions.assertEquals(3, high.get(0).getFrequency());
        Assertions.assertEquals("void", high.get(0).getWord());

    }
    @Test
    public void get_highest_words(){
        WordFrequencyCollector collector = new WordFrequencyCollector();
        collector.addWord("void");
        collector.increment("void"); collector.increment("void");
        collector.addWord("int");
        collector.addWord("long"); collector.increment("long");
        collector.increment("long");
        List<WordFrequency> high = collector.getHighestFrequency();
        Assertions.assertEquals(2, high.size());
        Assertions.assertEquals(3, high.get(0).getFrequency());
        Assertions.assertEquals("void", high.get(0).getWord());
        Assertions.assertEquals(3, high.get(1).getFrequency());
        Assertions.assertEquals("long", high.get(1).getWord());

    }


}

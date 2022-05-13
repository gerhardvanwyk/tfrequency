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

    @Test
    public void get_N_highest_words(){
        WordFrequencyCollector collector = new WordFrequencyCollector();

        addWordNTimes(3, "void", collector);
        addWordNTimes(3, "float", collector);
        addWordNTimes(1, "int", collector);
        addWordNTimes(2, "long", collector);
        addWordNTimes(4, "double", collector);

        List<WordFrequency> high = collector.getHighestN(2);
        Assertions.assertEquals(3, high.size());
        Assertions.assertEquals(4, high.get(0).getFrequency());
        Assertions.assertEquals("double", high.get(0).getWord());
        Assertions.assertEquals(3, high.get(1).getFrequency());
        Assertions.assertEquals("float", high.get(1).getWord());
        Assertions.assertEquals(3, high.get(2).getFrequency());
        Assertions.assertEquals("void", high.get(2).getWord());
    }

    @Test
    public void get_N_highest_words_sen(){
        WordFrequencyCollector collector = new WordFrequencyCollector();

        addWordNTimes(4, "jump", collector);
        addWordNTimes(2, "the", collector);
        addWordNTimes(2, "brown", collector);
        addWordNTimes(1, "fox", collector);
        addWordNTimes(1, "over", collector);
        addWordNTimes(1, "moon", collector);
        addWordNTimes(1, "that", collector);
        addWordNTimes(1, "jumps", collector);
        addWordNTimes(1, "on", collector);
        addWordNTimes(1, "dusky", collector);
        addWordNTimes(1, "eves", collector);

        List<WordFrequency> high = collector.getHighestN(3);
        Assertions.assertEquals(3, high.size());
        Assertions.assertEquals(4, high.get(0).getFrequency());
        Assertions.assertEquals("jump", high.get(0).getWord());
        Assertions.assertEquals(2, high.get(1).getFrequency());
        Assertions.assertEquals("the", high.get(1).getWord());
        Assertions.assertEquals(2, high.get(2).getFrequency());
        Assertions.assertEquals("brown", high.get(2).getWord());
    }

    private void addWordNTimes(int  n, String w, WordFrequencyCollector c){
        c.addWord(w);
        for(int i = 1; i < n; i++){
            c.increment(w);
        }
    }


}

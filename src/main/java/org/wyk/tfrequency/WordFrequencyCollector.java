package org.wyk.tfrequency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class WordFrequencyCollector {


    private static final Logger logger = Logger.getLogger(WordFrequencyCollector.class.getName());


    private List<WordFrequency> words = new ArrayList<>();

    /**
     * Adds a word to this collections
     * @param word
     */
    public void addWord(String word){
        BasicWordFrequency wf = new BasicWordFrequency(word, 1);

        if(words.contains(wf)){
            int i = words.indexOf(wf);
            wf = (BasicWordFrequency) words;
            wf

        }else{
            words.add(wf)
        }

        if(words.add(wf)){
            logger.finest("Add new word");
        }else{
            words.
        }

    }

    /**
     * Increment the frequency of a word.
     * Will add word if not found.
     * @param word
     */
    public void increment(String word){

    }

    /**
     * Returns the <word, frequency>
     * @param word
     * @return
     */
    public WordFrequency getWord(String word){

    }

    public List<WordFrequency> getHighestFrequency(){

    }

    public List<WordFrequency> getHighestN(Long n){

    }
}

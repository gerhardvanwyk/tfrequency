package org.wyk.tfrequency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordFrequencyCollector {


    private static final Logger logger = Logger.getLogger(WordFrequencyCollector.class.getName());


    private List<WordFrequency> words = new ArrayList<>();

    /**
     * Adds a word to this collections
     * @param word
     */
    public void addWord(String word){
        if(getWord(word) != null){
            increment(word);
        }else{
            BasicWordFrequency wf = new BasicWordFrequency(word, 1);
            words.add(wf);
        }

    }

    /**
     * Increment the frequency of a word.
     * Will add word if not found.
     * @param word
     */
    public void increment(String word){
        if(getWord(word) == null) {
            addWord(word);
        }else {
            BasicWordFrequency wf = new BasicWordFrequency(word, 0);
            int i = words.indexOf(wf);
            wf = (BasicWordFrequency) words.get(i);
            wf.increment();
        }
    }

    /**
     * Returns the <word, frequency>
     * @param word
     * @return the WordFrequency, null if not found
     *
     */
    public WordFrequency getWord(String word){
        BasicWordFrequency wf = new BasicWordFrequency(word, 1);
        if(words.contains(wf)){
            int i = words.indexOf(wf);
            wf = (BasicWordFrequency) words.get(i);
            return wf;
        }else{
            return null;
        }
    }

    public List<WordFrequency> getHighestFrequency(){

        final int[] h = {0};
        words.stream().forEach(new Consumer<WordFrequency>() {
            @Override
            public void accept(WordFrequency wordFrequency) {
                if(wordFrequency.getFrequency() > h[0]){
                    h[0] = wordFrequency.getFrequency();
                }
            }
        });

        List<WordFrequency> highest = words.stream().filter(new Predicate<WordFrequency>() {
            @Override
            public boolean test(WordFrequency wordFrequency) {
                return wordFrequency.getFrequency() == h[0];

            }
        }).collect(Collectors.toList());
        return highest;
    }

    public List<WordFrequency> getHighestN(int n){
        return words.stream()
                .sorted()
                .collect(Collectors.toList())
                .subList( (words.size() - 1) - n, words.size());
    }
}

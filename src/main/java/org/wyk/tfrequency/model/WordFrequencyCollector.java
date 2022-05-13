package org.wyk.tfrequency.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordFrequencyCollector {

    private List<WordFrequency> words = new ArrayList<>();

    /**
     * Adds a word to this collections
     * @param word
     */
    public void addWord(String word){
        if(getWord(word) != null){
            increment(word);
        }else{
            BasicWordFrequency wf = new BasicWordFrequency(word.toLowerCase(), 1);
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
        words.forEach(wordFrequency -> {
            if(wordFrequency.getFrequency() > h[0]){
                h[0] = wordFrequency.getFrequency();
            }
        });

        return words.stream()
                .filter(wordFrequency -> wordFrequency.getFrequency() == h[0]).collect(Collectors.toList());
    }

    public List<WordFrequency> getHighestN(int n){
        int start = (words.size() - 1) - n;
        words =  words.stream()
                .sorted()
                .collect(Collectors.toList());

        List<WordFrequency> st = new ArrayList<>(words.subList( 0, n));

        int lowFreq = st.get(st.size() -1).getFrequency();
        int highFreq = st.get(0).getFrequency();

        for(int i = lowFreq; i <= highFreq; i++) {
            List<WordFrequency> sorted = getSortAlphaNum(start, st, i);
            st.addAll(0, sorted);
        }
        return st;
    }

    private List<WordFrequency> getSortAlphaNum(int start, List<WordFrequency> st, int lowFreq) {

        List<WordFrequency> last = st.stream()
                .filter(wordFrequency -> wordFrequency.getFrequency() == lowFreq)
                .collect(Collectors.toList());

        last.forEach(st::remove);

        for(int i = start; i < words.size(); i++){
            WordFrequency in = words.get(i);
            if(in.getFrequency() == lowFreq){
                if(!last.contains(in))
                    last.add(in);
            }
        }

        List<WordFrequency> sorted = last.stream().sorted((o1, o2) -> {
            String s1 = o1.getWord();
            String s2 = o2.getWord();
            return s1.compareTo(s2);
        }).collect(Collectors.toList());
        return sorted;
    }
}

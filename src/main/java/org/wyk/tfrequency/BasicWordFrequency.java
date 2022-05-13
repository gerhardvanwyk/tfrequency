package org.wyk.tfrequency;

import java.util.Objects;

public class BasicWordFrequency implements WordFrequency, Comparable<Integer>{

    private final String word;
    private Integer freq;

    public BasicWordFrequency(String word, Integer freq) {
        this.word = word;
        this.freq = freq;
    }

    @Override
    public String getWord() {
        return this.word;
    }

    @Override
    public int getFrequency() {
        return this.freq;
    }

    public void increment() {
        this.freq++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicWordFrequency that = (BasicWordFrequency) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public int compareTo(Integer o) {
        return o.compareTo(o);
    }
}

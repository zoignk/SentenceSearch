package org.project44.search.sentence.core;

import java.util.Objects;

public class WordInSentence {
    private String sentence;
    private int count;

    public WordInSentence(String sentence, int count) {
        this.sentence = sentence;
        this.count = count;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordInSentence that = (WordInSentence) o;
        return count == that.count &&
                Objects.equals(sentence, that.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, count);
    }
}

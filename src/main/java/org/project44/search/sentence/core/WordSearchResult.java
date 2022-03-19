package org.project44.search.sentence.core;

import java.util.List;

public class WordSearchResult {
    private String word;
    private List<WordInSentence> sentences;

    public WordSearchResult(String word, List<WordInSentence> sentences) {
        this.word = word;
        this.sentences = sentences;
    }

    public String getWord() {
        return word;
    }

    public List<WordInSentence> getSentences() {
        return sentences;
    }
}

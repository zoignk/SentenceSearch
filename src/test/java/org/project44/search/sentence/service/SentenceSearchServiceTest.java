package org.project44.search.sentence.service;

import org.project44.search.sentence.core.WordInSentence;
import org.project44.search.sentence.core.WordSearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class SentenceSearchServiceTest {

    public static final String SEARCH_WORD = "eggplant";
    public static final String NOT_EXISTING_WORD = "tnalpgge";
    public static final String SOURCE_PATH = "src/test/resources/fixtures/example.txt";

    public static final String SENTENCE = "Repeat is a mother of science so repeat repeat repeat.";

    private SentenceSearchService sentenceSearchService = new SentenceSearchService(SOURCE_PATH);

    @Test
    void searchSentencesForWordContainsWordTest() {
        WordSearchResult result = sentenceSearchService.searchSentencesForWord(SEARCH_WORD);

        Assertions.assertEquals(SEARCH_WORD, result.getWord());
        Assertions.assertEquals(3, result.getSentences().size());
    }

    @Test
    void searchSentencesForWordWithoutResultTest() {
        WordSearchResult result = sentenceSearchService.searchSentencesForWord(NOT_EXISTING_WORD);

        Assertions.assertEquals(NOT_EXISTING_WORD, result.getWord());
        Assertions.assertEquals(Collections.emptyList(), result.getSentences());

    }

    @Test
    void searchSentenceForWordOrderByTest() {
        WordSearchResult result = sentenceSearchService.searchSentencesForWord(SEARCH_WORD);

        WordInSentence firstSentence = new WordInSentence("Absolutely eggplant or not eggplant?", 2);
        WordInSentence secondSentence = new WordInSentence("Eggplant or not eggplant?", 2);
        WordInSentence thirdSentence = new WordInSentence( "Many people don't like eggplant.", 1);

        Assertions.assertEquals(firstSentence, result.getSentences().get(0));
        Assertions.assertEquals(secondSentence, result.getSentences().get(1));
        Assertions.assertEquals(thirdSentence, result.getSentences().get(2));
    }

    @Test
    void countWordInSentenceTest() {
       WordInSentence countWordInSentence = sentenceSearchService.countWordInSentence(SENTENCE, "repeat");

       Assertions.assertEquals(SENTENCE, countWordInSentence.getSentence());
       Assertions.assertEquals(4, countWordInSentence.getCount());
    }
}
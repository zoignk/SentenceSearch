package org.project44.search.sentence.service;

import org.project44.search.sentence.core.WordInSentence;
import org.project44.search.sentence.core.WordSearchResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceSearchService {
    private final String sourcePath;

    public SentenceSearchService(String sourcePath) {
        this.sourcePath = sourcePath;
    }


    /*
    * Core method of service.
    * Looks for all sentences that contain given word.
    * Counts number of occurrences of word in sentence.
    * Sorts sentences by count descending or on sentence text when count equals.
    *
    * TODO: Load file content on application startup to make service faster.
    *
    * */
    public WordSearchResult searchSentencesForWord(String word) {
        try(Stream<String> sentences = Files.lines(Paths.get(sourcePath))) {
            List<WordInSentence> wordInSentences = sentences
                    .filter(sentence -> sentence.toLowerCase().contains(word.toLowerCase()))
                    .map(sentence -> countWordInSentence(sentence, word))
                    .sorted(this.comparator())
                    .collect(Collectors.toList());

            return new WordSearchResult(word, wordInSentences);

        } catch (IOException e) {
            e.printStackTrace();
            return new WordSearchResult(word, Collections.emptyList());
        }
    }

    protected WordInSentence countWordInSentence(String sentence, String word) {
        long count = Stream.of(sentence.toLowerCase().split(" "))
                .filter(w -> w.contains(word.toLowerCase()))
                .count();
        return new WordInSentence(sentence, (int)count);
    }

    public Comparator<WordInSentence> comparator() {
        return (wis1, wis2) ->
                wis1.getCount() == wis2.getCount()
                        ? wis1.getSentence().compareTo(wis2.getSentence())
                        : wis2.getCount() - wis1.getCount()
                ;
    }
}

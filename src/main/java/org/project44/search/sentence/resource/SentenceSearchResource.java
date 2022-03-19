package org.project44.search.sentence.resource;

import org.project44.search.sentence.core.WordSearchResult;
import org.project44.search.sentence.service.SentenceSearchService;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/count")
@Produces(MediaType.APPLICATION_JSON)
public class SentenceSearchResource {
    private final SentenceSearchService sentenceSearchService;

    public SentenceSearchResource(SentenceSearchService sentenceSearchService) {
        this.sentenceSearchService = sentenceSearchService;
    }

    /**
     * Endpoint to find all sentences which contain given word.
     *
     * @param word searched word, required
     * @return ordered list of sentences with count of word occurrences in sentence
     */
    @GET
    public WordSearchResult searchSentencesForWord(@QueryParam("word") @NotEmpty String word) {
        return sentenceSearchService.searchSentencesForWord(word);
    }
}

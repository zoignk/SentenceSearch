package org.project44.search.sentence;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.project44.search.sentence.resource.SentenceSearchResource;
import org.project44.search.sentence.service.SentenceSearchService;

public class SentenceSearchApplication extends Application<SentenceSearchConfiguration> {

    public static void main(String[] args) throws Exception {
        new SentenceSearchApplication().run("server", "config.yml");
    }

    @Override
    public void run(SentenceSearchConfiguration sentenceSearchConfiguration, Environment environment) {
       String sourcePath = sentenceSearchConfiguration.getSourcePath();
       SentenceSearchService sentenceSearchService = new SentenceSearchService(sourcePath);
       SentenceSearchResource sentenceSearchResource = new SentenceSearchResource(sentenceSearchService);

       environment.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

       environment
               .jersey()
               .register(sentenceSearchResource);
    }
}

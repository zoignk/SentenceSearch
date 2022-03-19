package org.project44.search.sentence;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class SentenceSearchConfiguration extends Configuration {
    @NotNull
    private String sourcePath;

    @JsonProperty
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @JsonProperty
    public String getSourcePath() {
        return sourcePath;
    }
}

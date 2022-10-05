package com.swisscom.featuretoggle.model.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FeatureToggleRequest {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @JsonCreator
    public FeatureToggleRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

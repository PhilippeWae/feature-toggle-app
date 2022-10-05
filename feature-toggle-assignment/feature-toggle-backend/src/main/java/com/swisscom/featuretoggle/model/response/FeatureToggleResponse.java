package com.swisscom.featuretoggle.model.response;

import com.swisscom.featuretoggle.model.FeatureToggle;

public class FeatureToggleResponse {
    private String id;
    private String name;

    public FeatureToggleResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public FeatureToggleResponse(FeatureToggle featureToggle) {
        this.id = featureToggle.getId();
        this.name = featureToggle.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.swisscom.featuretoggle.model;

import com.swisscom.featuretoggle.model.request.FeatureToggleRequest;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class FeatureToggle {

    @Id
    @Column(length = 36, nullable = false, unique = true)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    public FeatureToggle(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public  FeatureToggle() {}

    public FeatureToggle(FeatureToggleRequest featureToggleRequest) {
        this.id = UUID.randomUUID().toString();
        this.name = featureToggleRequest.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

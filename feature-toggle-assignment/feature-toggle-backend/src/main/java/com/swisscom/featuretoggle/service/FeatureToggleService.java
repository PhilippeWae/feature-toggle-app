package com.swisscom.featuretoggle.service;

import com.swisscom.featuretoggle.model.FeatureToggle;
import com.swisscom.featuretoggle.model.request.FeatureToggleRequest;
import com.swisscom.featuretoggle.model.response.ExistentResponse;
import com.swisscom.featuretoggle.model.response.FeatureToggleResponse;
import com.swisscom.featuretoggle.repository.FeatureToggleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeatureToggleService {

    private final FeatureToggleRepository featureToggleRepository;

    public FeatureToggleService(FeatureToggleRepository featureToggleRepository) {
        this.featureToggleRepository = featureToggleRepository;
    }

    /**
     * Gets all FeatureToggles.
     *
     * @return all featureToggle entries.
     */
    public List<FeatureToggleResponse> getAll() {
        return featureToggleRepository.findAll().stream().map(FeatureToggleResponse::new).collect(Collectors.toList());
    }

    /**
     * Creates a new FeatureToggle in the database.
     *
     * @param featureToggleRequest request body for the new FeatureToggle entry.
     * @return the newly created lease entry.
     */
    public FeatureToggleResponse create(FeatureToggleRequest featureToggleRequest) {
        FeatureToggle featureToggle = new FeatureToggle(featureToggleRequest);
        featureToggleRepository.save(featureToggle);
        return new FeatureToggleResponse(featureToggle);
    }

    public List<ExistentResponse> getExistentFeatureToggles(List<FeatureToggleRequest> featureToggleRequests) {
        List<ExistentResponse> existentFeatureToggles = new ArrayList<>();
        featureToggleRequests.forEach((ft) -> {
            Optional<FeatureToggle> featureToggle = featureToggleRepository.findFeatureToggleByName(ft.getName());
            if (featureToggle.isPresent()) {
                existentFeatureToggles.add(new ExistentResponse(ft.getName(), true));
            } else {
                existentFeatureToggles.add(new ExistentResponse(ft.getName(), false));
            }
        });
        return existentFeatureToggles;
    }

    /**
     * Deletes a specific FeatureToggle.
     *
     * @param id FeatureToggle id which will be deleted.
     */
    public void delete(String id) {
        featureToggleRepository.delete(findById(id));
    }

    /**
     * Fetches a FeatureToggle from the database by its id.
     *
     * @param id FeatureToggle id.
     * @return the FeatureToggle with the given id.
     * @throws IllegalArgumentException if the given id was not found.
     */
    public FeatureToggle findById(String id) {
        return featureToggleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}

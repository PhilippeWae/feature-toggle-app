package com.swisscom.featuretoggle.api;

import com.swisscom.featuretoggle.model.request.FeatureToggleRequest;
import com.swisscom.featuretoggle.model.response.ExistentResponse;
import com.swisscom.featuretoggle.model.response.FeatureToggleResponse;
import com.swisscom.featuretoggle.service.FeatureToggleService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class FeatureToggleController {

    private final FeatureToggleService featureToggleService;

    public FeatureToggleController(FeatureToggleService featureToggleService) {
        this.featureToggleService = featureToggleService;
    }

    /**
     * Manages GET requests to the /api endpoint.
     *
     * @return all FeatureToggles.
     */
    @GetMapping()
    public List<FeatureToggleResponse> getAll() {
        return featureToggleService.getAll();
    }

    /**
     * Manages POST requests to the /api endpoint.
     *
     * @param featureToggleRequest request body for the new FeatureToggle entry.
     * @return the created lease entry.
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FeatureToggleResponse newFeatureToggle(@Valid @RequestBody FeatureToggleRequest featureToggleRequest) {
        return featureToggleService.create(featureToggleRequest);
    }

    /**
     * Manages POST requests to the /api endpoint.
     *
     * @param featureToggleRequest request body for the new FeatureToggle entry.
     * @return the created lease entry.
     */
    @PostMapping("/existent")
    public List<ExistentResponse> getExistentFeatureToggles(@Valid @RequestBody List<FeatureToggleRequest> featureToggleRequest) {
        return featureToggleService.getExistentFeatureToggles(featureToggleRequest);
    }

    /**
     * Manages DELETE requests to the /api endpoint.
     *
     * @param id id of FeatureToggle.
     */
    @DeleteMapping("/{id}")
    public void deleteFeatureToggle(@PathVariable @NotNull @Size(min = 36, max = 36) String id) {
        featureToggleService.delete(id);
    }
}

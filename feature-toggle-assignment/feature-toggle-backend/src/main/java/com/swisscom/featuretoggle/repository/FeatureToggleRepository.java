package com.swisscom.featuretoggle.repository;

import com.swisscom.featuretoggle.model.FeatureToggle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureToggleRepository extends JpaRepository<FeatureToggle, String> {
    Optional<FeatureToggle> findFeatureToggleByName(String name);
}

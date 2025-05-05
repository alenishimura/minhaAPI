package me.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}

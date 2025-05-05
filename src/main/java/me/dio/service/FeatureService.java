package me.dio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import me.dio.model.Feature;
import me.dio.repository.FeatureRepository;

@Service
public class FeatureService {
    private final FeatureRepository repo;
    public FeatureService(FeatureRepository repo) { this.repo = repo; }

    public List<Feature> findAll() { return repo.findAll(); }
    public Feature findById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Feature not found: " + id)); }
    @Transactional public Feature create(Feature f) { return repo.save(f); }
    @Transactional public Feature update(Long id, Feature f) { f.setId(id); return repo.save(f); }
    @Transactional public void delete(Long id) { repo.deleteById(id); }
}

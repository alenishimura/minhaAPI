package me.dio.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.dio.model.Feature;
import me.dio.service.FeatureService;

@RestController
@RequestMapping("/features")
public class FeatureController {
    private final FeatureService service;
    public FeatureController(FeatureService service) { this.service = service; }

    @GetMapping public List<Feature> all() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Feature> one(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }
    @PostMapping public ResponseEntity<Feature> create(@RequestBody Feature f) { return ResponseEntity.ok(service.create(f)); }
    @PutMapping("/{id}") public ResponseEntity<Feature> update(@PathVariable Long id, @RequestBody Feature f) { return ResponseEntity.ok(service.update(id, f)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}

package me.dio.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.dio.model.News;
import me.dio.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService service;
    public NewsController(NewsService service) { this.service = service; }

    @GetMapping public List<News> all() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<News> one(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }
    @PostMapping public ResponseEntity<News> create(@RequestBody News n) { return ResponseEntity.ok(service.create(n)); }
    @PutMapping("/{id}") public ResponseEntity<News> update(@PathVariable Long id, @RequestBody News n) { return ResponseEntity.ok(service.update(id, n)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}

package me.dio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import me.dio.model.News;
import me.dio.repository.NewsRepository;

@Service
public class NewsService {
    private final NewsRepository repo;
    public NewsService(NewsRepository repo) { this.repo = repo; }

    public List<News> findAll() { return repo.findAll(); }
    public News findById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("News not found: " + id)); }
    @Transactional public News create(News n) { return repo.save(n); }
    @Transactional public News update(Long id, News n) { n.setId(id); return repo.save(n); }
    @Transactional public void delete(Long id) { repo.deleteById(id); }
}

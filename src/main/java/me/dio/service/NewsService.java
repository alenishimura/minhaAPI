package me.dio.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import me.dio.model.News;
import me.dio.repository.NewsRepository;

@Service
public class NewsService {
    private final NewsRepository repo;
    public NewsService(NewsRepository repo) {
        this.repo = repo;
    }

    public List<News> findAll() {
        return repo.findAll();
    }

    public News findById(Long id) {
        return repo.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "News não encontrado com id = " + id
                )
            );
    }

    @Transactional
    public News create(News news) {
        return repo.save(news);
    }

    @Transactional
    public News update(Long id, News news) {
        News existing = findById(id);
        existing.setDescription(news.getDescription());
        existing.setIcon(news.getIcon());
        // …mais campos se precisar
        return repo.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        // se não existir, o findById já lança 404
        findById(id);
        repo.deleteById(id);
    }
}

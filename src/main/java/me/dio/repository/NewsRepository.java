package me.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}

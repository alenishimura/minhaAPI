package me.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}

package me.dio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import me.dio.model.Card;
import me.dio.repository.CardRepository;

@Service
public class CardService {
    private final CardRepository repo;
    public CardService(CardRepository repo) { this.repo = repo; }

    public List<Card> findAll() { return repo.findAll(); }
    public Card findById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Card not found: " + id)); }
    @Transactional public Card create(Card c) { return repo.save(c); }
    @Transactional public Card update(Long id, Card c) { c.setId(id); return repo.save(c); }
    @Transactional public void delete(Long id) { repo.deleteById(id); }
}

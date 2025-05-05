package me.dio.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.dio.model.Card;
import me.dio.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService service;
    public CardController(CardService service) { this.service = service; }

    @GetMapping public List<Card> all() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Card> one(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }
    @PostMapping public ResponseEntity<Card> create(@RequestBody Card c) { return ResponseEntity.ok(service.create(c)); }
    @PutMapping("/{id}") public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card c) { return ResponseEntity.ok(service.update(id, c)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}

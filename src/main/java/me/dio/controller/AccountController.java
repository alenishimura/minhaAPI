package me.dio.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.dio.model.Account;
import me.dio.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService service;
    public AccountController(AccountService service) { this.service = service; }

    @GetMapping public List<Account> all() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<Account> one(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }
    @PostMapping public ResponseEntity<Account> create(@RequestBody Account a) { return ResponseEntity.ok(service.create(a)); }
    @PutMapping("/{id}") public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account a) { return ResponseEntity.ok(service.update(id, a)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}

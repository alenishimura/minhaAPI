package me.dio.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.dio.model.User;
import me.dio.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @GetMapping public List<User> all() { return service.findAll(); }
    @GetMapping("/{id}") public ResponseEntity<User> one(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }
    @PostMapping public ResponseEntity<User> create(@RequestBody User u) { return ResponseEntity.ok(service.create(u)); }
    @PutMapping("/{id}") public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u) { return ResponseEntity.ok(service.update(id, u)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}

package me.dio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import me.dio.model.User;
import me.dio.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }

    public List<User> findAll() { return repo.findAll(); }
    public User findById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id)); }
    @Transactional public User create(User u) { return repo.save(u); }
    @Transactional public User update(Long id, User u) { u.setId(id); return repo.save(u); }
    @Transactional public void delete(Long id) { repo.deleteById(id); }
}

package me.dio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import me.dio.model.Account;
import me.dio.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository repo;
    public AccountService(AccountRepository repo) { this.repo = repo; }

    public List<Account> findAll() { return repo.findAll(); }
    public Account findById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Account not found: " + id)); }
    @Transactional public Account create(Account a) { return repo.save(a); }
    @Transactional public Account update(Long id, Account a) { a.setId(id); return repo.save(a); }
    @Transactional public void delete(Long id) { repo.deleteById(id); }
}

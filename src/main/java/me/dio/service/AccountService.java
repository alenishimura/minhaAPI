package me.dio.service;

import me.dio.model.Account;
import me.dio.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public List<Account> listAll() {
        return repo.findAll();
    }

    public Account getByAccountNumber(String accountNumber) {
        return repo.findById(accountNumber)
                   .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account create(Account account) {
        return repo.save(account);
    }

    public Account update(String accountNumber, Account updated) {
        Account existing = getByAccountNumber(accountNumber);

        existing.setName(updated.getName());
        existing.setAccountAgency(updated.getAccountAgency());
        existing.setAccountBalance(updated.getAccountBalance());
        existing.setAccountLimit(updated.getAccountLimit());
        existing.setPixIcon(updated.getPixIcon());
        existing.setPixDescription(updated.getPixDescription());
        existing.setPayIcon(updated.getPayIcon());
        existing.setPayDescription(updated.getPayDescription());
        existing.setTransferIcon(updated.getTransferIcon());
        existing.setTransferDescription(updated.getTransferDescription());
        existing.setCardNumber(updated.getCardNumber());
        existing.setCardLimit(updated.getCardLimit());
        existing.setNewsIcon(updated.getNewsIcon());
        existing.setNewsDescription(updated.getNewsDescription());

        return repo.save(existing);
    }

    public void delete(String accountNumber) {
        repo.deleteById(accountNumber);
    }
}

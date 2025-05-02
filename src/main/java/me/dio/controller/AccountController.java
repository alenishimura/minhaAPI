package me.dio.controller;

import me.dio.model.Account;
import me.dio.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<Account> list() {
        return service.listAll();
    }

    @GetMapping("/{accountNumber}")
    public Account get(@PathVariable String accountNumber) {
        return service.getByAccountNumber(accountNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        return service.create(account);
    }

    @PutMapping("/{accountNumber}")
    public Account update(@PathVariable String accountNumber,
                          @RequestBody Account account) {
        return service.update(accountNumber, account);
    }

    @DeleteMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String accountNumber) {
        service.delete(accountNumber);
    }
}

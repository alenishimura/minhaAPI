package me.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

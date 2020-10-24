package ru.sbrf.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.server.entity.Account;
import ru.sbrf.server.repository.AccountCrudRepository;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountCrudRepository accountCrudRepository;

    public Account getAccount(Long id) {
        return accountCrudRepository.findById(id).orElse(null);
    }

    public Account getAccount(String numberAccount) {
        Account account = accountCrudRepository.findByNumber(numberAccount);
        return (account == null)?(new Account()):account;
    }

    public Account putAccount(Account account) {
        return accountCrudRepository.save(account);
    }

}

////
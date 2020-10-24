package ru.sbrf.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.server.entity.Account;

@Repository
public interface AccountCrudRepository extends CrudRepository<Account, Long> {
    Account findByNumber(String number);
}

////
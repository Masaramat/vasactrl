package com.vasactrl.repositories;

import com.vasactrl.models.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {
}

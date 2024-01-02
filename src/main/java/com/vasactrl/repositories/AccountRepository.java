package com.vasactrl.repositories;

import com.vasactrl.models.Account;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveSortingRepository<Account, Long> {
}

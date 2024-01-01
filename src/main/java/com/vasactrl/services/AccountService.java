package com.vasactrl.services;

import com.vasactrl.models.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    public Mono<Account> save(Account account);

    public Flux<Account> all();

    public Mono<Account> findById(Long id);

    public Mono<Account> update(Account account, Long id);
}

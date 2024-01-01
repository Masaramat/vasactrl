package com.vasactrl.services;

import com.vasactrl.models.Account;
import com.vasactrl.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.security.auth.login.AccountNotFoundException;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository repository;
    @Override
    public Mono<Account> save(Account account) {
        return repository.save(account);
    }

    @Override
    public Flux<Account> all() {
        return repository.findAll();
    }

    @Override
    public Mono<Account> findById(Long id) {
        return repository.findById(id).switchIfEmpty(Mono.error(new AccountNotFoundException("Account not found")));
    }

    @Override
    public Mono<Account> update(Account account, Long id) {
        return repository.findById(id).switchIfEmpty(
            Mono.error(new AccountNotFoundException("Account not found"))).flatMap(
                updateAccount->{
                    updateAccount.setGl(account.getGl());
                    updateAccount.setName(account.getName());

                    return repository.save(updateAccount);

                });

    }
}

package com.vasactrl.controllers;

import com.vasactrl.models.Account;
import com.vasactrl.services.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping()
    public Mono<Account> save(@Valid @RequestBody Account account){
        return service.save(account);
    }

    @GetMapping()
    public Flux<Account> all(){
        return service.all();
    }

    @GetMapping("/{id}")
    public Mono<Account> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Account> update(@PathVariable Long id, @RequestBody @Valid Account account){
        return service.update(account, id);
    }

}

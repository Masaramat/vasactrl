package com.vasactrl.services;

import com.vasactrl.models.Branch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchService {
    public Flux<Branch> getAll();

    public Mono<Branch> findById(Long id);

    public Mono<Branch> save(Branch branch);

    public Mono<Branch> update(Branch branch, Long id);
}

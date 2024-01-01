package com.vasactrl.services;

import com.vasactrl.exceptions.handlers.BranchNotFoundException;
import com.vasactrl.models.Branch;
import com.vasactrl.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
@Transactional
public class BranchServiceImpl implements BranchService{

    private final BranchRepository repository;
    @Override
    public Flux<Branch> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Branch> findById(Long id) {
        return repository.findById(id).switchIfEmpty(
                Mono.error(new BranchNotFoundException("Branch not found"))
        );
    }

    @Override
    public Mono<Branch> save(Branch branch) {
        return repository.save(branch);
    }

    @Override
    public Mono<Branch> update(Branch branch, Long id) {
        return repository.findById(id).switchIfEmpty(
                Mono.error(new BranchNotFoundException("Branch not found"))).flatMap(
                        foundBranch-> {
                            foundBranch.setName(branch.getName());
                            foundBranch.setLocation(branch.getLocation());

                            return repository.save(foundBranch);

                        });
    }
}

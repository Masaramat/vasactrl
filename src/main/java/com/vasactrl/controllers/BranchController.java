package com.vasactrl.controllers;

import com.vasactrl.models.Branch;
import com.vasactrl.services.BranchService;
import com.vasactrl.services.BranchServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/api/v1/admin/branch")
@AllArgsConstructor
public class BranchController {
    private final BranchService service;

    @PostMapping()
    public Mono<Branch> save(@RequestBody @Valid Branch branch){
        return service.save(branch);
    }

    @GetMapping()
    public Flux<Branch> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Branch> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Branch> update(@PathVariable Long id, @RequestBody @Valid Branch branch){
        return service.update(branch, id);
    }
}

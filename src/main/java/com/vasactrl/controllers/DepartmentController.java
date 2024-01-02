package com.vasactrl.controllers;

import com.vasactrl.models.Department;
import com.vasactrl.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.*;

@RestController
@RequestMapping("/api/v1/admin/department")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService service;
    @PostMapping()
    public Mono<Department> save(@RequestBody @Valid Department department){
        return service.create(department);
    }

    @GetMapping()
    public Flux<Department> all(){
        return service.all();
    }

    @GetMapping("/{id}")
    public Mono<Department> get(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Mono<Department> edit(@RequestBody @Valid Department department, @PathVariable Long id){
        return service.update(department, id);

    }
}

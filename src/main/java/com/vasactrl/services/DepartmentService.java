package com.vasactrl.services;

import com.vasactrl.dtos.DepartmentDTO;
import com.vasactrl.models.Department;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepartmentService {
    public Mono<Department> create(Department department);

    public Flux<Department> all();

    public Mono<Department> get(Long id);

    public Mono<Department> update(Department department, Long id);
}

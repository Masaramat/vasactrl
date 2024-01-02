package com.vasactrl.services;

import com.vasactrl.exceptions.handlers.DepartmentNotFoundException;
import com.vasactrl.models.Department;
import com.vasactrl.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Transactional
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository repository;
    @Override
    public Mono<Department> create(Department department) {
        return repository.save(department);
    }

    @Override
    public Flux<Department> all() {
        return repository.findAll().switchIfEmpty(
                Mono.error(new DepartmentNotFoundException("Department not found"))
        );
    }

    @Override
    public Mono<Department> get(Long id) {
        return repository.findById(id).switchIfEmpty(
                Mono.error(new DepartmentNotFoundException("Department not found with ID " + id))
        );
    }

    @Override
    public Mono<Department> update(Department department, Long id) {
        return repository.findById(id).switchIfEmpty(
                Mono.error(new DepartmentNotFoundException("Department not found"))).flatMap(
                        foundDept->{
                            foundDept.setName(department.getName());
                            return repository.save(foundDept);
                        });
    }
}

package com.vasactrl.repositories;

import com.vasactrl.models.Department;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ReactiveSortingRepository<Department, Long> {
}

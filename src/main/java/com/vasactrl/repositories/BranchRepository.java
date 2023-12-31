package com.vasactrl.repositories;

import com.vasactrl.models.Branch;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends ReactiveSortingRepository<Branch, Long> {
}

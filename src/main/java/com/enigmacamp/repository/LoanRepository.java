package com.enigmacamp.repository;

import com.enigmacamp.entity.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanTransaction, String> {
}

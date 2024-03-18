package com.enigmacamp.repository;

import com.enigmacamp.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("""
            SELECT
                c
            FROM
                Customer c
            WHERE
                c.deletedAt is null  \s
            """)
    Page<Customer> getAllVisibleData(Pageable page);
    @Query("""
            SELECT
                c
            FROM
                Customer c
            WHERE
                c.deletedAt is not null  \s
            """)
    Page<Customer> getAllDeletedData(Pageable page);
    @Query("""
            SELECT
                c
            FROM
                Customer c
            WHERE
                c.deletedAt BETWEEN :start AND :end
            """)
    Page<Customer> getDeletedDataByDate(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end,
            Pageable page
    );
}

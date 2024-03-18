package com.enigmacamp.repository;

import com.enigmacamp.entity.InstalmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentTypeRepository extends JpaRepository<InstalmentType, String> {
}

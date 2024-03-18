package com.enigmacamp.entity;

import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

public class LoanType {
    @Id
    @UuidGenerator
    private String id;
    private String type;
    private Double maxLoan;
}
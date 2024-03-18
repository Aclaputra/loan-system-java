package com.enigmacamp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_loan_type")
public class LoanType {
    @Id
    @UuidGenerator
    private String id;
    private String type;
    private Double maxLoan;
}
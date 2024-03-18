package com.enigmacamp.entity;

import com.enigmacamp.constant.LoanStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trx_loan_detail")
public class LoanTransactionDetail {
    @Id
    @UuidGenerator
    private String id;
    private Long transactionDate;
    private Double nominal;

    @OneToOne
    private LoanTransaction loanTransaction;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus; // enum

    private Long createdAt;
    private Long updatedAt;
}


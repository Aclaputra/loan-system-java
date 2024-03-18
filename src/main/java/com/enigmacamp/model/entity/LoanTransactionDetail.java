package com.enigmacamp.model.entity;

import com.enigmacamp.constant.LoanStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_transaction_detail_id")
    private String id;
    private Long transactionDate;
    private Double nominal;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "loan_transaction_id")
    private LoanTransaction loanTransaction;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus; // enum

    private Long createdAt;
    private Long updatedAt;
}


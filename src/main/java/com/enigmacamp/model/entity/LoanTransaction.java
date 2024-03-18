package com.enigmacamp.model.entity;

import com.enigmacamp.constant.ApprovalStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trx_loan")
public class LoanTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_transaction_id")
    private String id;

    @OneToOne
    private LoanType loanType;
    @OneToOne
    private InstalmentType instalmentType;
    @ManyToOne
    private Customer customer;

    private Double nominal;
    private Long approvedAt;
    private String approvedBy;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus; // enum

    @OneToMany(mappedBy = "loanTransaction")
    private List<LoanTransactionDetail> loanTransactionDetails = new ArrayList<>();

    private Long createdAt;
    private Long updatedAt;
}


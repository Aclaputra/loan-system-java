package com.enigmacamp.entity;

import com.enigmacamp.constant.ApprovalStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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
    @UuidGenerator
    private String id;

//    private LoanType loanType;
//    private InstalmentType instalmentType;
//    private Customer customer;

    private Double nominal;
    private Long approvedAt;
    private String approvedBy;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus; // enum

//    private List<LoanTransactionDetail> loanTransactionDetails;

    private Long createdAt;
    private Long updatedAt;
}


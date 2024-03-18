package com.enigmacamp.model.dto.response.loan.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TransactionResponse {
    private String id;
    private String loanTypeId;
    private String installmentTypeId;
    private String customerId;
    private double nominal;
    private String approvedAt;
    private String approvedBy;
    private String approvalStatus;
    private List<TransactionDetailResponse> transactionDetailResponses;
    private long createdAt;
    private long updatedAt;
}

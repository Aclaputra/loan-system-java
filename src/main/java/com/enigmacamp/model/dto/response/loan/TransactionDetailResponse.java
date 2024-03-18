package com.enigmacamp.model.dto.response.loan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionDetailResponse {
    private String id;
    private long transactionDate;
    private double nominal;
    private String loanStatus;
    private long createdAt;
    private long updatedAt;
}

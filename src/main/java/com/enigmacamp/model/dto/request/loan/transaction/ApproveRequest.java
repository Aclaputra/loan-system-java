package com.enigmacamp.model.dto.request.loan.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApproveRequest {
    private String loanTransactionId;
    private int interestRates;
}

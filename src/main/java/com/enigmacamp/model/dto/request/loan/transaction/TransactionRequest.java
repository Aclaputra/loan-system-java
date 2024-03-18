package com.enigmacamp.model.dto.request.loan.transaction;

import com.enigmacamp.model.dto.id.CustomerId;
import com.enigmacamp.model.dto.id.InstallmentTypeId;
import com.enigmacamp.model.dto.id.LoanTypeId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionRequest {
    private LoanTypeId loanType;
    private InstallmentTypeId installmentType;
    private CustomerId customer;
    private Double nominal;
}

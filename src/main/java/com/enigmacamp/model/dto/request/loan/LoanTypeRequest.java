package com.enigmacamp.model.dto.request.loan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoanTypeRequest {
    private String type;
    private Double maxLoan;
}

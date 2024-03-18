package com.enigmacamp.model.dto.request.loan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoanTypeUpdateRequest {
    private String id;
    private String type;
    private Double maxLoan;
}

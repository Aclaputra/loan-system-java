package com.enigmacamp.model.dto.response.loan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoanTypeResponse {
    private String id;
    private String type;
    private Double maxLoan;
}

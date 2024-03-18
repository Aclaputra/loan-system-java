package com.enigmacamp.model.response.installment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InstallmentTypeResponse {
    private String id;
    private String instalmentType;
}

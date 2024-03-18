package com.enigmacamp.model.dto.response.installment;

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

package com.enigmacamp.model.dto.request.installment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InstallmentTypeRequest {
    private String instalmentType;
}

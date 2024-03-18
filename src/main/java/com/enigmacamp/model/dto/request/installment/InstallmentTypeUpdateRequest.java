package com.enigmacamp.model.dto.request.installment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class InstallmentTypeUpdateRequest {
    private String id;
    private String instalmentType;
}

package com.enigmacamp.model.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    private String message;
    private T data;
}

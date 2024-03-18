package com.enigmacamp.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommonResponse<T> {
    private String message;
    private T data;
}

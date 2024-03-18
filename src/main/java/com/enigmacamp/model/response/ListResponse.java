package com.enigmacamp.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ListResponse<T> {
    private String message;
    private List<T> data;
}

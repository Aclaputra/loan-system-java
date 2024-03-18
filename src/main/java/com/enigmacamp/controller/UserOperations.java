package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.user.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface UserOperations {
    @GetMapping(ApiPathConstant.PARAM_ID)
    CommonResponse<UserResponse> getUserById(@PathVariable String id);
}

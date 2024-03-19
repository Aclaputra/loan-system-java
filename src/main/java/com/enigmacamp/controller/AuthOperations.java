package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.auth.AuthAdminRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.auth.SigninResponse;
import com.enigmacamp.model.dto.response.auth.SignupResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface AuthOperations {
    @PostMapping(ApiPathConstant.SIGN_UP)
    CommonResponse<SignupResponse> signup(@RequestBody AuthAdminRequest request);

    @PostMapping(ApiPathConstant.SIGN_IN)
    CommonResponse<SigninResponse> signin(@RequestBody AuthAdminRequest request);
}

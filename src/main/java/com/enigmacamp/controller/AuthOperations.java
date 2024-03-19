package com.enigmacamp.controller;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.model.dto.request.auth.AuthAdminRequest;
import com.enigmacamp.model.dto.request.auth.AuthCustomerRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.auth.SigninResponse;
import com.enigmacamp.model.dto.response.auth.SignupResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstant.DEFAULT)
public interface AuthOperations {
    @PostMapping(ApiPathConstant.SIGN_UP + ApiPathConstant.ADMIN)
    ResponseEntity<CommonResponse<SignupResponse>> signupAdmin(@RequestBody AuthAdminRequest request);

    @PostMapping(ApiPathConstant.SIGN_IN)
    ResponseEntity<CommonResponse<SigninResponse>> signin(@RequestBody AuthAdminRequest request);

    @PostMapping(ApiPathConstant.SIGN_UP)
    ResponseEntity<CommonResponse<SignupResponse>> singup(@RequestBody AuthCustomerRequest request);
}

package com.enigmacamp.controller.impl;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.controller.AuthOperations;
import com.enigmacamp.model.dto.request.auth.AuthAdminRequest;
import com.enigmacamp.model.dto.request.auth.AuthCustomerRequest;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.auth.SigninResponse;
import com.enigmacamp.model.dto.response.auth.SignupResponse;
import com.enigmacamp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPathConstant.AUTH)
public class AuthController implements AuthOperations {
    @Autowired
    private AuthService authService;
    @Override
    @PostMapping(ApiPathConstant.SIGN_UP + ApiPathConstant.ADMIN)
    public ResponseEntity<CommonResponse<SignupResponse>> signupAdmin(AuthAdminRequest request) {
        SignupResponse signupResponse = authService.signupAdmin(request);

        CommonResponse<SignupResponse> response = new CommonResponse();
        response.setMessage(MessageConstant.SIGN_UP_ADMIN_SUCCESS);
        response.setData(signupResponse);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @PostMapping(ApiPathConstant.SIGN_IN)
    public ResponseEntity<CommonResponse<SigninResponse>> signin(AuthAdminRequest request) {
        SigninResponse signinResponse = authService.signin(request);

        CommonResponse<SigninResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.SIGN_IN_SUCCESS);
        response.setData(signinResponse);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @Override
    @PostMapping(ApiPathConstant.SIGN_UP)
    public ResponseEntity<CommonResponse<SignupResponse>> singup(AuthCustomerRequest request) {
        SignupResponse signupResponse = authService.signupCustomer(request);

        CommonResponse<SignupResponse> response = new CommonResponse<>();
        response.setMessage(MessageConstant.SIGN_UP_CUSTOMER_SUCCESS);
        response.setData(signupResponse);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}

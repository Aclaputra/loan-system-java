package com.enigmacamp.controller.impl;

import com.enigmacamp.constant.ApiPathConstant;
import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.controller.UserOperations;
import com.enigmacamp.model.dto.response.CommonResponse;
import com.enigmacamp.model.dto.response.user.UserResponse;
import com.enigmacamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPathConstant.USER)
public class UserController implements UserOperations {

    private final UserService userService;

    @Override
    @GetMapping(ApiPathConstant.PARAM_ID)
    public ResponseEntity<CommonResponse<UserResponse>> getUserById(String id) {
        UserResponse user = userService.getById(id);

        CommonResponse<UserResponse> response = new CommonResponse<>();
        response.setMessage(String.format(MessageConstant.GET_BY_ID_SUCCESS, id));

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}

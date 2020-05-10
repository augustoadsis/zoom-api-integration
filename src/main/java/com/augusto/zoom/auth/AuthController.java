package com.augusto.zoom.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@Slf4j
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping
    public ResponseEntity<Object> auth() {
        String token = authService.auth();
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(token));
    }

}

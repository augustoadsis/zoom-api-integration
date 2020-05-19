package com.augusto.zoom.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return userService.fildAll();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody UserRequest request) {
        UserResponse subaccount = userService.create(request);
        return ResponseEntity.status(HttpStatus.OK).body(subaccount);
    }

}

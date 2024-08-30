package com.app.controller;

import com.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/v1/users")
    public ResponseEntity<String> getAllUserDetails() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "max-age=3600");

        return new ResponseEntity<>(userService.getUsers(), headers, HttpStatus.OK);
    }
}

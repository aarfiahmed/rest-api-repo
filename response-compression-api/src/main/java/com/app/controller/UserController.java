package com.app.controller;

import com.app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    @GetMapping("/api/v1/users")
    public String getAllUserDetails(@RequestHeader Map<String, String> requestHeaders) {
        log.info("Client accept-encoding header values --> {}", requestHeaders.get("accept-encoding"));

        return userService.getUsers();
    }
}

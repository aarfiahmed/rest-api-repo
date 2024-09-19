package com.app.controller;

import com.app.entity.UserEntity;
import com.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    @GetMapping("/api/v1/users")
    public Page<UserEntity> getAllUserInfo(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        log.info("getting user details by page {} and size {}", page, size);
        return userService.getAllUser(page, size);
    }

    @GetMapping("/api/v1/users/native")
    public Page<UserEntity> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        log.info("Getting paging result by native query with page {} and size {}", page, size);
        return userService.getAllUserByNativeQuery(page, size);
    }
}

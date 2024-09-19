package com.app.config;

import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseConfig {
    private final UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        log.info("saving user info in DB");
        userRepository.saveAll(List.of(new UserEntity("raj"), new UserEntity("rahul"), new UserEntity("jasmeen"), new UserEntity("jinny")));
    }
}

package com.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {
    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    public String getUsers() {
       return restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class).getBody();
    }
}

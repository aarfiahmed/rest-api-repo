package com.app.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean
    Bucket bucket(@Value("${bucket.capacity}") Integer bucketCapacity, @Value("${bucket.refill-interval}") Integer bucketRefillInterval) {
        Refill refill = Refill.intervally(bucketCapacity, Duration.ofMinutes(bucketRefillInterval));
        Bandwidth limit = Bandwidth.classic(bucketCapacity, refill);
        return Bucket.builder()
                .addLimit(limit)
                .build();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

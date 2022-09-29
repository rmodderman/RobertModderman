package com.ilionx.carapp.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class BeansConfig {

    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }
}

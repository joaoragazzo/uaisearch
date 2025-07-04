package com.elastic.aisearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Value("${openai.api.key}")
    private String openAiToken;

    @Bean
    public WebClient openAiWebClient() {
        System.out.println("Token de API recebida: " + openAiToken);

        return WebClient.builder()
            .baseUrl("https://api.openai.com/v1")
            .defaultHeader("Authorization", "Bearer " + openAiToken)
            .build();
    }
}

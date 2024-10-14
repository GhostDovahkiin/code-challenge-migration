package com.example.dummyjson.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Classe de configuração que cria o Bean do WebClient, define a BASE_URL de acordo com o ambiente que a aplicação roda, e seta JSON como header padrão
 * 
 * @author Pedro
 * @version 1.0
 */
@Configuration
public class WebClientConfig {

    @Value("${environment.url}")
    private String BASE_URL;

    @Bean
    public WebClient createWebClient() {
        return WebClient.builder()
            .baseUrl(this.getUrl())
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
    }

    public String getUrl() {
        return this.BASE_URL;
    }
}

package com.example.ecoandrich.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
            .title("Mission-API-Document")
            .description("에코앤리치 과제 전형 API 문서입니다.")
            .version("1.0.0");
    }
}

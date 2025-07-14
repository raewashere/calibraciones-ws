package com.pemex.logistica.censos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
     @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Calibración de equipos de medición de flujo")
                        .version("1.0.0")
                        .description("APIs para registro la calibración de equipos de medición de flujo en Pemex Logística"));
    }
}

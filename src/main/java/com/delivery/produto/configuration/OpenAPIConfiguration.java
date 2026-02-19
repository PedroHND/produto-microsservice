package com.delivery.produto.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Produtos - Delivery")
                        .version("1.0.0")
                        .description("Documentação da API de microserviço de produtos")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

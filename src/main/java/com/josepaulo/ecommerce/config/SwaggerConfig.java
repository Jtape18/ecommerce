package com.josepaulo.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI ecommerceAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce API")
                        .description("API REST para controle de usuários, produtos, carrinho e pedidos")
                        .version("1.0.0"));
    }
}

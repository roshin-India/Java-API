package org.ecommerce.productservice2024.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/*
This is a configuration class in SpringBoot Application.
It is annotated with @configuration, indicating that this provides
bean/object definitions and configuration for the application context
 */

@Configuration
public class ApplicationConfiguration {

    @Bean // Denotes that this method is a bean producer
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

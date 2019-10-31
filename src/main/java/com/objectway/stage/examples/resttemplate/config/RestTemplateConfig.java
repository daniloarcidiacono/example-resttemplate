package com.objectway.stage.examples.resttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /**
     * It's better to define {@link RestTemplate} as a bean rather than
     * instancing it wherever is needed, because other libraries
     * (like Spring Cloud Sleuth for distributed tracing) do not work otherwise.
     *
     * @return the rest template bean
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

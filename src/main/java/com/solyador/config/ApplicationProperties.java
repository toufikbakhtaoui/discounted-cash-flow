package com.solyador.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationProperties {

    @Value("${app.api_key}")
    private String apiKey;
}

package com.shit.cloud.config.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * @author andrew
 * @date 2019/04/25
 */
@Configuration
public class Config {

    @Bean
    public HttpMessageConverter jackson2HttpMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        new Jackson2ObjectMapperBuilder().dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .configure(objectMapper);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}

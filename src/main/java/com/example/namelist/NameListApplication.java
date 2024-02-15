package com.example.namelist;

import org.apache.catalina.filters.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class NameListApplication {

    public static void main(String[] args) {
        SpringApplication.run(NameListApplication.class, args);
    }

    @Bean
    FilterRegistrationBean<RateLimitFilter> registerRateLimitFilter() {
        var registrar = new FilterRegistrationBean<RateLimitFilter>();
        registrar.setFilter(new RateLimitFilter());
        registrar.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registrar;
    }
}
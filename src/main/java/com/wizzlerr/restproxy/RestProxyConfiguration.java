package com.wizzlerr.restproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ImportAutoConfiguration
@ComponentScan("com.wizzlerr.*")
public class RestProxyConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(RestProxyConfiguration.class, args);
    }
}

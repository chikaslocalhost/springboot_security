package com.chikaslocalhost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:01 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost
 * Class Name : Application
 */
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
        })
@ComponentScan("com.chikaslocalhost.auth," +
        "com.chikaslocalhost.config," +
        "com.chikaslocalhost.controller," +
        "com.chikaslocalhost.repository," +
        "com.chikaslocalhost.service")
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

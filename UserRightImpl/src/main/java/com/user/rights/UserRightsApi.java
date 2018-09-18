package com.user.rights;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.user.rights")
@EntityScan(basePackages = "com.user.rights.entity")
@EnableJpaRepositories(basePackages = "com.user.rights.repository")
public class UserRightsApi {

    public static void main(String[] arg) {
        SpringApplication.run(UserRightsApi.class, arg);
    }
}

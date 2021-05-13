package com.dept.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.dept")
@EnableJpaRepositories("com.dept")
@EntityScan("com.dept")
public class DepartmentApplication {
	Logger logger = LoggerFactory.getLogger(DepartmentApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

}

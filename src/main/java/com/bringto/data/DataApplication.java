package com.bringto.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = { "com.bringto.data.model" })
@EnableJpaRepositories(basePackages = { "com.bringto.data.repository" })
public class DataApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DataApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}
	
}

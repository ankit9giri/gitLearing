package com.rptc.api;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rptc.api.repository.UserRepository;

@SpringBootApplication
//@CrossOrigin(origins = "*")
public class RptcApplication {

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public WebMvcConfigurer corConfigurer() {
		return new WebMvcConfigurer() {
			private final long MAX_AGE_SECS = 3600;

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*")
						.allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
						.allowCredentials(true).maxAge(MAX_AGE_SECS);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(RptcApplication.class, args);
	}

}

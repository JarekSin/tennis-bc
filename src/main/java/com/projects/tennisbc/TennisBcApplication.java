package com.projects.tennisbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class})
public class TennisBcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisBcApplication.class, args);
	}

}

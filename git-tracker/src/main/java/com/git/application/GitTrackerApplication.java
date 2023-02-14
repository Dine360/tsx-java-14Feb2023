package com.git.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"com.git"})

public class GitTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitTrackerApplication.class, args);
	}

}

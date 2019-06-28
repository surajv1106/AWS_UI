package com.aws.ui.SpringAWSUIDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;


@RefreshScope
@SpringBootApplication
@ComponentScan(basePackages = {"com.aws.*"})
public class SpringAwsuiDemoApplication {

	public static void main(String[] args) {


		SpringApplication.run(SpringAwsuiDemoApplication.class, args);
	}

}

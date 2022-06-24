package com.simplilearn.workshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.simplilearn.workshop") bad practice
@ComponentScan(basePackages = "com.simplilearn.workshop.services,com.simplilearn.workshop.repository")
public class TodoAppConfig {
	
}

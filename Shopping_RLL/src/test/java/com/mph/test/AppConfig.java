package com.mph.test;

/**
 * 
 * @author Prasanna_Palanivel
 *
 */

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.mph.*"})
public class AppConfig {
	@Bean
	SessionFactory sessionFactory() {
		return null;
	}

}
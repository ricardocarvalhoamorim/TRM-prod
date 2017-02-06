package com.adneom.trm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.adneom.trm"})
public class Application extends SpringBootServletInitializer {
	
	public static void main (String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}

}

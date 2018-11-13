package com.ngserver.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyTestNgServerApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(MyTestNgServerApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyTestNgServerApplication.class);
    }

}

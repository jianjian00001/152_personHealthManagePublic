package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(value = "com.ServletContextListener")
@MapperScan(basePackages = {"com.dao"})
public class gerenjiankangguanlixitongApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(gerenjiankangguanlixitongApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(gerenjiankangguanlixitongApplication.class);
    }
}

package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.example.demo")
@EnableEurekaClient
public class ProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}
	@Bean
	  ApplicationRunner init(ProductRepository repository) {
	      return args -> {
	          Stream.of("Rifles and shotguns", "Carbines", "Machine guns").forEach(name -> {
	              repository.save(new Product (name));
	          });
	          repository.findAll().forEach(System.out::println);
	      };
	  }
}

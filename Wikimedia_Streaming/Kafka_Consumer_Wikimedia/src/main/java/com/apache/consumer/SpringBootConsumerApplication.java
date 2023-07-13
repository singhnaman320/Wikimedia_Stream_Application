package com.apache.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsumerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootConsumerApplication.class, args);
	}
}



// Consumer will consume the data and write it to database
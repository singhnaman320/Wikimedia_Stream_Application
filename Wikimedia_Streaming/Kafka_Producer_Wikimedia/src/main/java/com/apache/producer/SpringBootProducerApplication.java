package com.apache.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apache.producer.services.WikimediaProducerService;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootProducerApplication.class, args);
	}

	@Autowired
	private WikimediaProducerService wikimediaProducerService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		wikimediaProducerService.sendMessage();
	}
}

package com.apache.producer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikimediaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducerService.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() {
		
		String givenTopic = "wikimediaStream";
		
		// To read real time stream data from Wikimedia we will use event source
		// We will add some library okHttp EventSource from maven
		
		
	}
}

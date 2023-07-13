package com.apache.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumerService.class);
	
	@KafkaListener(topics = "wikimediaStream", groupId = "streamGroup")
	public void consumeMessage(String eventMessage) {
		
		LOGGER.info(String.format("Event message Consumed: %s", eventMessage));
	}
}

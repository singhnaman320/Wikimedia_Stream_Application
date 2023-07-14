package com.apache.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apache.consumer.model.WikimediaData;
import com.apache.consumer.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumerService.class);
	
	@Autowired
	private WikimediaDataRepository wikimediaDataRepository;

	// For constructor based injection
	public KafkaDatabaseConsumerService(WikimediaDataRepository wikimediaDataRepository) {
		super();
		this.wikimediaDataRepository = wikimediaDataRepository;
	}

	@KafkaListener(topics = "wikimediaStream", groupId = "streamGroup")
	public void consumeMessage(String eventMessage) {
		
		LOGGER.info(String.format("Event message Consumed: %s", eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		
		wikimediaDataRepository.save(wikimediaData);
	}
}

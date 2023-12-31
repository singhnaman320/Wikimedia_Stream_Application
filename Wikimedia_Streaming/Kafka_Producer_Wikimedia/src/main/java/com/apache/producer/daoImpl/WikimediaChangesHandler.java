package com.apache.producer.daoImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

// Read streaming data
public class WikimediaChangesHandler implements EventHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;

	public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		// Not required
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		// Not required
	}
	
	// Whenever there is new event in wikimedia, this onMessage method will be triggered and it will read that event

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		
		LOGGER.info(String.format("Event data:", messageEvent.getData()));
		
		kafkaTemplate.send(topic, messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		// Not required
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		// Not required
	}
}

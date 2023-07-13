package com.apache.producer.daoImpl;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;

// Read streaming data
public class WikimediaChangesHandler implements BackgroundEventHandler{

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

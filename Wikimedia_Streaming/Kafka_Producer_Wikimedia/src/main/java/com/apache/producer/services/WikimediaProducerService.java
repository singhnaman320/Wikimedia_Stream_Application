package com.apache.producer.services;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.apache.producer.daoImpl.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaProducerService.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		
		String givenTopic = "wikimediaStream";
		
		/* To read real time stream data from Wikimedia we will use event source.
		 * We will add some library okHttp EventSource from maven
		 
		 * As data streaming from Wikimedia is JSON, so we have to use Jackson libraries.
		 * we will add "Jackson core" and "Jackson databind" 
		*/
		
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, givenTopic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		
		// Now we have to create a event source which will connect to wikimedia and read all the data
		
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
		
		
	}
}

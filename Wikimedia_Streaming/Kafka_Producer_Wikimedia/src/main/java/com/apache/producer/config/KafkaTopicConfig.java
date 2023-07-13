package com.apache.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	public NewTopic creatingTopic() {
		
		return TopicBuilder
				.name("wikimediaStream")
				.build();
	}
}

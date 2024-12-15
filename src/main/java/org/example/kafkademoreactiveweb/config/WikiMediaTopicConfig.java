package org.example.kafkademoreactiveweb.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class WikiMediaTopicConfig {
    @Bean
    public NewTopic wikiMediaStreamTopic() {
        return TopicBuilder.name("wikimedia-stream").build();
    }
}

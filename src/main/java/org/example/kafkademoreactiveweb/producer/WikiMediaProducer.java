package org.example.kafkademoreactiveweb.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiMediaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("send to test, message: {}", message);
        kafkaTemplate.send("wikimedia-stream", message);
    }
}

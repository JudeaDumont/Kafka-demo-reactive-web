package org.example.kafkademoreactiveweb.stream;

import lombok.extern.slf4j.Slf4j;
import org.example.kafkademoreactiveweb.producer.WikiMediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikiMediaStreamConsumer {
    private final WebClient webClient;
    private final WikiMediaProducer wikiMediaProducer;


    @Autowired
    public WikiMediaStreamConsumer(WebClient.Builder webClient, WikiMediaProducer wikiMediaProducer) {
        this.webClient = webClient.baseUrl("https://stream.wikimedia.org/v2").build();
        this.wikiMediaProducer = wikiMediaProducer;
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikiMediaProducer::send);
    }
}

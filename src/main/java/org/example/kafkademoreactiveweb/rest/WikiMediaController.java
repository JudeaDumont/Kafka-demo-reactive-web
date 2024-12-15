package org.example.kafkademoreactiveweb.rest;

import lombok.RequiredArgsConstructor;
import org.example.kafkademoreactiveweb.stream.WikiMediaStreamConsumer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikiMediaController {
    private final WikiMediaStreamConsumer wikiMediaStreamConsumer;

    @PostMapping
    public void startPublishing(){
        wikiMediaStreamConsumer.consumeStreamAndPublish();
    }
}

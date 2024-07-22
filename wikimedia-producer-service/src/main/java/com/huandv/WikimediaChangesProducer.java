package com.huandv;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Project: microservice_spring_kafka
 * @Date: 7/18/2024 9:53 AM
 * @Author: crist
 */
@Service
@AllArgsConstructor
public class WikimediaChangesProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {

        String topic = "wikimedia_recent";
        BackgroundEventHandler backgroundEventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(backgroundEventHandler, new EventSource.Builder(URI.create(url)));
        try (BackgroundEventSource source = builder.build()) {
            source.start();
            System.out.println("source started");
            TimeUnit.MINUTES.sleep(10);
        }

    }

}

package com.huandv;


import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @Description:
 * @Project: microservice_spring_kafka
 * @Date: 7/18/2024 10:11 AM
 * @Author: crist
 */
@AllArgsConstructor
public class WikimediaChangesHandler implements BackgroundEventHandler {

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;


    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}

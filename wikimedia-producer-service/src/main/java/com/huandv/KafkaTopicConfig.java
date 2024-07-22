package com.huandv;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @Description:
 * @Project: microservice_spring_kafka
 * @Date: 7/18/2024 9:46 AM
 * @Author: crist
 */
@Configuration
public class KafkaTopicConfig {

    public NewTopic topic(){
        return TopicBuilder.name("wikimedia_recentchange").build();
    }
}

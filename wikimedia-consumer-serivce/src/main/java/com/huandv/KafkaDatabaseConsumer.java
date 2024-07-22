package com.huandv;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Project: microservice_spring_kafka
 * @Date: 7/19/2024 10:58 AM
 * @Author: crist
 */
@Service
public class KafkaDatabaseConsumer {

    @KafkaListener(topics = "wikimedia_recent", groupId = "myGroup")
    public void consume(String eventMessage){
        System.out.println(eventMessage);  //đây là dữ liệu lấy từ topic
    }
}

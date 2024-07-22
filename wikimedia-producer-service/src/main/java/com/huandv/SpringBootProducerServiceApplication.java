package com.huandv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Project: ${PROJECT_NAME}
 * @Date: ${DATE} ${TIME}
 * @Author: ${USER}
 */
@SpringBootApplication
public class SpringBootProducerServiceApplication implements CommandLineRunner {

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }
}
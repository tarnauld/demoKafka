package com.esgi.demo.kafka;

/**
 * @author timotheearnauld
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    private String kafkaTopic = "esgi";

    public void send(String data) {
        log.info("sending data='{}'", data);

        kafkaTemplate.send(kafkaTopic, data);
    }
}

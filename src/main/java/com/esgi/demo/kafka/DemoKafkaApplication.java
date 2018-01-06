package com.esgi.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class DemoKafkaApplication{
    @Autowired
    private KafkaTemplate<Integer, String> template;

    @Autowired
    KafkaProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(DemoKafkaApplication.class, args);
    }

    @GetMapping(value="/")
    public String root(@RequestParam("data")String data){
        producer.send(data);
        return "Done";
    }

    @GetMapping(value="/health")
    public String health(@RequestParam("data")String data){
        return "Nothing configured yet.\n Try /data=message to publish in kafka topic.";
    }
}

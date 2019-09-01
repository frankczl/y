package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.YKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/y-kafka")
public class YKafkaResource {

    private final Logger log = LoggerFactory.getLogger(YKafkaResource.class);

    private YKafkaProducer kafkaProducer;

    public YKafkaResource(YKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}

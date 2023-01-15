package com.mdsujan;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {
    @KafkaListener(topics = "myTopic", groupId = "myGroup1")
    void listener(String data){
        System.out.println("listener received: "+data + ".");
    }
}

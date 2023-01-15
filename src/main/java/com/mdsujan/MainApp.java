package com.mdsujan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    CommandLineRunner myCommandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
//            kafkaTemplate.send("myTopic", "hello from myCmdLineRunner");
//            kafkaTemplate.send("myTopic", "hello again");

            for (int i = 0; i < 10; i++) {
                kafkaTemplate.send("myTopic", "for loop msg: #" + i);
            }
        };
    }
}

package com.mdsujan.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyProducerConfig {
    @Value("${spring.kafka.bootstrap-server}")
    private String bootstrapServer;

    // properties for producer config
    public Map<String, Object> myProducerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        return props;
    }

    // producer factory creates the producer
    @Bean
    public ProducerFactory<String, String> myProducerFactory() {
        return new DefaultKafkaProducerFactory<>(myProducerConfig());
    }

    // a way - 'template' - for the messages to send

    @Bean
    public KafkaTemplate<String, String> myKafkaTemplate(
            ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}

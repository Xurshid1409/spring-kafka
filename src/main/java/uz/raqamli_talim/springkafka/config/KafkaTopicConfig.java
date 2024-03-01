package uz.raqamli_talim.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic stringTopic() {

        return TopicBuilder.name("stringTopic")
                .build();
    }

    @Bean
    public NewTopic jsonTopic() {

        return TopicBuilder.name("jsonTopic")
                .build();
    }

}

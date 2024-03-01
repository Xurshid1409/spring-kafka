package uz.raqamli_talim.springkafka.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import uz.raqamli_talim.springkafka.payload.User;

@Service
public class JsonKafkaProducer {

    private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {

        LOG.info(String.format("Json Message send: %s", data.toString()));
        Message<User> message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
                .build();
        kafkaTemplate.send(message);
    }
}

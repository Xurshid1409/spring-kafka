package uz.raqamli_talim.springkafka.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import uz.raqamli_talim.springkafka.payload.User;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "jsonTopic", groupId = "myGroup")
    public void consumeMessage(User data) {
        LOG.info(String.format("Json Message received -> %s", data.toString()));
    }

}

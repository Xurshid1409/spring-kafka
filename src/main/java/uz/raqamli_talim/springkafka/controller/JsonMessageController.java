package uz.raqamli_talim.springkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.raqamli_talim.springkafka.kafka.producer.JsonKafkaProducer;
import uz.raqamli_talim.springkafka.payload.User;

@RestController
@RequestMapping("/api/kafka/")
public class JsonMessageController {

    private final JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("json")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to the topic");
    }
}

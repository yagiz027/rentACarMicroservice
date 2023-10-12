package com.yagiz.commonservice.utils.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.Events.Event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    /**
     * Bu method kafka'ya bir mesaj iletme işlemi gerçekleştirir. 
     * @param <T> Tipinde herhangi bir custom event sınıfı ve event message alır.
     * Bu sınıf'ı generic bir type olarak kullanarak ilgili payload üzerinden mesaj oluşturur.
     * Ardından mesajı kafkaya iletir. 
     * @param event SomeEvent.class
     * @param topic Topic => gerçekleşelen işlem mesajı
     * @author yagizeris
     */
    public <T extends Event> void sendMessage(T event, String topic) {
        log.info(String.format("%s event => %s", topic, event.toString()));
        Message<T> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic).build();

        kafkaTemplate.send(message);
    }
}

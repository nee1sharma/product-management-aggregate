package com.sharma.nks.products.messaging.kafka;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class MessageProducerImpl implements MessageProducer {
    private final String TOPIC = "topic_product_order";
    private final Logger LOGGER = LoggerFactory.getLogger(MessageProducerImpl.class);
    private final Gson gson = new Gson();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(Object product) {
        String message = gson.toJson(product);
        LOGGER.debug("#### -> Producing message:  {}", message);
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, message);
        ListenableFuture<SendResult<String, String>> future =
                this.kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.error("Error while sending message to topic {}", TOPIC);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.error("Message send successfully TOPIC: {}, PARTITION: {}, TIMESTAMP: {}",
                        result.getRecordMetadata().topic(), result.getRecordMetadata().partition(),
                        result.getProducerRecord().timestamp());
            }
        });
    }
}

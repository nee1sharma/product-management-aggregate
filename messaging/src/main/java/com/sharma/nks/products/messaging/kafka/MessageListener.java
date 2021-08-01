package com.sharma.nks.products.messaging.kafka;

public interface MessageListener {

    void readMessage(String message);
}

package com.example.messagesupport.sqs;

import com.example.messagesupport.controller.SnsMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * Created by wminikuma@gmail.com on 2020/03/23
 * Blog : https://minikuma-laboratory.tistory.com/
 * Github : http://github.com/minikuma
 */

@Component
@Lazy
@Slf4j
public class SpringCloudSQS {

    static final String QUEUE_NAME = "spring-cloud-test-queue";

    public SpringCloudSQS(QueueMessagingTemplate queueMessagingTemplate, SnsMessagePublisher snsMessagePublisher) {
        this.queueMessagingTemplate = queueMessagingTemplate;
        this.snsMessagePublisher = snsMessagePublisher;
    }

    private final QueueMessagingTemplate queueMessagingTemplate;
    private final SnsMessagePublisher snsMessagePublisher;

    @SqsListener(QUEUE_NAME)
    public void receiveMessage(String message, @Header("SenderId") String senderId) {
        log.info("Received message: {}, having SenderId: {}", message, senderId);
    }

    public void send(String queueName, Object message) {
        this.queueMessagingTemplate.convertAndSend(queueName, message);
    }
}

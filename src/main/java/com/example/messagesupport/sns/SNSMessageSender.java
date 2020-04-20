package com.example.messagesupport.sns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by wminikuma@gmail.com on 2020/03/23
 * Blog : https://minikuma-laboratory.tistory.com/
 * Github : http://github.com/minikuma
 */

@Slf4j
@Component
public class SNSMessageSender {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    public SNSMessageSender(NotificationMessagingTemplate notificationMessagingTemplate) {
        this.notificationMessagingTemplate = notificationMessagingTemplate;
    }

    public void send(String topicName, Object message, String subject) {
        this.notificationMessagingTemplate.sendNotification(topicName, message, subject);
    }
}

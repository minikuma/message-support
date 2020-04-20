package com.example.messagesupport.controller;

import com.example.messagesupport.domain.EventMessage;
import com.example.messagesupport.sns.SNSMessageSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wminikuma@gmail.com on 2020/03/23
 * Blog : https://minikuma-laboratory.tistory.com/
 * Github : http://github.com/minikuma
 * Comments: SNS 기능 테스트
 *           구성된 Topic 에 메시지 전송
 *           SNS-SQS 구독자 생성인 된 상태인 경우 -> SNS message 전송 -> 이미 구독된 Topic 을 SQS 를 통해 수신 가능
 */

@RestController
public class SnsMessagePublisher {

    @Value(value = "${sns.topicName}")
    private String topicName;

    private final SNSMessageSender snsMessageSender;

    public SnsMessagePublisher(SNSMessageSender snsMessageSender) {
        this.snsMessageSender = snsMessageSender;
    }

    @GetMapping("/sns-publish")
    public void triggerSnsMessage() {
        this.snsMessageSender.send(topicName, EventMessage.builder().event("success").build(), "subject");
    }
}

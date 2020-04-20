package com.example.messagesupport.controller;

import com.example.messagesupport.domain.EventMessage;
import com.example.messagesupport.sqs.SpringCloudSQS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wminikuma@gmail.com on 2020/03/23
 * Blog : https://minikuma-laboratory.tistory.com/
 * Github : http://github.com/minikuma
 * Comments: SQS 단독 기능 점검용
 *           SQS trigger 를 통한 메시지 수신 (등록된 Queue 에 존재 하는 메시지 수신)
 */

@RestController
@Slf4j
public class SqsMessagePublisher {

    @Value(value = "${sqs.queueName}")
    private String queueName;

    private final SpringCloudSQS springCloudSQS;

    public SqsMessagePublisher(SpringCloudSQS springCloudSQS) {
        this.springCloudSQS = springCloudSQS;
    }

    @GetMapping("/sqs-publish")
    public void triggerSqsMessage(@RequestParam String msg) {
        this.springCloudSQS.send(queueName, EventMessage.builder().event(msg).build());
    }
}

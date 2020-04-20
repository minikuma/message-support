package com.example.messagesupport.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wminikuma@gmail.com on 2020/03/23
 * Blog : https://minikuma-laboratory.tistory.com/
 * Github : http://github.com/minikuma
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventMessage {
    private String event;
}

package com.activemq.consumer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.activemq.domain.Person;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Consumer {
	private final JmsTemplate jmsTemplate;
	public Person consume() {
		return (Person) jmsTemplate.receiveAndConvert();
	}
}

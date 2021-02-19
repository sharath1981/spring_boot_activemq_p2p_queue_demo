package com.activemq.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.activemq.domain.Person;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Producer {
	private final JmsTemplate jmsTemplate;
	public void produce(final Person person) {
		jmsTemplate.convertAndSend(person);
	}

}

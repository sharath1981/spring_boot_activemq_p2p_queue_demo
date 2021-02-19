package com.activemq.resource;

import java.util.Objects;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activemq.consumer.Consumer;
import com.activemq.domain.Person;
import com.activemq.producer.Producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/persons")
public class PersonResource {
	
	private final Producer producer;
	private final Consumer consumer;

	@PostMapping("produce")
	public void produce(@RequestBody Person person) {
		Optional.ofNullable(person)
		        .filter(Objects::nonNull)
		        .ifPresent(producer::produce);
	}
	
	@GetMapping("consume")
	public Person consume() {
		return consumer.consume();
	}

}

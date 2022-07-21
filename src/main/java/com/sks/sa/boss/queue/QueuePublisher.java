//package com.sks.sa.boss.queue;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//public class QueuePublisher {
//	
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//	
//	public void publish(Long executionNum,JsonNode requestParmas) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		rabbitTemplate.convertAndSend("read-json",mapper.writeValueAsString(requestParmas));
//	}
//
//}

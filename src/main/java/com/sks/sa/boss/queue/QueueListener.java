//package com.sks.sa.boss.queue;
//
//import java.io.IOException;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//public class QueueListener {
//
//	@RabbitListener(queues = "read-json",containerFactory = "amqpConnectionfactory")
//	public void message(Message in) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode node = mapper.readTree(in.getBody());
//		entry fileName , executionNum ,status , success ,failed
//		to db
//	}
//}

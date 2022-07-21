//package com.sks.sa.boss.framework.amqp;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.QueueBuilder;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@EnableRabbit
//public class LocalAmqpConfig {
//	
//	@Autowired
//	ConnectionFactory connectionFactory;
//	
//	@Bean(name = "amqpConnectionfactory")
//	public SimpleRabbitListenerContainerFactory amqpConnectionfactory(ConnectionFactory factory) {
//		SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
//		containerFactory.setConnectionFactory(connectionFactory);
//		containerFactory.setConcurrentConsumers(1);
//		containerFactory.setMaxConcurrentConsumers(3);
//		containerFactory.setDefaultRequeueRejected(false);
//		return containerFactory;
//	}
//	
//	@Bean
//	public Queue readJsonfile() {
//		return QueueBuilder.durable("read-json").build();
//	}
//
//}

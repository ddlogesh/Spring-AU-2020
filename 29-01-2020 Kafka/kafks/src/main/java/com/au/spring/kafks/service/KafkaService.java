package com.au.spring.kafks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.au.spring.kafks.controller.MainController;

@Service
public class KafkaService {
	
	@Autowired
	private MainController mainController;
	
	@KafkaListener(topics = "source_topic", groupId = "group1")
	public void consumeTopic1(String message) {
		System.out.println("\t\t\t\tconsumer1: " + message);
		try {
			Integer number = Integer.parseInt(message);
			if(number % 2 != 0)
				mainController.sendMessage(mainController.topic2, String.valueOf(message.length()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@KafkaListener(topics = "stream_topic", groupId = "group2")
	public void consumeTopic2(String message) {
		System.out.println("\t\t\t\t\t\t\t\tconsumer2: " + message);
	}
}

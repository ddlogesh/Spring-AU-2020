package com.au.spring.kafks.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MainController {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public static final String topic1 = "source_topic";
	public static final String topic2 = "stream_topic";
	
	@GetMapping("/post")
	public void post() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				Integer number = new Random().nextInt(10000);
				System.out.println("\n" + number + " produced");
				sendMessage(topic1, number.toString());
			}
		}, 0, 2000);
	}
	
	public void sendMessage(String topic, String message) {
		kafkaTemplate.send(topic, message);
	}
}

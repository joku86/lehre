package com.example.demo.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
 
public class Klasse {
	

	@Scheduled(cron = "*/5 * * * * MON-FRI")
	public void doThat() {
		System.out.println(Thread.currentThread());
		System.out.println("Hallo aus der DoThat");
	}
	
}
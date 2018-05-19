package com.example.demo.asynch;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class SleepAndDream {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Async
	public void sleep1Seconds() throws Exception {
		log.info("Schlafe jetzt: PRRRRZÜÜÜÜ");
		TimeUnit.SECONDS.sleep(1);
		log.info("Ausgeschlafen");
	}

	@Async
	public Future<String> sleep1SecondWithDream() throws Exception {
		log.info("Fange an zu träumen");
		TimeUnit.SECONDS.sleep(1);
		log.info("Fertig mit dem Traum");
		return new AsyncResult<String>("Habe von Einhörnern geträumt");
	}
}

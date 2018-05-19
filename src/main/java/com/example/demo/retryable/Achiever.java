package com.example.demo.retryable;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

//@Component
public class Achiever {
	int tries = 1;

	@Retryable(maxAttempts=5)
	public int tryIt() {
		System.out.println("Runde " + tries);
		tries++;
		if (tries != 2)
			throw new IllegalStateException("Runde nicht 3");
		return tries;
	}
}
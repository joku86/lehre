package com.example.demo.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.validation.ServerInfo;

@RestController
public class MyRestController {
	@GetMapping("/home")
	ServerInfo home() {
		return new ServerInfo();
	}

	@GetMapping("/chart")
	List<int[]> chart() {

		List<int[]> res = IntStream.range(0	, 10)
			    .mapToObj(n -> new int[] { n, (int) (Math.random() * n * 100) }).collect(Collectors.toList());
	 return res;
	}
}
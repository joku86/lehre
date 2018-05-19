package com.example.demo.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserService {
	public String addUser(@Valid User user) {
		return "constante rückgabe";
	}
}
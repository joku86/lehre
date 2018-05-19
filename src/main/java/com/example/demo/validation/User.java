package com.example.demo.validation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	 
	@Size(min = 6, max = 20)
	public String username;
	@NotEmpty
	public String email;
}

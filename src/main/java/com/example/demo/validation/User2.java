package com.example.demo.validation;

import org.springframework.data.annotation.Id;

public class User2 {

	public User2(long id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public User2(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	@Id
	public Long id;
	public String username, email;

	@Override
	public String toString() {
		return "User2 [id=" + id + ", username=" + username + ", email=" + email + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

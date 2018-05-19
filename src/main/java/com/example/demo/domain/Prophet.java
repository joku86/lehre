package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Prophet {
	
	
	
//	@Autowired 
//	private   Hash hash;
//	
	public Prophet(@Autowired Mountain m) {this.mountain=m;
		
	}

	private String name;
	
	private Mountain mountain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mountain getMountain() {
		return mountain;
	}
	
	public void setMountain(Mountain mountain) {
		this.mountain = mountain;
	}

	@Override
	public String toString() {
		return "Prophet [name=" + name + ", mountain=" + mountain + "]";
	}

//	public Hash getHash() {
//		return hash;
//	}
//
//	public void setHash(Hash hash) {
//		this.hash = hash;
//	}

}

package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class Mountain {
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getHeigh() {
	return heigh;
}
public void setHeigh(int heigh) {
	this.heigh = heigh;
}
private int heigh;
@Override
public String toString() {
	return "Mountain [name=" + name + ", heigh=" + heigh + "]";
}

}

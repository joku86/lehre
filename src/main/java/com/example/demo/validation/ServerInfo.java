package com.example.demo.validation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServerInfo {
	public String server = System.getProperty("os.name") + " " + System.getProperty("os.version");
}

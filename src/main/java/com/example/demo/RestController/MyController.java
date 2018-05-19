package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@Autowired
	private Environment env; 
	
	@RequestMapping("/help")
	String help(Model model) {
		model.addAttribute("name", env.getProperty( "username" ));
		return "help";
	}
}

package com.spring.teste.security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HomeController {

	@GetMapping()
	@ResponseBody
	public String helloWorld() {
		return "Hello World!";
	}	
	
}

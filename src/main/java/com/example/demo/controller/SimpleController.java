package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping("/simple") //Localhost:8080/simple
	public String simpleFunc() {
		System.out.println("KONOTOOROROAKORK");
		return "home"; //ielādēs home.html lapu
	}
}

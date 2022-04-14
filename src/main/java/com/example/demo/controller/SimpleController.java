package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping("/simple") //Localhost:8080/simple
	public String simpleFunc() {
		System.out.println("KONOTOOROROAKORK");
		return "home"; //ielādēs home.html lapu
	}
	
	@GetMapping("/msg") //Localhost:8080/simple
	public String msgFunc(Model model) { ///vajag lai sutitu datus no backend uz frontend
		model.addAttribute("packet", "Ziņa no backend puses.....");
		System.out.println("msg kontrollieries ir izsaukts");
		return "msg-page"; //ielādējam msg-page.html lapu
	}
}

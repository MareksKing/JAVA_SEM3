package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Product;

@Controller
public class SimpleController {
	
	private ArrayList<Product> allProducts = new ArrayList<Product>(
			Arrays.asList(
					new Product("Ķirši", 0.69f, 200), 
					new Product("Bumbieri", 1.24f, 200), 
					new Product("Maize", 0.99f, 150)));

	@GetMapping("/simple") //Localhost:8080/simple
	public String simpleFunc() {
		System.out.println("KONOTOOROROAKORK");
		return "home"; //ielādēs home.html lapu
	}
	
	@GetMapping("/msg") //Localhost:8080/msg
	public String msgFunc(Model model) { ///vajag lai sutitu datus no backend uz frontend
		model.addAttribute("packet", "Ziņa no backend puses.....");
		System.out.println("msg kontrollieries ir izsaukts");
		return "msg-page"; //ielādējam msg-page.html lapu
	}
	
	@GetMapping("/object") //Localhost:8080/object
	public String objectFunc(Model model) { 
		Product product = new Product("Ābols", 0.99f, 100);
		model.addAttribute("packet", product);
		System.out.println("ābolu kontrollieries ir izsaukts");
		return "product-page"; //ielādējam product-page.html lapu
	}
	
	//localhost:8080/list
	@GetMapping("/list") //Localhost:8080/object
	public String listFunc(Model model) { 
		model.addAttribute("packet", allProducts);
		System.out.println("List kontrollieries ir izsaukts");
		return "list-page"; //ielādējam product-page.html lapu
	}
}

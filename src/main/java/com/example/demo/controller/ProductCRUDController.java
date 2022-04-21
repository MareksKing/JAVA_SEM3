package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.services.ICRUDProductService;

@Controller
@RequestMapping("/product") //localhost:8080/product
public class ProductCRUDController {

	@Autowired
	private ICRUDProductService prodService;
	
	@GetMapping("/all") //localhost:8080/product/all
	public String getProductAll(Model model) {
		ArrayList<Product> list = prodService.readAllProducts();
		model.addAttribute("packet", list);
		return "list-page";
	}
	
	@GetMapping("/one") //localhost:8080/product/one?id=2;
	public String getProductOne(@RequestParam(name = "id") int id, Model model) {
		try {
			Product temp = prodService.readByID(id);
			model.addAttribute("packet", temp);	
			return "product-page";
		} catch (Exception e){
			e.printStackTrace();
			model.addAttribute("errorMSG", e.getMessage());
			return "error-page";
		}
	}
}

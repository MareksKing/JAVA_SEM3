package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.services.ICRUDProductService;
import com.example.demo.services.IProductFilter;

@Controller
@RequestMapping("/product/filter") //localhost:8080/product/expensive
public class ProductFilterController {
	
	@Autowired
	private IProductFilter prodService;
	
	
	@GetMapping("/expensive")
	public String filterExpensiveItems(Model model) {
		ArrayList<Product> list = prodService.filterExpensiveProducts();
		model.addAttribute("packet", list);
		return "list-page";
	}
	
	@GetMapping("/lowquantity")
	public String filterLowQuantityItems(Model model) {
		ArrayList<Product> list = prodService.filterLowQuantityProducts();
		model.addAttribute("packet", list);
		return "list-page";
	}
	

}

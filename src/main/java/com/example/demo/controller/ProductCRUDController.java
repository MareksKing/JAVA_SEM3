package com.example.demo.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/all/{id}") //localhost:8080/product/all/101
	public String getProductByID(@PathVariable(name = "id") int id, Model model) {
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
	
	@GetMapping("/add") //localhost:8080/product/add
	public String getProductAdd(Product product) {
		return "add-product";
	}
	
	
	@PostMapping("/add") //localhost:8080/product/add
	public String postProductAdd(@Valid Product product, BindingResult result) { //tukšs produkts tiek iedots HTML un šeit saņem no HTML
		if(!result.hasErrors()) {
			Product prod = prodService.createProduct(product);
			//return "redirect;//product/all";
			return "redirect:/product/all/" +prod.getID();			
		}
		return "add-product";
	}
	
	@GetMapping("/update/{id}")
	public String getProductUpdate(@PathVariable(name="id") int id, Model model)
	{
		try {
			Product prod = prodService.readByID(id);
			model.addAttribute("packet", prod);
			return "update-product";
		} catch (Exception e) {
			model.addAttribute("errorMSG", e.getMessage());
			return "error-page";//atvērs error-page.html lapu
		}
		
	}
	@PostMapping("/update/{id}") //localhost:8080/product/update/101
	public String postProductUpdate(@PathVariable(name = "id") int id, Product product) { //tukšs produkts tiek iedots HTML un šeit saņem no HTML
		try {
			prodService.updateByID(id, product);
			return "redirect:/product/all/"+id;
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/product/all";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProductByID(@PathVariable(name = "id") int id, Model model) {
			try {
				prodService.deleteByID(id);
				model.addAttribute("packet", prodService.readAllProducts());
				return "list-page";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error-page";
			}
	}
}

package com.example.demo.services.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.services.ICRUDProductService;
import com.example.demo.services.IProductFilter;

@Service
public class ProductFilterImplementation implements IProductFilter {

	@Autowired
	private ICRUDProductService prodService;
	
	@Override
	public ArrayList<Product> filterExpensiveProducts() {
		ArrayList<Product> expProducts = new ArrayList<Product>();
		for(Product prod : prodService.readAllProducts()) {
			if(prod.getPrice() > 5.00f) {
				expProducts.add(prod);
			}
		}
		return expProducts;
	}

	@Override
	public ArrayList<Product> filterLowQuantityProducts() {
		ArrayList<Product> lowCountProducts = new ArrayList<Product>();
		for(Product prod : prodService.readAllProducts()) {
			if(prod.getQuantity() < 2) {
				lowCountProducts.add(prod);
			}
		}
		return lowCountProducts;
	}

	@Override
	public void discontAllProducts() {
		for (Product prod : prodService.readAllProducts()) {
			float atlaide = prod.getPrice() - prod.getPrice() * 0.2f;
			prod.setPrice(atlaide);
		}
		
	}

}

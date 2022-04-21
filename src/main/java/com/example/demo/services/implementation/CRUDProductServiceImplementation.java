package com.example.demo.services.implementation;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImplementation implements ICRUDProductService {

	private ArrayList<Product> allProducts = new ArrayList<Product>(
			Arrays.asList(
					new Product("Ķirši", 0.69f, 200), 
					new Product("Bumbieri", 1.24f, 200), 
					new Product("Maize", 0.99f, 150)));
	@Override
	public Product createProduct(Product temp) {
		for(Product prod: allProducts) {
			if(prod.getTitle().equals(temp.getTitle())&& prod.getPrice() == temp.getPrice()) {
				int newQuantity = prod.getQuantity() + temp.getQuantity();
				prod.setQuantity(newQuantity);
				return prod;
			}
		}
		
		Product newProduct = new Product(temp.getTitle(), temp.getPrice(), temp.getQuantity());
		allProducts.add(newProduct);
		return newProduct;
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		return allProducts;
	}

	@Override
	public Product readByID(int id) throws Exception {
		if(id >=100) {
			for(Product prod : allProducts) {
				if (prod.getID() == id) {
					return prod;
				}
			}
			Exception exc = new Exception("Nepastāv produkts");
			throw exc;
			
		} else {
			Exception exc = new Exception("Nav pareiza ID");
			throw exc;
		}
		
	}

	@Override
	public void updateByID(int id, Product temp) throws Exception {
		if(id >= 100) {
			for(Product prod : allProducts) {
				if(prod.getID() == id) {
					
					if(!prod.getTitle().equals(temp.getTitle())) {
						prod.setTitle(temp.getTitle());						
					} 
					
					if(temp.getPrice() != prod.getPrice()) {
						prod.setPrice(temp.getPrice());						
					}
					
					if(temp.getQuantity() != prod.getQuantity()) {
						prod.setQuantity(temp.getQuantity());						
					} 
				}
			}
		} else {
			Exception exc = new Exception("Nav pareiza ID");
			throw exc;
		}
		
		
	}

	@Override
	public void deleteByID(int id) throws Exception {
		if(id >= 100) {
			for(Product prod : allProducts) {
				if(prod.getID() == id) {
					allProducts.remove(prod);
					
				}
			}
		}else {
			Exception exc = new Exception("Nav pareiza ID");
			throw exc;
		}
		
	}
	
}

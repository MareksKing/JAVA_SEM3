package com.example.demo.services.implementation;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.IProductRepo;
import com.example.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImplementation implements ICRUDProductService {

	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public Product createProduct(Product temp) {
		if(prodRepo.existsByTitleAndPrice(temp.getTitle(), temp.getPrice())) {
			Product prod = prodRepo.findByTitleAndPrice(temp.getTitle(), temp.getPrice());
			int newQuantity = prod.getQuantity() + temp.getQuantity();
			prod.setQuantity(newQuantity);
			prodRepo.save(prod);
			return prod;
			
		}else {
			Product newProduct = new Product(temp.getTitle(), temp.getPrice(), temp.getQuantity());
			Product productFromDB = prodRepo.save(newProduct);
			return productFromDB;
		}
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		return (ArrayList<Product>) prodRepo.findAll();
	}

	@Override
	public Product readByID(int id) throws Exception {
		if (prodRepo.existsById(id)) {
			return prodRepo.findById(id).get();
		}
		Exception exc = new Exception("Nepastāv produkts");
		throw exc;
		
	}

	@Override
	public void updateByID(int id, Product temp) throws Exception {
			
			if(prodRepo.existsById(id)) {
				Product prod = prodRepo.findById(id).get();
				
				if(!prod.getTitle().equals(temp.getTitle())) {
					prod.setTitle(temp.getTitle());						
				} 
				
				if(temp.getPrice() != prod.getPrice()) {
					prod.setPrice(temp.getPrice());						
				}
				
				if(temp.getQuantity() != prod.getQuantity()) {
					prod.setQuantity(temp.getQuantity());						
				} 
				prodRepo.save(prod);
			}else {
				throw new Exception("Produkts nepastāv");
			} 
		
	}

	@Override
	public void deleteByID(int id) throws Exception {
		if(prodRepo.existsById(id)) {
			prodRepo.deleteById(id);
		} else {
			throw new Exception("ID neeksistē");
		}
		
		
		
	}
	
}

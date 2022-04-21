package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Product;

public interface ICRUDProductService {
	//CRUD  -  Create  -  Read  -  Update  -  Delete
	//Create
	public abstract Product createProduct(Product temp);

	
	//Read all
	public abstract ArrayList<Product> readAllProducts();
	//Read by ID
	public abstract Product readByID(int id) throws Exception;
	
	//Update
	public abstract void updateByID(int id, Product temp) throws Exception;
	
	//Delete
	public abstract void deleteByID(int id) throws Exception;
}

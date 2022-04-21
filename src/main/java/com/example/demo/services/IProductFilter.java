package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Product;

public interface IProductFilter {
	public abstract ArrayList<Product> filterExpensiveProducts();
	public abstract ArrayList<Product> filterLowQuantityProducts();
	public abstract void discontAllProducts();
}

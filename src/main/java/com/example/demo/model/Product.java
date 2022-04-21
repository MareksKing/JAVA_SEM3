package com.example.demo.model;

public class Product {

	//1.mainigie
	private String title;
	private float price;
	private int quantity;
	private int id = 100;
	private static int counter = 0;
	
	//2.get,set
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quatity) {
		this.quantity = quatity;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID() {
		this.id += counter++;
	}
	
	//3.konstruktori
	public Product(String title, float price, int quatity) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quatity;
		setID();
	}
	
	public Product() {
		super();
		setID();
	}
	
	//4.toString
	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}

package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table
@Entity
public class Product {

	//1.mainigie
	@Column(name="Title")
	@NotNull
	@Size(min = 3, max = 30, message = "Title needs to be longer than 3 letters, but smaller than 30")
	@Pattern(regexp = "[A-Z]{1}[a-z]+", message="The first letter must be capital")
	private String title;
	
	@Column(name="Price")
	@Min(value = 0, message = "Price can't be smaller than 0")
	@Max(value = 1000000, message = "Too expansive")
	private float price;
	
	@Column(name="Quantity")
	@Min(value = 0, message = "Quantity can't be smaller than 0")
	@Max(value = 1000, message = "Can't fit that quantity")
	private int quantity;
	
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = 100;
	
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
	
	
	//3.konstruktori
	public Product(String title, float price, int quatity) {
		this.title = title;
		this.price = price;
		this.quantity = quatity;
	}
	
	public Product() {}
	
	//4.toString
	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}

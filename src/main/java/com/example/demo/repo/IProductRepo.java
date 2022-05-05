package com.example.demo.repo;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer>{

	boolean existsByTitleAndPrice(String title, float price);

	Product findByTitleAndPrice(String title, float price);
	
}

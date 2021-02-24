package dev.fun.hello.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private Long id;
	private List<Product> products;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Cart(Long id, List<Product> products) {
		this.id = id;
		this.products = products;
	}
	
	public Cart(List<Product> products) {
		this.products = products;
	}
	
	public Cart() {
		this.products = new ArrayList<>();
	}
	
}

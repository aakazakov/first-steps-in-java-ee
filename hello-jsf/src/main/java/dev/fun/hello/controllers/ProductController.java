package dev.fun.hello.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dev.fun.hello.entities.Product;
import dev.fun.hello.repositories.ProductRepository;

@Named
@SessionScoped
public class ProductController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductRepository productRepository;
	
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Product> getAllProducts() {
		return productRepository.getAll();
	}
	
	public String create() {
		product = new Product();
		return "";
	}
	
	public String read() {
		return "";
	}
	
	public String update() {
		return "";
	}
	
	public void delete() {
		
	}

}

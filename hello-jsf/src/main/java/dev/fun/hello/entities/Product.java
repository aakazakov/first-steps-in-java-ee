package dev.fun.hello.entities;

public class Product {

	private Long id;
	private String title;
	private Integer price;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Product(Long id, String title, Integer price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public Product(String title, Integer price) {
		this.title = title;
		this.price = price;
	}
	
	public Product() {
		
	}
	
	@Override
	public String toString() {
		return String.format("%s_{id: %d, title: %s, price: %d}", getClass().getSimpleName(), id, title, price);
	}
	
}

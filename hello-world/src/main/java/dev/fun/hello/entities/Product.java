package dev.fun.hello.entities;

public class Product {
	
	private Long id;
	private String title;
	private Float price;
	
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
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Product() {
		
	}

	public Product(String title, Float price) {
		this.title = title;
		this.price = price;
	}
	
	public Product(Long id, String title, Float price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s_{id: %d, title: %s, price: %f}", this.getClass().getSimpleName(), id, title, price);
	}
	
}

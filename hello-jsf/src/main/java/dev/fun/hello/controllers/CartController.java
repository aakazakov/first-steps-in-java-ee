package dev.fun.hello.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import dev.fun.hello.entities.Cart;
import dev.fun.hello.entities.Product;

@Named
@SessionScoped
public class CartController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	
	public CartController() {
		cart = new Cart();
	}

  public void addToCart(Product p) {
  	cart.getProducts().add(p);
  }

	public void removeFromCart(Product p) {
		cart.getProducts().remove(p);
	}
	
	public List<Product> getAllProducts() {
		return cart.getProducts();
	}
	
}

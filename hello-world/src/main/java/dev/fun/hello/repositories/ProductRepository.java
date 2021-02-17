package dev.fun.hello.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.entities.Product;

public class ProductRepository {

	private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);
	
	private AtomicLong ID;
	
	private Map<Long, Product> repo;
	
	public ProductRepository() {
		repo = new HashMap<>();
		ID = new AtomicLong(0L);
	}
	
	public void add(Product p) {
		if (p.getId() == null) {
			p.setId(ID.incrementAndGet());
		}
		repo.put(p.getId(), p);
		logger.info("[ADDED] " + p);
	}
	
	public Product get(Long id) {
		return repo.get(id);
	}
	
	public List<Product> getAll() {
		return new ArrayList<>(repo.values());
	}
	
	public void delete(Long id) {
		repo.remove(id);
	}
}

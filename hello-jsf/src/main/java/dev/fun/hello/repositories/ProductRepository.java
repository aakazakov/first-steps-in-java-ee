package dev.fun.hello.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.entities.Product;

@Named
@ApplicationScoped
public class ProductRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

	private final AtomicLong ID;

	private final Map<Long, Product> repo;

	public ProductRepository() {
		repo = new ConcurrentHashMap<>();
		ID = new AtomicLong(0L);
		logger.info(getClass().getSimpleName() + " bean has been created");
	}
	
	@PostConstruct
	public void fillWithData() {
		add(new Product("Product1", 100));
		add(new Product("Product2", 200));
		add(new Product("Product3", 300));
		add(new Product("Product4", 400));
		add(new Product("Product5", 500));
	}
 
	public void add(Product p) {
		if (p.getId() == null) {
			p.setId(ID.incrementAndGet());
		}
		repo.put(p.getId(), p);
		logger.info("[ADD] " + p);
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

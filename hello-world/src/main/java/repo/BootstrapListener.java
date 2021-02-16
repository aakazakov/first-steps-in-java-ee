package repo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.fun.hello.entities.Product;
import dev.fun.hello.repositories.ProductRepository;

@WebListener
public class BootstrapListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ProductRepository productRepository = new ProductRepository();
		
		productRepository.add(new Product("Product1", 100.0f));
		productRepository.add(new Product("Product2", 200.0f));
		productRepository.add(new Product("Product3", 300.0f));
		productRepository.add(new Product("Product4", 400.0f));
		productRepository.add(new Product("Product5", 500.0f));
	}
	
}

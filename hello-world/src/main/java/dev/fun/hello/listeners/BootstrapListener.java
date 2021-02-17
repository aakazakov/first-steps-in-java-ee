package dev.fun.hello.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.fun.hello.entities.Product;
import dev.fun.hello.entities.User;
import dev.fun.hello.repositories.ProductRepository;
import dev.fun.hello.repositories.UserRepository;

@WebListener
public class BootstrapListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ProductRepository productRepository = new ProductRepository();
		UserRepository userRepository = new UserRepository();
		
		productRepository.add(new Product("Product1", 100.0f));
		productRepository.add(new Product("Product2", 200.0f));
		productRepository.add(new Product("Product3", 300.0f));
		productRepository.add(new Product("Product4", 400.0f));
		productRepository.add(new Product("Product5", 500.0f));
		productRepository.add(new Product("Product6", 600.0f));
		
		userRepository.add(new User("User1", "Admin", "Pass1"));
		userRepository.add(new User("User2", "Manager", "Pass2"));
		userRepository.add(new User("User3", "Client", "Pass3"));
		userRepository.add(new User("User4", "Client", "Pass4"));
		userRepository.add(new User("User5", "Client", "Pass5"));
		userRepository.add(new User("User6", "Client", "Pass6"));
		
		sce.getServletContext().setAttribute("productRepository", productRepository);
		sce.getServletContext().setAttribute("userRepository", userRepository);
	}	
	
}

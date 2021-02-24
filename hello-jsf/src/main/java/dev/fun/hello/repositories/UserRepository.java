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

import dev.fun.hello.entities.User;

@Named
@ApplicationScoped
public class UserRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	private final AtomicLong ID;	
	private final Map<Long, User> repo;
	
	public UserRepository() {
		repo = new ConcurrentHashMap<>();
		ID = new AtomicLong(0L);
		logger.info(getClass().getSimpleName() + " bean has been created");
	}

	@PostConstruct
	public void fillWithData() {
		add(new User("User1", "pass1", "Admin"));
		add(new User("User2", "pass2", "Manager"));
		add(new User("User3", "pass3", "Client"));
		add(new User("User4", "pass4", "Client"));

	}
	
	public void add(User u) {
		if (u.getId() == null) {
			u.setId(ID.incrementAndGet());
		}
		repo.put(u.getId(), u);
		logger.info("[ADD] " + u);
	}
	
	public User get(Long id) {
		return repo.get(id);
	}
	
	public List<User> getAll() {
		return new ArrayList<>(repo.values());
	}
	
	public void delete(Long id) {
		repo.remove(id);
	}
}

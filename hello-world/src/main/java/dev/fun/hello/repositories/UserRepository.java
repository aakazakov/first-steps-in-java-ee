package dev.fun.hello.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.fun.hello.entities.User;

public class UserRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	private final AtomicLong ID;	
	private final Map<Long, User> repo;
	
	public UserRepository() {
		repo = new HashMap<>();
		ID = new AtomicLong(0L);
	}
	
	public void add(User u) {
		if (u.getId() == null) {
			u.setId(ID.incrementAndGet());
		}
		repo.put(u.getId(), u);
		logger.info("[ADDED] " + u);
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

package dev.fun.hello.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dev.fun.hello.entities.User;
import dev.fun.hello.repositories.UserRepository;

@Named
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserRepository userRepository;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getAllUsers() {
		return userRepository.getAll();
	}
	
	public String create() {
		user = new User();
		return "/templates/user-form.xhtml?faces-redirect-true";
	}
	
	public String update(User p) {
		user = p;
		return "/templates/user-form.xhtml?faces-redirect-true";
	}
	
	public void delete(User p) {
		userRepository.delete(p.getId());
	}
	
	public String saveOrUpdate() {
		userRepository.add(user);
		return "/templates/users.xhtml?faces-redirect-true";
	}

}

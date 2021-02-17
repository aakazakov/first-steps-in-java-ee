package dev.fun.hello.entities;

public class User {
	
	private Long id;
	private String name;
	private String role;
	private String password;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public User(Long id, String name, String role, String password) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
	}
	
	public User(String name, String role, String password) {
		this.name = name;
		this.role = role;
		this.password = password;
	}
	
	public User() {
		
	}
	
	@Override
	public String toString() {
		return String.format("%s_{id: %d, name: %s, role: %s, password: %s}", 
				getClass().getSimpleName(), id, name, role, password);
	}
	
}

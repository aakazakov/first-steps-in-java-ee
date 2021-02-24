package dev.fun.hello.entities;

public class User {

	private Long id;
	private String username;
	private String password;
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(Long id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public User() {

	}
	
	@Override
	public String toString() {
		return String.format("%s_{id: %d, username: %s, pass: %s, role: %s}",
				getClass().getSimpleName(), id, username, password, role);
	}

}

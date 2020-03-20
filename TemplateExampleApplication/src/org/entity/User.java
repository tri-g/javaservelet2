package org.entity;

public class User {
	private int users_id;
	private String name;
	private String email;
	public User(int users_id, String name, String email) {
		super();
		this.users_id = users_id;
		this.name = name;
		this.email = email;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

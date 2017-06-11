package org.thinkingingis.web.model;

import org.thinkingingis.web.jsonview.Views;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
	
	String id;
	@JsonView(Views.Public.class)
	String username;

	String password;

	@JsonView(Views.Public.class)
	String email;

	@JsonView(Views.Public.class)
	String phone;

	String address;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String password, String email, String phone, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

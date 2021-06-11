package com.hexaware.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String pan;
	private String email;
	private String address;
	private String password;
	
	@OneToMany
	private List<AccountType> accounttype;
	
	
	
	public List<AccountType> getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(List<AccountType> accounttype) {
		this.accounttype = accounttype;
	}
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", pan=" + pan + ", email=" + email + ", address=" + address
				+ ", password=" + password + "]";
	}
	
	

}
